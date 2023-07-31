package DictionaryTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Q5 {
    //Count the vowels used in words.
    public static long countVowels() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        Map<String, Integer> countVowelsMap = new HashMap<>(); //word -> count of vowels
        Files.lines(Paths.get(filePath))
                .forEach(word -> countVowelsMap.put(word, countVowelsOfString(word)));
        return countVowelsMap.values().stream().mapToInt(Integer::intValue).sum();
    }
    public static Integer countVowelsOfString(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char y = s.charAt(i);
            if (y == 'a' || y == 'e' || y == 'i' || y == 'o' || y == 'u') count ++;
        }
        return count;
    }
}
