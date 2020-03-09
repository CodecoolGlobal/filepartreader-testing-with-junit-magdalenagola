import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer{

    FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically () throws IOException {
        List<String> words = turnStringIntoListOfWords();
        java.util.Collections.sort(words);
        return words;
    }



    public List getWordsContainingSubstring (String subString) throws IOException {
        List<String> words = turnStringIntoListOfWords();
        List<String> wordsContainingSubstring = new ArrayList<>();
        for (String word : words){
            if(word.contains(subString)){
                wordsContainingSubstring.add(word);
            }
        }
        return wordsContainingSubstring;
    }

    public List getStringsWhichPalindromes () throws IOException {
        List<String> words = turnStringIntoListOfWords();
        List<String> palindromeWords = new ArrayList<>();
        for (String word : words){
            if (checkIfPalindrome(word)){
                palindromeWords.add(word);
            }
        }
        return palindromeWords;
    }

    private List<String> turnStringIntoListOfWords() throws IOException {
        String text = filePartReader.readLines();
        return Arrays.asList(text.split(" "));
    }

    private boolean checkIfPalindrome(String word){
        int i1 = 0;
        int i2 = word.length();
        while (i2 > i1){
            if (word.charAt(i1) != word.charAt(i2)){
                return false;
            }
        }
        return true;
    }

}