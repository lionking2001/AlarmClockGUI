/**
 * Created by Administrator on 18/9/2559.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountDownPanel extends JPanel {

    JLabel inputLabel;
    JTextField inputBox;
    JLabel digitDisplay;
    JButton startBtn;
    MyTimer myTimer;

    public CountDownPanel() {

        setLayout(null);
        setFocusable(true);
        setBackground(Color.blue);

        inputLabel = new JLabel("Enter your time in \"mm:ss\" or \"ss\": ");
        inputLabel.setForeground(Color.white);
        inputLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        inputLabel.setBounds(20, 20, 1000, 25);
        add(inputLabel);

        inputBox = new JTextField();
        inputBox.setFont(new Font("courrier", Font.PLAIN, 22));
        inputBox.setBounds(300, 15, 125, 34);
        add(inputBox);

        startBtn = new JButton("Start!");
        startBtn.setFont(new Font("courrier", Font.PLAIN, 20));
        startBtn.setBounds(440, 15, 180, 35);
        add(startBtn);

        digitDisplay = new JLabel("00:00");
        digitDisplay.setForeground(Color.white);
        digitDisplay.setFont(new Font("courier", Font.BOLD, 108));
        digitDisplay.setBounds(150, 20, 700, 500);
        add(digitDisplay);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnEnableAction(e);
            }
        });
    }

    private void onBtnEnableAction(ActionEvent e) {
        myTimer = new MyTimer();
        myTimer.setEnable(true);
        myTimer.start();
    }


    class MyTimer extends Thread {

        private int timeLeft;
        private int temp;

        private boolean isEnable = false;

        public boolean isEnable() {
            return isEnable;
        }

        public void setEnable(boolean enable) {
            isEnable = enable;
        }

        public MyTimer() {

        }

        public void run() {
            timeLeft = convertInput(inputBox.getText());
            temp = timeLeft;
            try {
                while (true) {
                    if (isEnable) {
                        if (timeLeft >= 0) {
                            digitDisplay.setText(convertToText(timeLeft));
                            timeLeft--;
                        } else {
                            JOptionPane.showMessageDialog(null, "Your " + convertToText(temp) + " is over !");
                            myTimer.setEnable(false);
                        }
                    }
                    Thread.sleep(1000);


                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }

        String convertToText(int timeLeft) {

            int minute = timeLeft / 60;
            int second = timeLeft % 60;

            return (minute < 10 ? "0" + minute : minute) + ":" + (second < 10 ? "0" + second : second);

        }

        int convertInput(String userInput) {

            int second;
            int minuteTemp;
            int secondTemp;

            if (userInput.contains(":")) {
                minuteTemp = Integer.parseInt(userInput.substring(0, userInput.indexOf(':')));
                secondTemp = Integer.parseInt(userInput.substring(userInput.indexOf(':') + 1));
                second = (minuteTemp * 60) + secondTemp;
            } else {
                second = Integer.parseInt(userInput);
            }

            return second;
        }

    }


}




