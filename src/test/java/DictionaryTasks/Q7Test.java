package DictionaryTasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Q7Test {
    @Test
    @DisplayName("Test for Dictionary Q7")
    void DictionaryQ1() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        Scanner sc;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int maxLength = 0;
        String maxString = "";
        while(sc.hasNext()) {
            String string = sc.next();
            if(string.length() > maxLength) {
                maxLength = string.length();
                maxString = string;
            }
        }
        assertEquals(Q7.longestWordInDictionary(), maxString);
    }

}