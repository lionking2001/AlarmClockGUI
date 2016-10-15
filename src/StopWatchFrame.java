import javax.swing.*;
import java.awt.*;

/**
 * Created by ASUS on 18/09/2016.
 */
public class StopWatchFrame extends JFrame {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    StopWatchFrame frame2 = new StopWatchFrame();
                    frame2.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StopWatchFrame() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 350, 700, 600);
        setContentPane(new StopwatchPanel());
    }
}
