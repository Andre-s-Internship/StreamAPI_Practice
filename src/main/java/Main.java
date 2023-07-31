
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * Movie and Country questions
         */

        System.out.println("//////////////////////////////");
        System.out.println("Q1 Find the most populated city of each continent");
        System.out.println(Tasks.Q1.getMostPopulatedCitiesOfEachContinent());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q2 Find the number of movies of each director");
        System.out.println(Tasks.Q2.findNumberOfMoviesOfDirectors());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q3 Find the number of genres of each director's movies");
        System.out.println(Tasks.Q3.findNumberOfGenresOfDirectors());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q4 Find the highest populated capital city");
        System.out.println(Tasks.Q4.highestPopulatedCapitalCity());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q5 Find the highest populated capital city of each continent");
        System.out.println(Tasks.Q5.getMostPopulatedCitiesOfEachContinent());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q6 Sort the countries by number of their cities in descending order");
        System.out.println(Tasks.Q6.sortCountriesByNumberOfCities());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q7 Find the list of movies having the genres Drama and Comedy only");
        System.out.println(Tasks.Q7.findExactGenres());
        System.out.println();


        System.out.println("//////////////////////////////");
        System.out.println("Q8 Group the movies by the year and list them");
        System.out.println(Tasks.Q8.groupMoviesByYears());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q9 Sort the countries by their population densities " +
                "in descending order ignoring zero population countries");
        System.out.println(Tasks.Q9.sortCountriesByPopulation());
        System.out.println();


        System.out.println("//////////////////////////////");
        System.out.println("Q11 Find the minimum, the maximum and the average population of world countries.");
        System.out.println(Tasks.Q11.countryPopulationValues());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q12 Find the minimum, the maximum and the average population of each continent.");
        System.out.println(Tasks.Q12.countryPopulationValuesByContinents());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q13 Find the countries with the minimum and the maximum population.");
        System.out.println(Tasks.Q13.minAndMaxCountriesByPopulation());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q14 Find the countries of each continent with the minimum and the maximum population.");
        System.out.println(Tasks.Q14.countryPopulationValuesByContinents());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q15 Group the countries by continent, and then sort the countries in continent by number of cities in each continent.");
        System.out.println(Tasks.Q15.groupAndSortCountriesByNumberOfCities());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q16 Find the cities with the minimum and the maximum population in countries.");
        System.out.println(Tasks.Q16.minMaxCitiesOfCountries());
        System.out.println();


        System.out.println("//////////////////////////////");
        System.out.println("Q18 Find the year when the maximum number of movie is available");
        System.out.println(Tasks.Q18.findMovieMaxYear());
        System.out.println();

        /**
         * Dictionary tasks
         */
        System.out.println("//////////////////////////////");
        System.out.println("Q1 Find the words starting with letters a to m.");
        //there are too many words there, that's why only size is printed
        System.out.println(DictionaryTasks.Q1.findWordsStartingAtoM().size() + " words");
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q2 Find the words starting with the letter n to the end of the dictionary");
        //there are too many words there, that's why only size is printed
        System.out.println(DictionaryTasks.Q2.findWordsStartingNtoEnd().size() + " words");
        System.out.println();


        System.out.println("//////////////////////////////");
        System.out.println("Q3 Group the dictionary words by their first three letters");
        //there are too many words there, that's why only size is printed
        System.out.println(DictionaryTasks.Q3.groupByFirstThreeLetters().size() + " words");
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q4 Find the palindromes in the dictionary.");
        //there are too many words there, that's why only size is printed
        System.out.println(DictionaryTasks.Q4.findPalindromes().size() + " words in dictionary are palindromes");
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q5 Count the vowels used in words.");
        System.out.println(DictionaryTasks.Q5.countVowels() + " vowels in dictionary.txt");
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q6 Find the words starting with the letter a, and ends with the letter z.");
        System.out.println(DictionaryTasks.Q6.wordsAZ().size() + " words starting with the letter a, and ends with the letter z");
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Q7 Find the longest word in the dictionary");
        System.out.println(DictionaryTasks.Q7.longestWordInDictionary() + " is the longest word in the dictionary");
        //There are many words with 12 letters(which is the longest, the method returns the first occurrence alphabetically)
        System.out.println();




    }







}
