package queries;

public class TaskCategoryQueriesStorage {

    public static final String SAVE_QUERY = "INSERT INTO task_category (name) VALUES (?)";

    public static final String EXIST_QUERY = "SELECT * FROM task_category WHERE name = ?";

    public static final String FIND_ALL_QUERY = "SELECT * FROM task_category";

    public static final String FIND_BY_ID_QUERY = "SELECT * FROM task_category WHERE id = ?";

    public static final String UPDATE_QUERY = "UPDATE task_category SET name = ? WHERE id = ?";

    public static final String DELETE_QUERY = "DELETE FROM task_category WHERE id = ?";
}
