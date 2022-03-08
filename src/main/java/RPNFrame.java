import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RPNFrame extends JFrame {
    private RPN rpn;
    private JTextField inputField;
    private JButton submitButton;
    private JLabel outputLabel;

    public RPNFrame(){

        setTitle("RPN");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        rpn = new RPN();

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(600,60));
        add(inputField);


        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(120,60));
        submitButton.addActionListener(this::onSubmitClicked);
        add(submitButton);

        outputLabel = new JLabel("");
        outputLabel.setPreferredSize(new Dimension(600, 60));
        add(outputLabel);

    }

    private void onSubmitClicked(ActionEvent actionEvent)
    {
        String expression = inputField.getText();
        outputLabel.setText(rpn.evaluate(expression));
    }

    public static void main(String[] args) {
        JFrame frame = new RPNFrame();
        frame.setVisible(true);
    }
}
