import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class ScrabbleGameTest {
    ScrabbleDictionary dictionary = Mockito.mock(ScrabbleDictionary.class);
    LetterPool letterPool = Mockito.mock(LetterPool.class);

    @Test
    public void playWord_true()
    {
        //given
        Mockito.doReturn(true)
                .when(dictionary)
                .isWord("HELLO");
        Mockito.doReturn('H', 'E', 'L', 'L', 'O', 'F', 'G')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        //when
        String val = game.playWord("hello");

        //then
        Mockito.verify(dictionary).isWord("HELLO");
        Mockito.verify(letterPool, Mockito.times(12)).getRandomLetter();
        assertEquals(game.SUCCESS, val);
        assertTrue(game.playedWords.contains("HELLO"));
        assertEquals(1, game.playedWords.size());
    }

    @Test
    public void playWord_false()
    {
        //given
        Mockito.doReturn(true)
                .when(dictionary)
                .isWord("LOGO");
        Mockito.doReturn('H', 'E', 'L', 'L', 'O', 'F', 'G')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        //when

        //then
        assertEquals(game.NO_TILES, game.playWord("logo"));
        Mockito.verify(letterPool, Mockito.times(7)).getRandomLetter();
        assertTrue(game.playedWords.isEmpty());
        assertEquals(7, game.tiles.size());
    }

    @Test
    public void playWord_notInDictionary()
    {
        //given
        Mockito.doReturn('H', 'E', 'L', 'L', 'O', 'F', 'G')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        //when

        //then
        assertEquals(game.NOT_A_WORD, game.playWord("helo"));
        Mockito.verify(dictionary).isWord("HELO");
        assertTrue(game.playedWords.isEmpty());

    }


}