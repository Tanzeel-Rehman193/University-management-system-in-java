package university.management.system;

import university.management.Addstudents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
     main_class(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,740, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        //new information
         JMenu newInfo = new JMenu("New Information");
         newInfo.setForeground(Color.black);
         mb.add(newInfo);

         JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
         facultyInfo.setBackground(Color.WHITE);
         facultyInfo.addActionListener(this);
         newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
         studentInfo.addActionListener(this);
        newInfo.add(studentInfo);
        // Details
         JMenu details = new JMenu("View Details");
         details.setForeground(Color.black);
         mb.add(details);

         JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
         facultyDetails.setBackground(Color.WHITE);
         facultyDetails.addActionListener(this);
         details.add(facultyDetails);

         JMenuItem studentDetails = new JMenuItem("View Student Details");
         studentDetails.setBackground(Color.WHITE);
         studentDetails.addActionListener(this);
         details.add(studentDetails);
         //Leave
         JMenu leave = new JMenu("Apply Leave");
         leave.setForeground(Color.black);
         mb.add(leave);

         JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
         facultyLeave.setBackground(Color.WHITE);
         facultyLeave.addActionListener(this);
         leave.add(facultyLeave);

         JMenuItem studentLeave = new JMenuItem("Student Leave");
         studentLeave.setBackground(Color.WHITE);
         studentLeave.addActionListener(this);
         leave.add(studentLeave);

         // Leave Details
         JMenu leaveDetails = new JMenu("Leave Details");
         leaveDetails.setForeground(Color.black);
         mb.add(leaveDetails);

         JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
         facultyLeaveDetails.setBackground(Color.WHITE);
         facultyLeaveDetails.addActionListener(this);
         leaveDetails.add(facultyLeaveDetails);

         JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
         studentLeaveDetails.setBackground(Color.WHITE);
         studentLeaveDetails.addActionListener(this);
         leaveDetails.add(studentLeaveDetails);

         // Exams
         JMenu exam = new JMenu("Examination");
         exam.setForeground(Color.black);
         mb.add(exam);

         JMenuItem examDetails = new JMenuItem("Examination Results");
         examDetails.setBackground(Color.WHITE);
         examDetails.addActionListener(this);
         exam.add(examDetails);

         JMenuItem enterMarks = new JMenuItem("Enter Marks");
         enterMarks.setBackground(Color.WHITE);
         exam.add(enterMarks);

         // Fee
         JMenu fee = new JMenu("Fees Details");
         fee.setForeground(Color.black);
         mb.add(fee);

         JMenuItem feeStructure = new JMenuItem("Fees Structure");
         feeStructure.setBackground(Color.WHITE);
         feeStructure.addActionListener(this);
         fee.add(feeStructure);

         JMenuItem feeForm = new JMenuItem("Fees Form");
         feeForm.setBackground(Color.WHITE);
         feeForm.addActionListener(this);
         fee.add(feeForm);

         // Utility

         JMenu utility = new JMenu("Utilities");
         utility.setForeground(Color.black);
         mb.add(utility);

         JMenuItem calculator = new JMenuItem("Calculator");
         calculator.setBackground(Color.WHITE);
         calculator.addActionListener(this);
         utility.add(calculator);

         JMenuItem notepad = new JMenuItem("Notepad");
         notepad.setBackground(Color.WHITE);
         notepad.addActionListener(this);
         utility.add(notepad);
         // Games
         JMenu tanzeel = new JMenu("Games");
         tanzeel.setForeground(Color.black);
         mb.add(tanzeel);
         JMenuItem snake = new JMenuItem("Snake");
         snake.setBackground(Color.WHITE);
         tanzeel.add(snake);

         //About
         JMenu about = new JMenu("About");
         about.setForeground(Color.black);
         mb.add(about);

         JMenuItem About = new JMenuItem("About Us");
         About.setBackground(Color.WHITE);
         about.add(About);

         // Exit
         JMenu exit = new JMenu("Exit");
         exit.setForeground(Color.black);
         mb.add(exit);

         JMenuItem Exit = new JMenuItem("Exit from here");
         Exit.setBackground(Color.WHITE);
         Exit.addActionListener(this);
         exit.add(Exit);

         setJMenuBar(mb);

         setSize(1500,850);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String st = e.getActionCommand();
    if (st.equals("Exit from here")){
        System.exit(29);
    }
    else if (st.equals("Calculator")){
        try {
            Runtime.getRuntime().exec("calc.exe");
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }
    else if (st.equals("Notepad")) {
        try {
            Runtime.getRuntime().exec("notepad.exe");
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }
    else if (st.equals("New Faculty Information")) {
        new AddFaculty();
    }
    else if (st.equals("New Student Information")) {
        new AddStudents();
    }
    else if (st.equals("View Faculty Details")) {
        new TeachersDetails();
    }
    else if (st.equals("View Student Details")) {
        new StudentDetails();
    }
    else if (st.equals("Student Leave")) {
        new StudentLeave();
    }
    else if (st.equals("Faculty Leave")) {
       new TeacherLeave();
    }
    else if (st.equals("Faculty Leave Details")) {
       new TeacherLeaveDetails();
    }
    else if (st.equals("Student Leave Details")) {
       new StudentLeaveDetails();
    }
    else if (st.equals("Examination Results")) {
       new marks();
    }
    else if (st.equals("Fees Structure")) {
       new FeeStructure();
    }
    else if (st.equals("Fees Form")) {
       new Studentfeeform();
    }





    }


    public static void main(String[] args) {
        new main_class();
    }
}
