package org.example;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Cat cat;
    private Dog dog;

    public User(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }

    public void init() {
        System.out.println("user init");
    }

    public void destroy() {
        System.out.println("user destroy");
    }

    @Override
    public String toString() {
        return "User{" +
                "cat=" + cat +
                ", dog=" + dog +
                '}';
    }
}
