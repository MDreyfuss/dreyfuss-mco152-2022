import java.util.List;

public class ScrabblePresenter {

    private ScrabbleFrame view;
    private ScrabbleGame model;
    private int score;

    public ScrabblePresenter(ScrabbleFrame view, ScrabbleGame model)
    {
        this.view = view;
        this.model = model;
    }

    public void playWord(String word)
    {
        String result = model.playWord(word);
        if (result.equals(model.SUCCESS))
        {
            score++;
            view.setScore("Score: " + score);
            fillTiles();
        }
        else
        {
            view.displayError(result);
        }
    }

    public void fillTiles()
    {
        List<Character> tiles = model.getTiles();
        view.setTiles(tiles);
    }
}
