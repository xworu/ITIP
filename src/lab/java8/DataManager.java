package lab.java8;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private String data;
    private String adult;
    private String child;

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try {
            data = Files.readString(Path.of(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(processors.size());
        for (Object processor : processors) {
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    try {
                        adult = DataFilter.filterAdult(data);
                        child = DataFilter.filterChild(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        executorService.shutdown();
    }

    public void saveData(String destination) {
        try (FileWriter writer = new FileWriter(destination)) {
            writer.write("Can drink:\n");
            writer.write(adult);
            writer.write("\n\nCan't drink:");
            writer.write(child);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
