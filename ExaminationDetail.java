package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExaminationDetail extends JFrame implements ActionListener {
    ExaminationDetail(){
        getContentPane().setBackground(new Color(241,251,210));
        JLabel heading = new JLabel("check result");
        heading.setBounds(350,15,400,210);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));






        setSize(1000,475);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        new ExaminationDetail();
    }
}
