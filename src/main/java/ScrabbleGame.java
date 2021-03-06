import java.util.ArrayList;
import java.util.List;

public class ScrabbleGame {

    List<String> playedWords = new ArrayList<>();
    List<Character> tiles = new ArrayList<>();
    List<Character> tilesTesting = new ArrayList<>();
    ScrabbleDictionary dictionary;
    LetterPool letterPool;

    static final String SUCCESS = "Success!";
    static final String NOT_A_WORD = "Not a word";
    static final String NO_TILES = "Tiles not available";

    public ScrabbleGame(ScrabbleDictionary dictionary, LetterPool letterPool)
    {
        this.dictionary = dictionary;
        this.letterPool = letterPool;
        refillTiles();
    }

    /**
     * if the word exists in the dictionary
     * and the letters exist in the tiles list
     * remove the letters from the list and add new random tiles
     *
     * @param word: Word to be tried
     */
    public String playWord(String word)
    {
        word = word.toUpperCase();
        if (dictionary.isWord(word))
        {
            for (int i = 0; i < word.length(); i++)
            {
                Character currChar = word.charAt(i);
                if (!tilesTesting.remove(currChar))
                {
                    tilesTesting.clear();
                    tilesTesting.addAll(tiles);
                    return NO_TILES;
                }
            }
            tiles.clear();
            tiles.addAll(tilesTesting);
            refillTiles();
            playedWords.add(word);
            return SUCCESS;
        }
        return NOT_A_WORD;
    }

    public void refillTiles()
    {
        for (int i = tiles.size(); i < 7; i++)
        {
            Character newLetter = letterPool.getRandomLetter();
            tiles.add(newLetter);
            tilesTesting.add(newLetter);
        }
    }
}
