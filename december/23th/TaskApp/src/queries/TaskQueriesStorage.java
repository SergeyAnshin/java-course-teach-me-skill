package queries;

public class TaskQueriesStorage {
    public static final String SAVE_QUERY =
            "INSERT INTO tasks (name, task_category_id, author) VALUES (?, ?, ?)";

    public static final String EXIST_QUERY =
            "SELECT id FROM tasks WHERE id = ?";

    public static final String FIND_ALL_QUERY =
            "SELECT ts.id, ts.name, tc.*, ur.*, urs.* " +
            "FROM tasks ts " +
            "INNER JOIN task_categories tc on ts.task_category_id = tc.id " +
            "INNER JOIN users ur on ts.author = ur.id " +
            "INNER JOIN users urs on ts.executor = urs.id ";

    public static final String FIND_BY_ID_QUERY =
            "SELECT ts.id, ts.name, tc.*, ur.*, urs.* " +
            "FROM tasks ts " +
            "INNER JOIN task_categories tc on ts.task_category_id = tc.id " +
            "INNER JOIN users ur on ts.author = ur.id " +
            "INNER JOIN users urs on ts.executor = urs.id " +
            "WHERE ts.id = ?";
}
