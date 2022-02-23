import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScrabbleDictionaryTest {

    @Test
    public void isWordTestPass()
    {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when

        //then
        assertTrue(dictionary.isWord("happy"));
    }

    @Test
    public void isWordTestFail()
    {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when

        //then
        assertFalse(dictionary.isWord("hapy"));
    }

    @Test
    public void isWordTestFragment()
    {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when

        //then
        assertFalse(dictionary.isWord("happ"));
    }

    @Test
    public void isWordTestNoDefinition()
    {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when

        //then
        assertTrue(dictionary.isWord("zoologically"));
    }

    @Test
    public void getDefinition()
    {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when
        String definition = dictionary.getDefinition("mow");

        //then
        assertEquals("to cut down standing herbage [v MOWED, MOWN, MOWING, MOWS]", definition);
    }

    @Test
    public void getDefinitionNone()
    {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when
        String definition = dictionary.getDefinition("wrongheadedness");

        //then
        assertEquals("", definition);
    }

    @Test
    public void getDefinitionNotAWord()
    {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when
        String definition = dictionary.getDefinition("hapy");

        //then
        assertEquals(null, definition);
    }
}