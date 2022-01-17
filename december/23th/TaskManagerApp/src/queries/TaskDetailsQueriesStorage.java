package queries;

public class TaskDetailsQueriesStorage {

    public static final String SAVE_QUERY = "INSERT INTO task_details (project_id, author) VALUES (?, ?)";

    public static final String EXIST_QUERY = "SELECT * FROM task_details WHERE id = ?";

    public static final String FIND_ALL_QUERY = "SELECT * FROM task_details";

    public static final String FIND_BY_ID_QUERY = "SELECT * FROM task_details WHERE id = ?";

    public static final String UPDATE_QUERY =
            "UPDATE task_details SET project_id = ?, task_id = ?, author = ?, executor = ? WHERE id = ?";

    public static final String DELETE_QUERY = "DELETE FROM task_details WHERE id = ?";
}
