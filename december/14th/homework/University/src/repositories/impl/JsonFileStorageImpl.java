package repositories.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import repositories.Storage;

import java.io.*;
import java.util.*;

public class JsonFileStorageImpl<T> implements Storage<T> {
    private File fileForStoringEntities;
    private Class<T> storedEntityClass;
    private ObjectMapper objectMapper = new ObjectMapper();

    public JsonFileStorageImpl(File fileForStoringEntities, Class<T> storedEntityClass) {
        this.fileForStoringEntities = fileForStoringEntities;
        this.storedEntityClass = storedEntityClass;
    }

    @Override
    public void add(T entity) {
        if (entity != null) {
            writeEntityToFile(entity, fileForStoringEntities);
        } else {
            System.out.println("You are trying to add an empty entity.");
        }
    }

    private void writeEntityToFile(T entity, File storageFile) {
        try (FileWriter fileWriter = new FileWriter(storageFile, true)) {
            objectMapper.writeValue(fileWriter, entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getEntities() {
        return readEntitiesFromFile(fileForStoringEntities);
    }

    private List<T> readEntitiesFromFile(File storageFile) {
        List<T> entities = new ArrayList<>();

        char[] charsBuffer = new char[500];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(storageFile))) {
            StringBuilder jsonEntity = new StringBuilder();
            while (bufferedReader.read(charsBuffer) != -1) {
                for (int i = 0; i < charsBuffer.length - 1; i++) {
                    if (charsBuffer[i] != (char) 0) {
                        jsonEntity.append(charsBuffer[i]);
                        if (charsBuffer[i] == '}' && (charsBuffer[i + 1] == '{' || charsBuffer[i + 1] == (char) 0)) {
                            T en = objectMapper.readValue(jsonEntity.toString(), storedEntityClass);
                            entities.add(en);
                            jsonEntity.delete(0, jsonEntity.length());
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public boolean exist(T entity) {
        if (fileForStoringEntities != null && fileForStoringEntities.exists()) {
            return readEntitiesFromFile(fileForStoringEntities).stream()
                    .anyMatch(currentEntity -> currentEntity.equals(entity));
        } else {
            return false;
        }
    }
}
