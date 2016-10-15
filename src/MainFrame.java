/**
 * Created by ASUS on 18/09/2016.
 */
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 350, 700, 600);
        setContentPane(new MainClockPanel());
    }
}
