package org.example;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
public class RootConfiguration {

    @Primary // если совпадают имена методов и типы, вызовется этот метод
    @Bean
    public String name() {
        return "Cat1";
    }

    @Bean
    public String nameTwo() {
        return "Cat2";
    }

//    @Scope("prototype")
//    @Bean
//    public Cat cat() {
//        return new Cat();
//    }
//
//    @Bean
//    public Dog dog() {
//        return new Dog();
//    }
//

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public User user(Cat cat, Dog dog) {
        return new User(cat, dog);
    }
}
