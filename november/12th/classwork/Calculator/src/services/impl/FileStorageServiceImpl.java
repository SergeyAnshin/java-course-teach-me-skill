package services.impl;

import services.StorageService;
import storages.Storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileStorageServiceImpl implements StorageService<String> {
    private static final String PATH = "D:\\programming\\java-course-teach-me-skill\\november\\12th\\classwork\\Calculator\\src\\resources";
    private Storage<File> storage = new Storage<>(new File(PATH + "\\storage.txt"));

    @Override
    public List<String> getAllStorage() {
        List<String> expressionsAndResult = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(storage.getStorage()))) {
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                expressionsAndResult.add(row);
            }
        } catch (IOException e) {
            System.out.println("The history of operations is empty");
        }
        return expressionsAndResult;
    }

    @Override
    public void addInStorage(String elements) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(storage.getStorage(), true))) {
            bufferedWriter.write(elements + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLastAddedItem() {
        String lastLine = "Empty line";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(storage.getStorage()))) {
            String row;
            while (true) {
                row = bufferedReader.readLine();
                if (row != null) {
                    lastLine = row;
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastLine;
    }

    @Override
    public boolean contains(String element) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(storage.getStorage()))) {
            Stream<String> buff;
            while ((buff = bufferedReader.lines()) != null) {
                if (buff.anyMatch(s -> s.equals(element))) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
