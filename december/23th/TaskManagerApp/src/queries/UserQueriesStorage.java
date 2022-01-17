package queries;

public class UserQueriesStorage {

    public static final String SAVE_QUERY = "INSERT INTO \"user\" (login, email, password) VALUES (?, ?, ?)";

    public static final String EXIST_QUERY = "SELECT login, email FROM \"user\" WHERE login = ? OR email = ?";

    public static final String FIND_ALL_QUERY = "SELECT * FROM \"user\"";

    public static final String FIND_BY_ID_QUERY = "SELECT * FROM \"user\" WHERE id = ?";

    public static final String FIND_BY_LOGIN_AND_PASSWORD_QUERY =
            "SELECT * FROM \"user\" WHERE login = ? AND password = ?";

    public static final String UPDATE_QUERY = "UPDATE \"user\" SET login = ?, email = ?, password = ? WHERE id = ?";

    public static final String DELETE_QUERY = "SELECT delete_user(?)";

    public static final String FIND_BY_LOGIN_QUERY = "SELECT * FROM \"user\" WHERE login = ?";
}
