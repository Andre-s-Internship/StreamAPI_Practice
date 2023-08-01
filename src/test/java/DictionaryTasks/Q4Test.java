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

class Q4Test {

    //Find the palindromes in the dictionary. A palindrome is a word, number, phrase, or other sequence
    // of characters which reads the same backward as forward, such as madam or racecar
    @Test
    @DisplayName("Test for Dicitonary task 4")
    void Q4() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        Scanner sc = new Scanner(new File(filePath));
        List<String> palindromes = new ArrayList<>();
        while(sc.hasNext()) {
            String s = sc.next();
            if(Q4.isPalindrome(s)) {
                palindromes.add(s);
            }
        }
        assertEquals(Q4.findPalindromes(), palindromes);
    }

}