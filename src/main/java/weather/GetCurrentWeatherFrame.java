package weather;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GetCurrentWeatherFrame extends JFrame {
    private JPanel verticalPanel;
    private JTextField inputField;
    private JButton submitButton;
    private JLabel weatherLabel;
    private Disposable disposable;
    private CurrentWeatherPresenter presenter;
    GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

    public GetCurrentWeatherFrame() {
        presenter =  new CurrentWeatherPresenter(this, getCurrentWeather);

        setTitle("Get Current Weather");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel,BoxLayout.Y_AXIS));
        add(verticalPanel);

        inputField = new JTextField("Zip code");
        verticalPanel.add(inputField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submitButton);

        weatherLabel = new JLabel("Current Weather");
        verticalPanel.add(weatherLabel);


    }

    private void onSubmitClicked(ActionEvent actionEvent)
    {
        presenter.loadWeatherFromZip(inputField.getText());
    }

        public static void main(String[] args)
    {
        JFrame frame = new GetCurrentWeatherFrame();
        frame.setVisible(true);
    }

    public void setTemperature(double fahrenheit)
    {
        weatherLabel.setText(String.valueOf(fahrenheit));
    }

    public void showError()
    {

    }
}
