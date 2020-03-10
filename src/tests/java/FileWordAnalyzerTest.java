import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    FilePartReader filePartReader = new FilePartReader();
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    @Test
    public void shouldReturnNullWhenSubstringIsEmpty() throws IOException {
        filePartReader.setup("src/tests/resources/test_file.txt", 1,1);
        assertNull(fileWordAnalyzer.getWordsContainingSubstring(""));
    }

    @Test
    public void shouldIgnoreCaseWhenComparingStrings() throws IOException {
        filePartReader.setup("src/tests/resources/test_file.txt", 1,6);
        List<String> expectedArray = new ArrayList<>();
        expectedArray.add("Unexpectedly");
        assertEquals(expectedArray, fileWordAnalyzer.getWordsContainingSubstring("unexpectedly"));
    }

    @Test
    public void shouldReturnEmptyListWhenNoPalindromesFound() throws IOException {
        filePartReader.setup("src/tests/resources/test_file.txt", 1, 1);
        List<String> expectedArray = new ArrayList<>();
        assertEquals(expectedArray, fileWordAnalyzer.getStringsWhichPalindromes());
    }

    @Test
    public void shouldReturnListOfPalindromesIgnoringCaseSensitivity() throws IOException {
        filePartReader.setup("src/tests/resources/test_file3.txt", 1, 1);
        List<String> expectedArray = new ArrayList<>(List.of("madam", "Hannah", "kayak"));
        assertEquals(expectedArray, fileWordAnalyzer.getStringsWhichPalindromes());
    }

    @Test
    public void shouldReturnWordsOrderedAlphabeticallyIgnoringCaseSensitivity() throws IOException {
        filePartReader.setup("src/tests/resources/test_file.txt", 2, 2);
        List<String> expectedArray = new ArrayList<>(List.of("as", "be", "can", "it", "True"));
        assertEquals(expectedArray, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

}