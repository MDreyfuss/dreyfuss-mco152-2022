import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ScrabbleFrame extends JFrame{

    private final ScrabblePresenter presenter;
    private int score = 0;
    private final JLabel scoreLabel;
    private JLabel[] tiles;
    private final JTextField inputField;
    private final JButton submitButton;
    private final JLabel outputLabel;
    private JPanel verticalPanel;
    private ScrabbleDictionary dictionary;


    public ScrabbleFrame()
    {
        setTitle("Touro Scrabble");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        ScrabbleGame scrabbleGame = new ScrabbleGame(dictionary, letterPool);

        presenter = new ScrabblePresenter(this,scrabbleGame);

        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel,BoxLayout.Y_AXIS));
        add(verticalPanel);

        addTilesPanel(verticalPanel);

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(120,60));
        verticalPanel.add(inputField);

        scoreLabel = new JLabel("Score: "+ score);
        scoreLabel.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(scoreLabel);

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(120,60));
        submitButton.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submitButton);

        outputLabel = new JLabel("");
        outputLabel.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(outputLabel);
    }

    private void addTilesPanel(JPanel verticalPanel) {
        JPanel tilesPanel = new JPanel();
        tilesPanel.setLayout(new FlowLayout());
        tiles = new JLabel[7];
        for (int i = 0; i < 7; i++) {
            tiles[i] = new JLabel();
            tilesPanel.add(tiles[i]);
        }
        verticalPanel.add(tilesPanel);

        presenter.fillTiles();
    }

    public void onSubmitClicked(ActionEvent actionEvent)
    {
        String word = inputField.getText();
        presenter.playWord(word);
    }

    public static void main(String[] args)
    {
        JFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }

    public void setScore(String score)
    {
        scoreLabel.setText(score);
    }

    public void setTiles(List<Character> tilesIn)
    {
        for (int i = 0; i < tilesIn.size(); i++)
        {
            tiles[i].setText(tilesIn.get(i).toString());
        }
    }

    public void displayError(String result)
    {
        outputLabel.setText(result);
    }
}
