import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePartReader{

    private String filePath;
    private int fromLine;
    private int toLine;

    FilePartReader(){
        filePath = "xyz";
        fromLine = 0;
        toLine = -1;
    }

    public void setup (String filePath, int fromLine, int toLine){
        if ((toLine < fromLine) || (fromLine < 1)){
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this. fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read () throws IOException {
        File file = new File(filePath);
        Scanner fileToBeRead = new Scanner(file);
        StringBuilder fileContent = new StringBuilder();
        while (fileToBeRead.hasNext()){
            String line = fileToBeRead.nextLine();
            fileContent.append(line);
            fileContent.append("\n");
        }
        return fileContent.toString();
    }

    public String readLines () throws IOException {
        String fileContent = read();
        String[] lines = fileContent.split("\n");
        StringBuilder narrowedFileContent = new StringBuilder();
        for (int i = 0; i < lines.length; i++){
            if (i+1 >= fromLine && i+1 <= toLine){
                narrowedFileContent.append(lines[i]);
            }
        }
        return narrowedFileContent.toString();
    }
}