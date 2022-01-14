import concole.ConsoleColors;
import connections.TaskManagerAppDBConnector;
import controllers.MainMenu;
import entities.*;
import services.TaskCategoryService;
import services.UserService;
import services.impl.TaskCategoryServiceImpl;
import services.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * исправить каскады
 * добавить создание
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.startMenu();

    }
}
