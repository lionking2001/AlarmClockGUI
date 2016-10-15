import javax.swing.*;
import java.awt.*;

/**
 * Created by ASUS on 18/09/2016.
 */
public class AlarmClockFrame extends JFrame {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AlarmClockFrame frame1 = new AlarmClockFrame();
                    frame1.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AlarmClockFrame() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 350, 700, 600);
        setContentPane(new AlarmClock());
    }


}
