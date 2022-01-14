package queries;

public class TaskQueriesStorage {
    /**
     * first param - task name
     * second param - task category id
     * third param - project id
     * fourth param - author id
     */
    public static final String SAVE_QUERY =
            "SELECT create_task(?, ?, ?, ?)";

    public static final String EXIST_QUERY =
            "SELECT * FROM task WHERE id = ?";

    public static final String FIND_ALL_QUERY =
            "SELECT * FROM task";

    public static final String FIND_BY_ID_QUERY =
            "SELECT * FROM task WHERE id = ?";

    public static final String UPDATE_QUERY =
            "UPDATE task SET ___ WHERE ____";

    public static final String DELETE_QUERY =
            "DELETE FROM task WHERE id = ?";
}
