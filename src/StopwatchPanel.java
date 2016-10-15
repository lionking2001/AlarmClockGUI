/**
 * Created by ASUS on 18/09/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StopwatchPanel extends JPanel {

    JLabel description;
    JLabel digitDisplay;
    MyStopWatch myStopWatch;
    JButton btnCancel;

    public StopwatchPanel() {

        setLayout(null);
        setBackground(Color.lightGray);
        setFocusable(true);

        description = new JLabel("Press [SPACE] to pause. Press [Enter] to stop. Press either key to startBtn.");
        description.setForeground(Color.white);
        description.setFont(new Font("Tahoma", Font.PLAIN, 18));
        description.setBounds(40, 10, 750, 25);
        add(description);

        digitDisplay = new JLabel("00:00:00");
        digitDisplay.setForeground(Color.white);
        digitDisplay.setFont(new Font("courier", Font.BOLD, 108));
        digitDisplay.setBounds(150, 0, 1000, 500);
        add(digitDisplay);

        JButton btnOK = new JButton("Start");
        btnOK.setBounds(100,350,100,50);
        btnOK.setForeground(Color.blue);
        btnOK.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(btnOK);


        JButton btnStop = new JButton("Stop");
        btnStop.setBounds (500,350,100,50);
        btnStop.setForeground(Color.blue);
        btnStop.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(btnStop);

        JButton btnPause = new JButton("Pause");
        btnPause.setBounds(300,350,100,50);
        btnPause.setForeground(Color.blue);
        btnPause.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(btnPause);

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFocusable(true);
                myStopWatch.setEnable(true);
            }
        });
        btnPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFocusable(true);
                myStopWatch.setEnable(false);
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFocusable(true);
                myStopWatch.setEnable(false);
                myStopWatch.resetTime();
            }
        });

        myStopWatch = new MyStopWatch();
        myStopWatch.start();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                onKeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }



    private void onKeyPress(KeyEvent e) {

        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_SPACE:
                if (myStopWatch.isEnable()) {
                    myStopWatch.setEnable(false);
                } else {
                    myStopWatch.setEnable(true);
                }
                break;
            case KeyEvent.VK_ENTER:

                if (myStopWatch.isEnable()) {
                    myStopWatch.setEnable(false);
                    myStopWatch.resetTime();
                    digitDisplay.setText("00:00:00");
                } else {
                    myStopWatch.setEnable(true);

                }

                break;
            default:
                break;
        }
    }


    class MyStopWatch extends Thread {

        private int time;


//        public int getTime() {
//            return time;
//        }

        public void resetTime() {
            this.time = 0;
        }

        private boolean isEnable = false;

        public boolean isEnable() {
            return isEnable;
        }

        public void setEnable(boolean enable) {
            isEnable = enable;
        }

        public void run() {
            try {
                while (true) {
                    if (isEnable) {
                        digitDisplay.setText(convertToText(time));
                        time++;
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }


        private String convertToText(int s) {
            int second = s % 60 ;
            int minute = s/60 %60 ;
            int hour = (s/600/6) ;


            return (hour < 10 ? "0" + hour : hour) + ":" +(minute < 10 ? "0" + minute : minute) + ":" + (second < 10 ? "0" + second : second);

        }

    }


}
