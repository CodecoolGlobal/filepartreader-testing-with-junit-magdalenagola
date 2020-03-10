import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader filePartReader = new FilePartReader();

    @Test
    public void shouldReturnFileContentAsAString() throws IOException {
        filePartReader.setup("src/tests/resources/test_file2.txt", 1,1);
        String fileContent = "Tale as old as time\n" +
                            "True as it can be\n" +
                            "Barely even friends\n" +
                            "Then somebody bends";
        assertEquals(fileContent, filePartReader.read());
    }

    @Test
    public void shouldReturnOneRowWhenFromLineAndToLineEqualOne() throws IOException {
        filePartReader.setup("src/tests/resources/test_file.txt", 1,1);
        assertEquals("Tale as old as time", filePartReader.readLines());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFromLineIsBelow1(){
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup("no_such_file.txt", 0, 1);
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenToLineIsSmallerThanFromLine(){
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup("no_such_file.txt", 3, 1);
        });
    }


}