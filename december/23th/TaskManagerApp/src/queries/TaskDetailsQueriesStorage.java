package queries;

public class TaskDetailsQueriesStorage {
    public static final String SAVE_QUERY =
            "INSERT INTO task_details (project_id, author) VALUES (?, ?)";

    public static final String EXIST_QUERY =
            "SELECT _____ FROM task_details WHERE ___";

    public static final String FIND_ALL_QUERY =
            "SELECT * FROM task_details";

    public static final String FIND_BY_ID_QUERY =
            "";

    public static final String UPDATE_QUERY =
            "UPDATE task_details SET ____ WHERE id = ____";

    public static final String DELETE_QUERY =
            "";
}
