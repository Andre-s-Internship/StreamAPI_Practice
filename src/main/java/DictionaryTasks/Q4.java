package DictionaryTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Q4 {

    //Find the palindromes in the dictionary. A palindrome is a word, number, phrase, or other sequence
    // of characters which reads the same backward as forward, such as madam or racecar

    public static List<String> findPalindromes() throws IOException {
        String filePath = "src/main/java/DictionaryTasks/dictionary.txt";
        List<String> wordsStartingAtoM = new ArrayList<>();
        Files.lines(Paths.get(filePath))
                .filter(word -> !word.isEmpty() && isPalindrome(word))
                .forEach(wordsStartingAtoM::add);
        return wordsStartingAtoM;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
