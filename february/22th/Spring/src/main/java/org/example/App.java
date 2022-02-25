package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfiguration.class);
        System.out.println(applicationContext.getBean("cat"));
        System.out.println(applicationContext.getBean("dog"));
        System.out.println(applicationContext.getBean("user"));
        applicationContext.close();
    }
}
