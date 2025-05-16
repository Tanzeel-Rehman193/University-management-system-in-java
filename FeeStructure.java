package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FeeStructure extends JFrame implements ActionListener {
    FeeStructure(){
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee structure");
        heading.setBounds(400,200,400,30);
        heading.setFont(new Font("Thoma",Font.BOLD,30));
        add(heading);

        JTable table = new JTable();

        try{
            Conn c =new Conn();
            ResultSet resultSet = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));





        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0,60,1000,700);
        add(js);




        setSize(1000,700);
        setLocation(250,50);
        setLocale(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        new FeeStructure();
    }
}
