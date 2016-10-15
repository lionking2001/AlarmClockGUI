/**
 * Created by ASUS on 18/09/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainClockPanel extends JPanel {
    JButton btnSnooze;
    JLabel dateLabel;
    JLabel currentDate;
    JLabel timeLabel;
    JLabel currentTime;
    JLabel alarmLabel;
    JButton alarmStatus;

    MyAlarmClock myAlarmClock;
    static AlarmClockFrame frameAlarmClock;

    static int alarmHour;
    static int alarmMinute;
    static int alarmSecond;
    static boolean alarmAMPM;

    public MainClockPanel() {

        setLayout(null);
        setFocusable(true);
        setBackground(Color.black);

        dateLabel = new JLabel("Date: ");
        dateLabel.setForeground(Color.white);
        dateLabel.setFont(new Font("courier", Font.PLAIN, 18));
        dateLabel.setBounds(15, 30, 100, 150);
        add(dateLabel);

        currentDate = new JLabel(getDateOrTime(true));
        currentDate.setForeground(Color.blue);
        currentDate.setFont(new Font("courier", Font.BOLD, 48));
        currentDate.setBounds(180, 25, 500, 150);
        add(currentDate);

        timeLabel = new JLabel("Time: ");
        timeLabel.setForeground(Color.white);
        timeLabel.setFont(new Font("courier", Font.PLAIN, 18));
        timeLabel.setBounds(15, 30, 100, 350);
        add(timeLabel);

        currentTime = new JLabel(getDateOrTime(false));
        currentTime.setForeground(Color.red);
        currentTime.setFont(new Font("courier", Font.BOLD, 48));
        currentTime.setBounds(190, 125, 500, 150);
        add(currentTime);

        alarmLabel = new JLabel(("Alarm: "));
        alarmLabel.setForeground(Color.white);
        alarmLabel.setFont(new Font("courier", Font.PLAIN, 18));
        alarmLabel.setBounds(15, 170, 100, 350);
        add(alarmLabel);


        alarmStatus = new JButton("Alarm Status");
        alarmStatus.setForeground(Color.red);
        alarmStatus.setFont(new Font("courier", Font.BOLD, 18));
        alarmStatus.setBounds(200, 320, 200, 50);
        add(alarmStatus);
        alarmStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onalarmStatusClick(e);
            }
        });

        JButton btnsetAlarm = new JButton("Set Alarm");
        btnsetAlarm.setForeground(Color.blue);
        btnsetAlarm.setFont(new Font("courier", Font.BOLD, 18));
        btnsetAlarm.setBounds(15, 420, 200, 50);
        btnsetAlarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSetAlarmClick(e);
            }
        });

        JButton btnStopWatch = new JButton("StopWatch");
        btnStopWatch.setForeground(Color.blue);
        btnStopWatch.setFont(new Font("courier", Font.BOLD, 18));
        btnStopWatch.setBounds(250, 420, 200, 50);
        btnStopWatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onStopwatchClick(e);
            }


        });
        add(btnsetAlarm);
        add(btnStopWatch);

        JButton btnCountDown = new JButton("CountDown");
        btnCountDown.setForeground(Color.BLUE);
        btnCountDown.setBounds(480, 420, 200, 50);
        btnCountDown.setFont(new Font("courier",Font.BOLD,18));
        btnCountDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCountDownClick(e);
            }
        });
        add(btnCountDown);

//        btnSnooze = new JButton("Snooze");
//        btnSnooze.setForeground(Color.RED);
//        btnSnooze.setFont(new Font("courier", Font.BOLD, 18));
//        btnSnooze.setBounds(450, 320, 200, 50);
//        add(btnSnooze);

//        btnSnooze.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onSnoozeClick(e);
//            }
//        });


        frameAlarmClock = new AlarmClockFrame();

        myAlarmClock = new MyAlarmClock();
        myAlarmClock.start();

        AlarmClockThread n = new AlarmClockThread();
        n.start();
    }
    CountDownFrame frame = new CountDownFrame();
    private void onCountDownClick(ActionEvent e) {
        frame.setVisible(true);
    }

    StopWatchFrame stopWatchFrame = new StopWatchFrame();

    private void onStopwatchClick(ActionEvent e) {
        stopWatchFrame.setVisible(true);
    }


    AlarmClockFrame alarm = new AlarmClockFrame();

//    private void onSnoozeClick(ActionEvent e) {
//
//    }


    private void onalarmStatusClick(ActionEvent e) {

        if (alarmHour > 0 && alarmHour < 13 && alarmMinute > 0 && alarmMinute < 60) {
            JOptionPane.showMessageDialog(null, "The alarm has been set at " + alarmHour + ":" + alarmMinute + ":" + alarmSecond, "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The alarm has been not set", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void onSetAlarmClick(ActionEvent e) {
        frameAlarmClock.setVisible(true);
    }

    private String getDateOrTime(boolean choice) {

        DateFormat dateFormat = new SimpleDateFormat("MMM, dd YYYY");
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        Date dateObj = new Date();
        Calendar calendarObj = Calendar.getInstance();

        if (choice == true) {
            return dateFormat.format(dateObj);
        } else if (choice == false) {
            return timeFormat.format(calendarObj.getTime());
        }
        return "";

    }

    class MyAlarmClock extends Thread {

        String clockTime;
        String alarmTime;

        public void run() {
            try {
                while (true) {
                    currentDate.setText(getDateOrTime(true));
                    currentTime.setText((getDateOrTime(false)));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }


    }

    public void setAlarmHour(int alarmHour) {
        this.alarmHour = alarmHour;
    }

    public void setAlarmMinute(int alarmMinute) {
        this.alarmMinute = alarmMinute;
    }

    public void setAlarmSecod(int alarmSecond) {
        this.alarmSecond = alarmSecond;
    }

    public void setAlarmAMPM(boolean alarmAMPM) {
        this.alarmAMPM = alarmAMPM;
    }

    boolean isAlive = true;

    class AlarmClockThread extends Thread {

        public void run() {
            while (isAlive) {
                Calendar now = Calendar.getInstance();
                int hour = now.get(Calendar.HOUR);
                int minute = now.get(Calendar.MINUTE);
                int second = now.get(Calendar.SECOND);
                int AMPM = now.get(Calendar.AM_PM);
                boolean isAm;
                if (AMPM == 0)
                    isAm = true;
                else
                    isAm = false;


                try {
                    if (alarmHour == hour && alarmMinute == minute && alarmSecond == second && isAm == alarmAMPM) {
                        Object[] options = {"Snooze!",
                                "Wake up"};
                        int n = JOptionPane.showOptionDialog(null,
                                "Wake or Snooze!?",
                                "Your choice ... ",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,     //do not use a custom Icon
                                options,  //the titles of buttons
                                options[0]); //default button title
                        if (n == JOptionPane.NO_OPTION) {

                            isAlive = false;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
    }


}
