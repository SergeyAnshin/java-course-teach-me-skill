package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Cat {

    private String myMame;

//    @Qualifier("nameTwo") используем если имена и типы методов совпадают (он четко определяет какой бин использовать)
    public Cat(String myMame) {
        this.myMame = myMame;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "myMame='" + myMame + '\'' +
                '}';
    }
}
