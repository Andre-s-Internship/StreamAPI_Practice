package DictionaryTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Q7 {
    //Find the longest word in the dictionary
    public static String longestWordInDictionary() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        Map<String, Integer> wordLengthMap = new HashMap<>();
        Files.lines(Paths.get(filePath))
                .forEach(word -> wordLengthMap.put(word, word.length()));
        return wordLengthMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();

    }
}
