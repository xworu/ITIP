package lab.java4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ExceptionLogger {
    private static final String FILE_PATH = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\lab.java1.java4\\exception.log";
    public static void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            writer.write(LocalDateTime.now() + ": " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("Ошибка при записи в файл exception.log: " + ex.getMessage());
        }
    }
}
