package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {
    Choice choiceEmpID;
    JTable table;
    JButton search,cancel,print;
    StudentLeaveDetails(){

        getContentPane().setBackground(new Color(178,135,156));
        JLabel heading=new JLabel ("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceEmpID = new Choice();
        choiceEmpID.setBounds(180,20,150,20);
        add(choiceEmpID);
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.s.executeQuery("select * from student");
            while (resultSet.next()) {
                choiceEmpID.add(resultSet.getString("rollno"));
            }
        }
        catch (Exception e) {
                e.printStackTrace();
            }

            table = new JTable();
            try {
                Conn c =new Conn();
                ResultSet resultSet = c.s.executeQuery("select * from Studentleave");
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception e) {
                e.printStackTrace();
            }

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0,100,900,600);
            add(scrollPane);

            search= new JButton("Search");
            search.setBounds(20,70,80,20);
            search.addActionListener(this);
            add(search);


            print= new JButton("Print");
            print.setBounds(120,70,80,20);
            print.addActionListener(this);
            add(print);

            cancel= new JButton("Cancel");
            cancel.setBounds(220,70,80,20);
            cancel.addActionListener(this);
            add(cancel);


            setLayout(null);
            setSize(900,700);
            setLocation(300,100);
            setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search)
        {
            String q="select * from Studentleave where rollno  = '"+choiceEmpID.getSelectedItem()+"'";
            try {
                Conn c=new Conn();
                ResultSet resultSet=c.s.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }

        else if (e.getSource()==print){
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }

        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}
