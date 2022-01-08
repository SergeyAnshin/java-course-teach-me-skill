package connections;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TaskManagerAppDBConnector {
    private static TaskManagerAppDBConnector instance;
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/task_manager_app_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private TaskManagerAppDBConnector(){}

    public static TaskManagerAppDBConnector getInstance() {
        if (instance == null) {
            instance = new TaskManagerAppDBConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME).getDeclaredConstructor().newInstance();
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
