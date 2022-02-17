import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ScrabbleDictionary {

    private HashMap<String, String> words = new HashMap<>();

    public ScrabbleDictionary()
    {
        File dictionary = new File("C:\\ComputerMethodology\\dreyfuss-mcon152-2022\\dictionary.txt");
        try {
            Scanner readFile = new Scanner(dictionary);
            while (readFile.hasNextLine())
            {
                String line = readFile.nextLine();
                String[] entry = line.split(" ", 2);
                if (entry.length == 1)
                {
                    words.put(entry[0], "");
                }
                else
                {
                    words.put(entry[0], entry[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isWord(String lookUpWord)
    {
        return getDefinition(lookUpWord) != null;
    }

    public String getDefinition(String lookUpWord)
    {
        String lookUpWordUpper = lookUpWord.toUpperCase();
        return words.get(lookUpWordUpper);
    }
}
