package lab.java8;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DataFilter {
    @DataProcessor
    public static String filterAdult(String data) {
        String adult;
        adult = Arrays.stream(data.split(","))
                .map(s -> s.split(":"))
                .filter(arr -> Integer.parseInt(arr[1]) >= 18)
                .map(arr -> arr[0])
                .collect(Collectors.joining(""));
        return adult;
    }

    @DataProcessor
    public static String filterChild(String data) {
        String child;
        child = Arrays.stream(data.split(","))
                .map(s -> s.split(":"))
                .filter(arr -> Integer.parseInt(arr[1]) < 18)
                .map(arr -> arr[0])
                .collect(Collectors.joining(""));
        return child;
    }
}
