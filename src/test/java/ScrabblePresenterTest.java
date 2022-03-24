import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ScrabblePresenterTest {

    private ScrabbleFrame view = Mockito.mock(ScrabbleFrame.class);
    private ScrabbleGame model = Mockito.mock(ScrabbleGame.class);
    private ScrabblePresenter presenter = new ScrabblePresenter(view, model);
    private List<Character> tiles = new ArrayList<>();

    @Test
    public void fillTiles()
    {
        //given
        Mockito.doReturn(tiles).when(model).getTiles();

        //when
        presenter.fillTiles();

        //then
        verify(model).getTiles();
        verify(view).setTiles(tiles);
    }

    @Test
    public void playWord_Success()
    {
        //given
        doReturn(tiles).when(model).getTiles();
        doReturn(ScrabbleGame.SUCCESS).when(model).playWord("HELLO");

        //when
        presenter.playWord("HELLO");

        //then
        verify(model).playWord("HELLO");
        verify(view).setScore("Score: 1");
        verify(model).getTiles();
        verify(view).setTiles(tiles);
    }

    @Test
    public void playWord_NotAWord()
    {
        //given
        doReturn(tiles).when(model).getTiles();
        doReturn(ScrabbleGame.NOT_A_WORD).when(model).playWord("QWERTYUIOP");

        //when
        presenter.playWord("QWERTYUIOP");

        //then
        verify(model).playWord("QWERTYUIOP");
        verify(view).displayError(ScrabbleGame.NOT_A_WORD);
    }

}