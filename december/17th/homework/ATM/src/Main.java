import configuration.AppContextConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BalanceIncreaser;
import service.BalanceReducer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppContextConfig.class);

        Thread topUpThread = new Thread((BalanceIncreaser) applicationContext.getBean("balanceIncreaser"));
        Thread withdrawThread = new Thread((BalanceReducer) applicationContext.getBean("balanceReducer"));
        topUpThread.start();
        withdrawThread.start();

    }
}
