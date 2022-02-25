package configuration;

import entity.ATM;
import entity.Card;
import entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.BalanceIncreaser;
import service.BalanceManager;
import service.BalanceReducer;

@Configuration
public class AppContextConfig {

    @Bean
    public ATM atm(Card card) {
        return new ATM(1, true, 20000d, card);
    }

    @Bean
    public Card card(Person cardOwner) {
        return new Card(123456789L, cardOwner, 2000d);
    }

    @Bean
    public Person cardOwner() {
        return new Person(1, "NoName", "Mask");
    }

    @Bean
    public BalanceManager balanceManager() {
        return new BalanceManager();
    }

    @Bean
    public BalanceIncreaser balanceIncreaser(ATM atm, Card card, BalanceManager balanceManager) {
        return new BalanceIncreaser(atm, card, balanceManager, 100);
    }

    @Bean
    public BalanceReducer balanceReducer(ATM atm, Card card, BalanceManager balanceManager) {
        return new BalanceReducer(atm, card, balanceManager, 100);
    }
}
