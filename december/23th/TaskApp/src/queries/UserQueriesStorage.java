package queries;

public class UserQueriesStorage {
    public static final String SAVE_QUERY =
            "INSERT INTO users (login, password, email) VALUES (?, ?, ?)";

    public static final String EXIST_QUERY =
            "SELECT login, email FROM users WHERE login = ? or email = ?";

    public static final String FIND_ALL_QUERY =
            "SELECT * FROM users";

    public static final String FIND_BY_ID_QUERY =
            "SELECT * FROM users WHERE id = ?";
}
