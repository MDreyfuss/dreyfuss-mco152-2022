import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScrabbleFrame extends JFrame{
    private int score = 0;
    private final JLabel scoreLabel;
    private JLabel[] tiles;
    private final JTextField inputField;
    private final JButton submitButton;
    private final JLabel outputLabel;
    private JPanel verticalPanel;
    private ScrabbleGame scrabbleGame;
    private ScrabbleDictionary dictionary;


    public ScrabbleFrame()
    {
        setTitle("Touro Scrabble");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        scrabbleGame = new ScrabbleGame(dictionary, letterPool);

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
            tiles[i] = new JLabel(scrabbleGame.tiles.get(i).toString());
            tilesPanel.add(tiles[i]);
        }
        verticalPanel.add(tilesPanel);
    }

    public void onSubmitClicked(ActionEvent actionEvent)
    {
        outputLabel.setText("");
        String word = inputField.getText();
        String result = scrabbleGame.playWord(word);
        if (result.equals("Success!"))
        {
            score++;
            scoreLabel.setText("Score: " + score);
            for (int i = 0; i < tiles.length; i++) {
                tiles[i].setText(scrabbleGame.tiles.get(i).toString());
            }
        }
        else
        {
            outputLabel.setText(result);
        }


    }

    public static void main(String[] args)
    {
        JFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }
}
