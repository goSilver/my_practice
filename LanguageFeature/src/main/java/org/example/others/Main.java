package org.example.others;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ${USER}
 * @datetime ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> list = Arrays.asList("a", "b", "c");
        // Convert the list to a map using a lambda expression
        Map<String, String> map = list.stream()
                .collect(Collectors.toMap(s -> s, s -> ""));
        // Print the map
        System.out.println(map);
    }
}