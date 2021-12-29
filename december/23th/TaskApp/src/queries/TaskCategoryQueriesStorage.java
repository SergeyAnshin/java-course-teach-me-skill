package queries;

public class TaskCategoryQueriesStorage {
    public static final String SAVE_QUERY =
            "INSERT INTO task_categories (name) VALUES (?)";

    public static final String EXIST_QUERY =
            "SELECT name FROM task_categories WHERE name = ?";

    public static final String FIND_ALL_QUERY =
            "SELECT * FROM task_categories";

    public static final String FIND_BY_ID_QUERY =
            "SELECT * FROM task_categories WHERE id = ?";
}
