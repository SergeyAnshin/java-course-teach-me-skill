package queries;

public class ProjectQueriesStorage {
    /**
     * first param = project name
     * second param = project key
     * third param = author id
     */
    public static final String SAVE_QUERY =
            "SELECT save_project(?, ?, ?)";

    public static final String EXIST_QUERY =
            "SELECT name, key FROM project WHERE name = ? OR key = ?";

    public static final String FIND_ALL_QUERY =
            "SELECT * FROM project";

    private static final String FIND_BY_WITHOUT_CONDITIONAL_PART_QUERY =
            "SELECT p.id AS project_id, p.\"name\" AS project_name, p.\"key\" AS project_key, " +
                    "td.\"id\" AS task_details_id, td.task_id AS task_details_task_id, " +
                    "t.\"name\" AS task_name, t.task_category_id AS task_task_category_id, " +
                    "tc.\"name\" AS task_category_name, " +
                    "td.author AS task_details_author, " +
                    "a.\"login\" AS author_login, a.email AS author_email, a.\"password\" AS author_password, " +
                    "td.executor AS task_details_executor, " +
                    "e.\"login\" AS executor_login, e.email AS executor_email, e.\"password\" AS executor_password " +
            "FROM project p " +
            "INNER JOIN task_details td ON p.\"id\" = td.project_id " +
            "LEFT JOIN task t ON td.task_id = t.\"id\" " +
            "LEFT JOIN task_category tc ON t.task_category_id = tc.\"id\" " +
            "INNER JOIN \"user\" a ON td.author = a.\"id\" " +
            "LEFT JOIN \"user\" e ON td.executor = e.\"id\" ";

    public static final String FIND_BY_ID_QUERY = FIND_BY_WITHOUT_CONDITIONAL_PART_QUERY + "WHERE p.id = ? ORDER BY p.id";

    public static final String FIND_BY_USER_QUERY = FIND_BY_WITHOUT_CONDITIONAL_PART_QUERY + "WHERE td.author = ? ORDER BY p.id";

    public static final String UPDATE_QUERY =
            "UPDATE project SET name = ?, key = ? WHERE id = ?";

    public static final String TRANSFER_PROJECT_TO_ANOTHER_AUTHOR_QUERY =
            "UPDATE task_details SET author = ? WHERE project_id = ?";

    public static final String DELETE_QUERY =
            "SELECT delete_project(?)";
}

