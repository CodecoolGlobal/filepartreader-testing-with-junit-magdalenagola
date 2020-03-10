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
        java.util.Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }



    public List getWordsContainingSubstring (String subString) throws IOException {
        if (subString.isEmpty()){
            return null;
        }
        List<String> words = turnStringIntoListOfWords();
        List<String> wordsContainingSubstring = new ArrayList<>();
        for (String word : words){
            if(word.toLowerCase().contains(subString.toLowerCase())){
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
        word = word.toLowerCase();
        int i1 = 0;
        int i2 = word.length() - 1;
        while (i2 > i1){
            if (word.charAt(i1) != word.charAt(i2)){
                return false;
            }
            i1++;
            i2--;
        }
        return true;
    }

}