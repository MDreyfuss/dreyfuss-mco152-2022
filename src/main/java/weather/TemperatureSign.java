package weather;

import javax.swing.*;
import java.awt.*;

public class TemperatureSign extends JComponent {
    public TemperatureSign()
    {
        setPreferredSize(new Dimension(400,400));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.cyan);
        g.drawLine(0,0,400,400);
    }
}
