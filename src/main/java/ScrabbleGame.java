import java.util.ArrayList;
import java.util.List;

public class ScrabbleGame {

    List<String> playedWords = new ArrayList<>();
    List<Character> tiles = new ArrayList<>();
    ScrabbleDictionary dictionary = new ScrabbleDictionary();

    public ScrabbleGame()
    {
        //give the player 7 random tiles (ASCII values)
    }

    /**
     * if the word exists in the dictionary
     * and the letters exist in the tiles list
     * remove the letters from the list and add new random tiles
     *
     * @param word
     */
    public boolean playWord(String word)
    {
        return false;
    }

}
