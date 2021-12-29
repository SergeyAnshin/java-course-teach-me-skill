import org.postgresql.Driver;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/user_db";
        String username = "postgres";
        String password = "postgres";
        String createTableStatement = "create table users(" +
                "id SERIAL PRIMARY KEY," +
                "name varchar(30) not null," +
                "age int not null" +
                ")";
        String addValueOneStatement = "insert into users (name, age) values('Ann', 25)";
        String addValueTwoStatement = "insert into users (name, age) values('Tom', 15)";
        String getAllObjectStatement = "select * from users";
        String getAllObjectStatementWithCondition = "select * from users where age>20";
        String addValueOnePreparedStatement = "insert into users (name, age) values(?, ?)";
        String deleteObjectByConditionStatement = "delete from users where name='Bob'";

        try {
            Driver driver = new Driver();

//            Class.forName("com.postgresql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
//                Statement statement = connection.createStatement();
//                statement.execute(createTableStatement);
//                statement.execute(addValueOneStatement);
//                statement.execute(addValueTwoStatement);
//
//                ResultSet resultSet = statement.executeQuery(getAllObjectStatementWithCondition);
//                while (resultSet.next()) {
//                    System.out.println("id - " + resultSet.getInt(1) +
//                            ",name - " + resultSet.getString(2) +
//                            ",age - " + resultSet.getInt(3));
//                }

//                PreparedStatement preparedStatement = connection.prepareStatement(addValueOnePreparedStatement);
//                preparedStatement.setString(1, "Bob");
//                preparedStatement.setInt(2, 30);
//                preparedStatement.execute();
//
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery(getAllObjectStatement);
//                while (resultSet.next()) {
//                    System.out.println("id - " + resultSet.getInt(1) +
//                            ",name - " + resultSet.getString(2) +
//                            ",age - " + resultSet.getInt(3));
//                }

//                Statement statement = connection.createStatement();
//                statement.execute(deleteObjectByConditionStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
