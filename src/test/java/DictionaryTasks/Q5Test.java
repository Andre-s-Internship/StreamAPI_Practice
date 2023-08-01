package DictionaryTasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Q5Test {
    //Count the vowels used in words.
    @Test
    @DisplayName("Test for dictionary Q5")
    void Q5() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        Scanner scanner = new Scanner(new File(filePath));
        long sum = 0;
        while(scanner.hasNext()) {
            sum += Q5.countVowelsOfString(scanner.next());
        }
        assertEquals(Q5.countVowels(), sum);
    }
}