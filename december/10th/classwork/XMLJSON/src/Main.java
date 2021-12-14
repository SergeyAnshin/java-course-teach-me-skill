import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groups.Group;
import groups.Person;
import universities.Menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new groups.Person(new Date(System.currentTimeMillis()), "Tom", "Ford");
        Person person1 = new groups.Person(new Date(System.currentTimeMillis()), "Bob", "Green");
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        Group group = new Group("groupOne", list);

//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            System.out.println(objectMapper.writeValueAsString(group));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(group);
            Group group1 = objectMapper.readValue(json, Group.class);
            System.out.println(objectMapper.writeValueAsString(group));
            System.out.println(group1.getName());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu();
        menu.start();
    }
}
