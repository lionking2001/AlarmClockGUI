/**
 * Created by Administrator on 18/9/2559.
 */
import javax.swing.*;
import java.awt.*;

public class CountDownFrame extends JFrame {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                   CountDownFrame frame1 = new CountDownFrame();
                    frame1.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CountDownFrame() {
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 350, 700, 600);
        setContentPane(new CountDownPanel());
    }
}