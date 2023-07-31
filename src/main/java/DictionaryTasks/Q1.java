package DictionaryTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Q1 {
    //Find the words starting with letters a to m.

    public static List<String> findWordsStartingAtoM() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        List<String> wordsStartingAtoM = new ArrayList<>();
        Files.lines(Paths.get(filePath))
                .filter(word -> !word.isEmpty() && word.charAt(0) >= 'a' && word.charAt(0) <= 'm')
                .forEach(wordsStartingAtoM::add);
        return wordsStartingAtoM;
    }

}
