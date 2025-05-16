package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Studentfeeform extends JFrame implements ActionListener {
    Choice CrollNumber;
    JComboBox<String> courseBox, departmentBox, semesterBox;
    JLabel totalAmount;
    JButton pay, update, back;
    Studentfeeform(){
        getContentPane().setBackground(new Color(210, 252, 251));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fee.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400, 50, 500, 300);
        add(img);

        JLabel rollNumber = new JLabel("Select Roll Number");
        rollNumber.setBounds(40, 60, 150, 20);
        rollNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(rollNumber);

        CrollNumber = new Choice();
        CrollNumber.setBounds(200, 60, 150, 20);
        add(CrollNumber);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                CrollNumber.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(40, 100, 150, 20);
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200, 100, 150, 20);
        add(textName);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(40, 140, 150, 20);
        add(fname);

        JLabel textfName = new JLabel();
        textfName.setBounds(200, 140, 150, 20);
        add(textfName);

        try {
            Conn c = new Conn();
            String Q = "select * from student where rollno='" + CrollNumber.getSelectedItem() + "'";
            ResultSet resultSet = c.s.executeQuery(Q);
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textfName.setText(resultSet.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel qualification = new JLabel("Qualification");
        qualification.setBounds(40, 180, 150, 20);
        qualification.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(qualification);

        String[] courses = {"BBA", "B.Tech", "BCS", "MSC", "MBA", "MCA", "MCom", "MA", "BA"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(200, 180, 150, 20);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        JLabel department = new JLabel("Branch");
        department.setBounds(40, 220, 150, 20);
        add(department);

        String[] departments = {"BTech", "Computer Sciences", "Electronics", "Mechanical", "Civil", "IT"};
        departmentBox = new JComboBox<>(departments);
        departmentBox.setBounds(200, 220, 150, 20);
        add(departmentBox);

        JLabel textSemester = new JLabel("Semester");
        textSemester.setBounds(40, 260, 150, 20);
        add(textSemester);

        String[] semesters = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};
        semesterBox = new JComboBox<>(semesters);
        semesterBox.setBounds(200, 260, 150, 20);
        add(semesterBox);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40, 300, 150, 20);
        add(total);

        totalAmount = new JLabel();
        totalAmount.setBounds(200, 300, 150, 20);
        add(totalAmount);

        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150, 380, 100, 25);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.addActionListener(this);
        add(back);

        setSize(900, 500);
        setLocation(300, 100);
        setVisible(true);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == update) {
                String course = (String) courseBox.getSelectedItem();
                String semester = (String) semesterBox.getSelectedItem();
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.s.executeQuery("select * from fee where course='"+course+"'");
                    while (resultSet.next()) {
                        totalAmount.setText(resultSet.getString(semester));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getSource() == pay) {
                String rollno = CrollNumber.getSelectedItem();
                String course = (String) courseBox.getSelectedItem();
                String semester = (String) semesterBox.getSelectedItem();
                String branch = (String) departmentBox.getSelectedItem();
                String total = totalAmount.getText();
                try {
                    Conn c = new Conn();
                    String Q = "insert into feecollege values('" + rollno + "', '" + course + "', '" + branch + "', '" + semester + "', '" + total + "')";
                    c.s.executeUpdate(Q);
                    JOptionPane.showMessageDialog(null, "Fee Submitted Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                setVisible(false);
            }
    }
    public static void main(String[]args) {
        new Studentfeeform();
    }
}

