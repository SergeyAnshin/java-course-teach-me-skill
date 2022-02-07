package org.anshin.repository;

import java.lang.reflect.InvocationTargetException;
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
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/calculator_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_FREE_CONNECTIONS_POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();

        for (int i = 0; i < DEFAULT_FREE_CONNECTIONS_POOL_SIZE; i++) {
            try {
                Class.forName(DRIVER_NAME).getDeclaredConstructor().newInstance();
                freeConnections.offer(new ProxyConnection(DriverManager.getConnection(URL, USERNAME, PASSWORD)));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                    NoSuchMethodException | ClassNotFoundException | SQLException e) {
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
