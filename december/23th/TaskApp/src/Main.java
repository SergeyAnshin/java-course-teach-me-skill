import entities.Task;
import entities.TaskCategory;
import entities.User;
import repositories.impl.TaskCategoryRepositoryImpl;
import repositories.impl.TaskRepositoryImpl;
import repositories.impl.UserRepositoryImpl;
import services.EntityService;
import services.impl.TaskCategoryServiceImpl;
import services.impl.TaskServiceImpl;
import services.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1L,"ser", "1", "ser@gmail.com");
        User user2 = new User("ser", "12", "bob@gmail.com");
        User user3 = new User("ght", "123", "ser@gmail.com");
        User user4 = new User(4L,"bob", "1234", "bob@gmail.com");
        User user5 = new User(6L,"tom", "12345", "tom@gmail.com");

        TaskCategory taskCategory1 = new TaskCategory(1L,"To do");
        TaskCategory taskCategory2 = new TaskCategory(2L,"In progress");
        TaskCategory taskCategory3 = new TaskCategory(3L,"Done");

        Task task1 = new Task(4L,"task 1", taskCategory1, user1);
        Task task2 = new Task(5L,"task 2", taskCategory2, user1);
        Task task3 = new Task(6L, "task 3", taskCategory3, user4);

        EntityService<User> userEntityService = new UserServiceImpl();
        EntityService<Task> taskEntityService = new TaskServiceImpl();
        EntityService<TaskCategory> taskCategoryService = new TaskCategoryServiceImpl();


        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();
        TaskCategoryRepositoryImpl taskCategoryRepository = new TaskCategoryRepositoryImpl();
        System.out.println(taskRepository.findById(1L));
    }
}
