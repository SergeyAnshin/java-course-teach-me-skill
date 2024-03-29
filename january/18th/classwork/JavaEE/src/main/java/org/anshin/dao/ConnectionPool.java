package org.anshin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {
    INSTANCE;

    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> givenAwayConnections;

    private final static int DEFAULT_FREE_CONNECTIONS_POOL_SIZE = 5;
    private static final String URL = "jdbc:mysql://localhost:3306/calculator_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_FREE_CONNECTIONS_POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();

        for (int i = 0; i < DEFAULT_FREE_CONNECTIONS_POOL_SIZE; i++) {
            try {
                freeConnections.offer(new ProxyConnection(DriverManager.getConnection(URL, USERNAME, PASSWORD)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void putConnectionBackIntoConnectionPool(Connection connection) {
        if (connection.getClass().equals(ProxyConnection.class)) {
            givenAwayConnections.remove(connection);
            freeConnections.offer((ProxyConnection) connection);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void destroyConnectionPool() {
        for (int i = 0; i < DEFAULT_FREE_CONNECTIONS_POOL_SIZE; i++) {
            try {
                freeConnections.take().actualClose();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
