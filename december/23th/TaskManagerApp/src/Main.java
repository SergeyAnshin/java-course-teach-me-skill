import concole.ConsoleColors;
import concole.ConsoleEntityManager;
import concole.impl.ConsoleTaskManagerImpl;
import connections.TaskManagerAppDBConnector;
import controllers.MainMenu;
import entities.*;
import services.ProjectService;
import services.TaskCategoryService;
import services.UserService;
import services.impl.ProjectServiceImpl;
import services.impl.TaskCategoryServiceImpl;
import services.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * VALIDATOR - SERVICE - QUERIES - ENUM - CONNECTIONS - ENTITY - REPO проверены
 *
 *
 *
 * TaskDetailsRepo доделать
 * TaskRepo доделать
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.startMenu();
    }
}
