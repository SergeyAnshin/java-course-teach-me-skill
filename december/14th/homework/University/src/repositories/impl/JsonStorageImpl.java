package repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import entities.Group;
import entities.Student;
import entities.University;
import repositories.Storage;

import java.io.*;
import java.util.*;

public class JsonStorageImpl<T> implements Storage<T> {
    private File resultFile;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void add(T entity) {
        if (entity != null) {
            initializeFileObjectDependingOnEntity(entity);
            writeEntityToFile(entity);
        } else {
            System.out.println("You are trying to add an empty entity with a class " + entity.getClass());
        }
    }

    @Override
    public T getEntityById(int entityId) {
        return null;
    }

    private void initializeFileObjectDependingOnEntity(T entity) {
        if (Student.class.equals(entity.getClass())) {
            resultFile = new File("students.txt");
        } else if (Group.class.equals(entity.getClass())) {
            resultFile = new File("groups.txt");
        } else if (University.class.equals(entity.getClass())) {
            resultFile = new File("universities.txt");
        }
    }

    private void writeEntityToFile(T entity) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile, true))) {
            String jsonEntity = objectMapper.writeValueAsString(entity);
            bufferedWriter.append(jsonEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getEntities() {
        if (resultFile != null) {
            return readEntitiesFromFile();
        } else {
            return Collections.emptyList();
        }
    }

    private List<T> readEntitiesFromFile() {
        List<T> entities = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resultFile))) {
            String jsonEntity = "{\"id\":1,\"firstName\":\"Tom\",\"lastName\":\"Ford\",\"gradeList\":[1,3,4]}";
            T entity = objectMapper.readValue(jsonEntity, new TypeReference<>(){});
            entities.add(entity);
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return entities;

//        List<T> entities = new ArrayList<>();
//        try {
//            ObjectReader objectReader = objectMapper.reader();
//            Iterator<T> iterator = objectReader.createParser(resultFile).readValuesAs(new TypeReference<>(){});
//            for (Iterator<T> it = iterator; it.hasNext(); ) {
//                T en = it.next();
//                entities.add(en);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return entities;
    }

    @Override
    public boolean contains(T entity) {
        return false;
    }
}
