package DictionaryTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class Q3 {
    //Group the dictionary words by their first three letters
    public static Map<String, Long> groupByFirstThreeLetters() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        return Files.lines(Paths.get(filePath))
                .filter(s -> s.length() >= 3)
                .map(s -> s.substring(0, 3))
                .collect(Collectors.groupingBy(
                        String::toString,
                        Collectors.counting()
                ));
    }
}
