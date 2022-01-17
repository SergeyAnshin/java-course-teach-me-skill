package enums;

import entities.TaskCategory;

public enum DefaultTaskCategory {
    TO_DO(new TaskCategory("To do")), IN_PROGRESS(new TaskCategory("In progress")),
    DONE(new TaskCategory("Done"));

    private TaskCategory category;

    DefaultTaskCategory(TaskCategory category) {
        this.category = category;
    }

    public TaskCategory getCategory() {
        return category;
    }
}
