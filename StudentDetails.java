package university.management.system;

import net.proteanit.sql.DbUtils;
import university.management.Addstudents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDetails extends JFrame implements ActionListener {
    Choice choice;
    JTable table;

    JButton search,print,update,add,cancel;
    StudentDetails(){
        getContentPane().setBackground(new Color(210,252,218));

        JLabel heading=new JLabel ("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice = new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.s.executeQuery("select * from Student");
            while (resultSet.next()) {
                choice.add(resultSet.getString("roll no."));
            }
        }
            catch(Exception e){
                e.printStackTrace();
            }
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.s.executeQuery("select * from Student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0,100,900,600);
        add(js);

        search= new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print= new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update= new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        add= new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);

        cancel= new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
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
            String q="select * from student where roll no = '"+choice.getSelectedItem()+"'";
            try {
                Conn c=new Conn();
                ResultSet resultSet=c.s.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else if (e.getSource() == print)
        {
            String q="select * from student where roll no = '"+choice.getSelectedItem()+"'";
            try {
                table.print();
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource() == add){
            setVisible(false);
            new AddStudents();
        }


        else if (e.getSource() == update){

        }

        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentDetails();
    }
}
