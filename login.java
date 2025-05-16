package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    // Globals
    JTextField textfieldName;
    JPasswordField passwordFeild;
    JButton Login, back;


   login(){
        //username
       JLabel labelname = new JLabel("Username");
       labelname.setBounds(40,20,100,20);
       add(labelname);
        textfieldName = new JTextField();
        textfieldName.setBounds(150,20,150,20);
       add(textfieldName);
       //password
        JLabel labelpass = new JLabel("Password");
        labelpass.setBounds(40,70,100,20);
        add(labelpass);
        passwordFeild = new JPasswordField();
        passwordFeild.setBounds(150,70,150,20);
        add(passwordFeild);
        // Login
        Login = new JButton("Login");
        Login.setBounds(40,140,120,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
        //back
       back = new JButton("Back");
       back.setBounds(180,140,120,30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
        //imageicon
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
       Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel img = new JLabel(i3);
       img.setBounds(350,20,200,200);
       add(img);
        // Bgimage
       ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
       Image i21 = i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
       ImageIcon i33 = new ImageIcon(i21);
       JLabel image = new JLabel(i33);
       image.setBounds(0,0,600,300);
       add(image);


       setSize(600,300);
       setLayout(null);
       setVisible(true);
       setLocation(500,250);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Login){
//        String username = textfieldName.getText();
//        String passward = passwordFeild.getText();
//
//        String querry = "select * from login where username = '"+username+"'and password = '"+passward+"'";
//        try {
//            Conn c = new Conn();
//            ResultSet resultset = c.s.executeQuery(querry);
//            if (resultset.next()){
                setVisible(false);
                new main_class();
//            }
//            else {
//                JOptionPane.showMessageDialog(null,"Invalid Username or password");
//            }
//        }
//        catch (Exception E){
//            E.printStackTrace();
//        }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
