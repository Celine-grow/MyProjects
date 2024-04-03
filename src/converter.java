import javax.swing.*;
import javax.swing.JFrame.*;
import java.awt.*;
import java.awt.Window.*;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;

public class converter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature converter");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(300, 200));
        JLabel label1 = new JLabel("Enter your Farenheight temperature value");
        JTextField txt1 = new JTextField(10);
        JButton button1 = new JButton("Convert ");
        JLabel label2 = new JLabel("Enter your Celcius temperature value");
        JTextField txt2 = new JTextField(10);
        JButton button2 = new JButton("Convert ");



        jPanel.add(label1);
        jPanel.add(txt1);
        jPanel.add(button1);
        jPanel.add(label2);
        jPanel.add(txt2);
        jPanel.add(button2);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userinput = txt1.getText();
                if (userinput != null) {
                    try {
                        double myuserinput = Double.parseDouble(userinput);
                        double result = frconvert(myuserinput);
                        JOptionPane.showMessageDialog(frame, "Result is " + result + " degrees Celcius");
                        txt1.setText("");
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(frame, "Invalid Input. Error is: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        txt1.setText("");
                    }

                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userinput = txt2.getText();
                if (userinput != null) {
                    try {
                        double myuserinput = Double.parseDouble(userinput);
                        double result = celconvert(myuserinput);
                        JOptionPane.showMessageDialog(frame, "Result is " + result + "  degree Farenheight ");
                        txt2.setText("");
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(frame, "Invalid Input. Error is: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        txt2.setText("");
                    }

                }
            }
        });



        frame.getContentPane().add(jPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static double frconvert(double value) {
        return ((value - 32) * (5 / 9.0));

    }

    private static double celconvert(double value) {
        return ((value * 9 / 5.0) + 32);

    }
}



