package DictionaryTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Q6 {
    //Find the words starting with the letter a, and ends with the letter z.
    public static List<String> wordsAZ() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        List<String> wordsStartingNtoEnd = new ArrayList<>();
        Files.lines(Paths.get(filePath))
                .filter(word -> !word.isEmpty() && word.charAt(0) == 'a' && word.charAt(word.length()-1) == 'z')
                .forEach(wordsStartingNtoEnd::add);
        return wordsStartingNtoEnd;
    }
}
