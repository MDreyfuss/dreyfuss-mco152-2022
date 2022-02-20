import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScrabbleGame {

    List<String> playedWords = new ArrayList<>();
    List<Character> tiles = new ArrayList<>();
    ScrabbleDictionary dictionary = new ScrabbleDictionary();
    Random randomLetter = new Random();

    public ScrabbleGame()
    {
        refillTiles();
    }

    /**
     * if the word exists in the dictionary
     * and the letters exist in the tiles list
     * remove the letters from the list and add new random tiles
     *
     * @param word: Word to be tried
     */
    public boolean playWord(String word)
    {
        word = word.toUpperCase();
        if (dictionary.isWord(word))
        {
            for (int i = 0; i < word.length(); i++)
            {
                Character currChar = word.charAt(i);
                if (!tiles.remove(currChar)) //should I use a deep copy & not ruin original list??
                {
                    return false;
                }
            }
            refillTiles();
            playedWords.add(word);
            return true;
        }
        return false;
    }

    public void refillTiles()
    {
        for (int i = tiles.size(); i < 7; i++)
        {
            int newLetterValue = randomLetter.nextInt(26) + 65;
            char newLetter = (char) newLetterValue;
            tiles.add(newLetter);
        }
    }
}
