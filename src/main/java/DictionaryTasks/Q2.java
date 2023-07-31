package DictionaryTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Q2 {
    //Find the words starting with the letter n to the end of the dictionary
    public static List<String> findWordsStartingNtoEnd() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        List<String> wordsStartingNtoEnd = new ArrayList<>();
        Files.lines(Paths.get(filePath))
                .filter(word -> !word.isEmpty() && word.charAt(0) >= 'n')
                .forEach(wordsStartingNtoEnd::add);
        return wordsStartingNtoEnd;

    }
}
