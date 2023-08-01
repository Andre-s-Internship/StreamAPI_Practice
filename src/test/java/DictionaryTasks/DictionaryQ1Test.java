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

class DictionaryQ1Test {
    //Find the words starting with letters a to m.
    @Test
    @DisplayName("Test for Dictionary Q1")
    void DictionaryQ1() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        Scanner sc;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> stringsFromAtoM = new ArrayList<>();
        while(sc.hasNext()) {
            String string = sc.next();
            if(string.charAt(0) >= 'a' && string.charAt(0) <= 'm') {
                stringsFromAtoM.add(string);
            }
        }
        assertEquals(Q1.findWordsStartingAtoM(), stringsFromAtoM);
    }


}