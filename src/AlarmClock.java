import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by ASUS on 18/09/2016.
 */
public class AlarmClock extends JPanel {
    boolean alarmAm;
    int alarmHour;
    int alarmSecond;
    int alarmMinute;
    boolean isSet = false;
    JTextField hour;
    JTextField minute;
    JTextField second;
    JTextField AM;
    JButton btnOk;
    JButton btnCancel;

    public AlarmClock() {

        setLayout(null);
        setBackground(Color.WHITE);
        setFocusable(true);


        //Title ActionListerner
        JLabel description = new JLabel("Welcome to Alarm!!!");
        description.setForeground(Color.white);
        description.setFont(new Font("Tahoma", Font.PLAIN, 30));
        description.setBounds(200, 10, 750, 25);
        add(description);


        //Second Actionlistener
        second = new JTextField("");
        second.setBounds(350, 90, 100, 50);
        second.setBackground(Color.green);
        second.setFont(new Font("Tahoma", Font.BOLD, 35));
//        second.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onSecondInsert(e);
//            }
//        });

        //Minute Actionlistener
        minute = new JTextField("");
        minute.setBounds(225, 90, 100, 50);
        minute.setBackground(Color.ORANGE);
        minute.setFont(new Font("Tahoma", Font.BOLD, 35));
//        minute.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onMinuteInsert(e);
//            }
//        });

        //Hour Actionlistener
        hour = new JTextField("");
        hour.setBounds(100, 90, 100, 50);
        hour.setBackground(Color.BLUE);
        hour.setFont(new Font("Tanoma", Font.BOLD, 35));
//        hour.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onHourInsert(e);
//            }
//        });

        //AM/PM actionListener
        AM = new JTextField("");
        AM.setBounds(475, 90, 100, 50);
        AM.setBackground(Color.RED);
        AM.setFont(new Font("Tahoma", Font.BOLD, 35));
//        AM.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                    onAMInsert(e);
//
//            }
//        });
        JLabel hour1 = new JLabel("Hour");
        hour1.setBounds(125, 25, 100, 50);
        hour1.setBackground(Color.red);
        hour1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel min1 = new JLabel("Minute");
        min1.setBounds(250, 25, 100, 50);
        min1.setBackground(Color.red);
        min1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel sec1 = new JLabel("Second");
        sec1.setBounds(375, 25, 100, 50);
        sec1.setBackground(Color.red);
        sec1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel am1 = new JLabel("AM/PM");
        am1.setBounds(500, 25, 100, 50);
        am1.setBackground(Color.red);
        am1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        add(hour1);
        add(min1);
        add(sec1);
        add(am1);
        add(hour);
        add(minute);
        add(second);
        add(AM);

        btnOk = new JButton("Enable");
        btnOk.setBounds(150, 250, 100, 50);
        btnOk.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(btnOk);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOKClick(e);
            }

        });

        btnCancel = new JButton("Cancle");
        btnCancel.setBounds(350, 250, 100, 50);
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancelClick(e);
            }
        });
        add(btnCancel);

    }

    private void onOKClick(ActionEvent e) {

        //Hour
        String tempHour1 = hour.getText();
        int temHour1 = -1;
        try {
            temHour1 = Integer.parseInt(tempHour1);
        } catch (Exception exception) {
        }
        if (temHour1 < 13 && temHour1 > 0) {
            alarmHour = temHour1;
        }
        //End Hour

        //Minute
        String tempMin = minute.getText();
        int temMin = -1;
        try {
            temMin = Integer.parseInt(tempMin);
        } catch (Exception exception) {
        }
        if (temMin < 60 && temMin >= 0) {
            alarmMinute = temMin;
        }
        //End Minute


        //Second
        String tempSecond = second.getText();
        int temSecond = -1;
        try {
            temSecond = Integer.parseInt(tempSecond);
        } catch (Exception exception) {
        }
        if (temSecond < 60 && temSecond >= 0) {
            alarmSecond = temSecond;
        }
        //End second

        //AM PM
        if (AM.getText().equalsIgnoreCase("PM")) {
            alarmAm = false;
            isSet = true;
        } else if (AM.getText().equalsIgnoreCase("AM")) {
            alarmAm = true;
            isSet = true;
        }
        //END AM PM

        if ((alarmHour < 13 && alarmHour > 0 && alarmMinute < 60 && alarmMinute >= 0 && alarmSecond < 60 && alarmSecond >= 0 && isSet)) {
            try {
                MainClockPanel.alarmHour = alarmHour;
                MainClockPanel.alarmMinute = alarmMinute;
                MainClockPanel.alarmSecond = alarmSecond;
                MainClockPanel.alarmAMPM = alarmAm;
                MainClockPanel.frameAlarmClock.setVisible(false);
            } catch (Exception e1) {
                System.out.println("...");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Input Valid Value");
        }
    }

//    private void onMinuteInsert(ActionEvent e) {
//
//            String tempHour = minute.getText();
//            int temMin = Integer.parseInt(tempHour);
//            if (temMin <= 0 && temMin > 60) {
//                JOptionPane.showMessageDialog(null, "Please enter the number Again", "", JOptionPane.ERROR_MESSAGE);
//            }
//            if(temMin < 60 && temMin >= 0) {
//                alarmMinute = temMin;
//            }
//
//    }
//
//    private void onAMInsert(ActionEvent e) {
//        if(AM.getText().equalsIgnoreCase("AM")) {
//            alarmAm = true;
//            isSet = true;
//        } else if (AM.getText().equalsIgnoreCase("PM")){
//            alarmAm = false;
//            isSet = true;
//        } else {
//            JOptionPane.showMessageDialog(null,"Please enter the AM/PM Again","",JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void onSecondInsert(ActionEvent e) {
//            String tempSecond = second.getText();
//            int temSecond = Integer.parseInt(tempSecond);
//            if (temSecond <= 0 && temSecond > 60) {
//                JOptionPane.showMessageDialog(null, "Please enter the number Again", "", JOptionPane.ERROR_MESSAGE);
//            }
//            if(temSecond < 60 && temSecond >= 0) {
//                alarmSecond = temSecond;
//            }
//    }
//
//    private void onHourInsert(ActionEvent e) {
//            String tempHour = hour.getText();
//            int temHour = Integer.parseInt(tempHour);
//            if(temHour<0&&temHour>13){
//                JOptionPane.showMessageDialog(null,"Please enter the number Again","",JOptionPane.ERROR_MESSAGE);
//            }
//            if(temHour < 13 && temHour > 0) {
//                alarmHour = temHour;
//            }
//    }

    private void onCancelClick(ActionEvent e) {
        MainClockPanel.frameAlarmClock.setVisible(false);
    }


}