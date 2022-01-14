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

/**
 * исправить каскады
 * добавить создание
 */
public class Main {
    public static void main(String[] args) throws SQLException {
//        MainMenu mainMenu = new MainMenu();
//        mainMenu.startMenu();

        TaskDetails taskDetails = new TaskDetails(17L, new Project(6L), new Task(18L), new User(3L), null);
        Connection connection = TaskManagerAppDBConnector.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE task_details SET project_id = ?, task_id = ?, author = ?, executor = ? WHERE id = ?");
        preparedStatement.setLong(1, taskDetails.getProject().getId());
        preparedStatement.setLong(2, taskDetails.getTask().getId());
        preparedStatement.setLong(3, taskDetails.getAuthor().getId());
        if (taskDetails.getExecutor() == null) {
            preparedStatement.setNull(4, null);
        }
        preparedStatement.setLong(5, taskDetails.getId());
        System.out.println(preparedStatement.executeUpdate());
    }
}
