package lab.java4;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class CopyFile {

    public static void copyFile() {
        String sourceFile = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\lab.java1.java4\\source.txt"; //исходный файл
        String destinationFile = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\lab.java1.java4\\destination.txt"; //файл, в который копируем

        try (FileInputStream from = new FileInputStream(sourceFile);
             FileOutputStream to = new FileOutputStream(destinationFile)) {
            int length;
            while ((length = from.read()) != -1) {
                to.write(length);
            }
            System.out.println("Файл скопирован");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (AccessDeniedException e) {
            System.out.println("Ошибка доступа к файлу");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при копировании файла:" + e.getMessage());
        }
    }
}
