package queries;

public class TaskQueriesStorage {

    /**
     * First parameter - task.getName();
     * Second parameter - task.getTaskCategory().getId();
     * Third parameter - task.getTaskDetails().getProject().getId();
     * Fourth parameter - task.getTaskDetails().getAuthor().getId();
     */
    public static final String SAVE_QUERY = "SELECT create_task(?, ?, ?, ?)";

    public static final String EXIST_QUERY = "SELECT * FROM task WHERE id = ?";

    public static final String FIND_ALL_QUERY = "SELECT * FROM task";

    public static final String FIND_BY_ID_QUERY = "SELECT * FROM task WHERE id = ?";

    public static final String UPDATE_QUERY = "UPDATE task SET name = ?, task_category_id = ? WHERE id = ?";

    public static final String DELETE_QUERY = "DELETE FROM task WHERE id = ?";

    public static final String CHANGE_TASK_CATEGORY_QUERY =
            "UPDATE task SET task_category_id = ? WHERE task_category_id = ?";
}
