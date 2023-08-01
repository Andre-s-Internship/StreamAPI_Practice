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

class Q2Test {
    @Test
    @DisplayName("Test for dictionary task 2")
    void DictionaryQ2() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        Scanner sc;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> stringsFromNtoEnd = new ArrayList<>();
        while(sc.hasNext()) {
            String string = sc.next();
            if(string.charAt(0) >= 'n') {
                stringsFromNtoEnd.add(string);
            }
        }
        assertEquals(Q2.findWordsStartingNtoEnd(), stringsFromNtoEnd);

    }

}