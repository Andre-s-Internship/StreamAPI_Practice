package DictionaryTasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Q3Test {
    @Test
    @DisplayName("Test for Dictionary Q3")
    void Q3() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        Scanner sc;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Map<String, Long> result = new HashMap<>();

        while(sc.hasNext()) {
            String line = sc.next();
                if (line.length() >= 3) {
                    String key = line.substring(0, 3);
                    result.put(key, result.getOrDefault(key, 0L) + 1);
                }
            }
        assertEquals(Q3.groupByFirstThreeLetters(), result);

    }
}