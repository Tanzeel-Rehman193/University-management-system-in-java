package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudents extends JFrame implements ActionListener {
    JTextField textName,textFather,textAddress,textPhone,textEmail,textXII;
    JLabel empText;
    JComboBox courseBox,departmentBox;
    JDateChooser cdob ;
    JButton submit, Cancel;


    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong()%9000) + 1000L);

    AddStudents(){
        getContentPane().setBackground(new Color(162, 227, 162));
        //heading
        JLabel heading =  new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        textName = new JTextField();
        textName.setBounds(170,150,200,30);
        add(textName);
        //Father Name
        JLabel fName = new JLabel("Father Name");
        fName.setBounds(400,150,200,30);
        fName.setFont(new Font("serif",Font.BOLD,20));
        add(fName);
        textFather = new JTextField();
        textFather.setBounds(580,150,200,30);
        add(textFather);
        //Employee id
        JLabel empId = new JLabel("Roll No");
        empId.setBounds(50,200,200,30);
        empId.setFont(new Font("serif",Font.BOLD,20));
        add(empId);
        empText = new JLabel("2911"+f4);
        empText.setBounds(200,200,200,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);
        //Date of birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        cdob = new JDateChooser();
        cdob.setBounds(580,200,200,30);
        add(cdob);
        //address
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);
        textAddress = new JTextField();
        textAddress.setBounds(170,250,200,30);
        add(textAddress);
        //Phone number
        JLabel ph = new JLabel("Phone");
        ph.setBounds(400,250,200,30);
        ph.setFont(new Font("serif",Font.BOLD,20));
        add(ph);
        textPhone = new JTextField();
        textPhone.setBounds(580,250,200,30);
        add(textPhone);
        //Email
        JLabel email = new JLabel("Email ID");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);
        textEmail = new JTextField();
        textEmail.setBounds(170,300,200,30);
        add(textEmail);
        //12th %
        JLabel Twelve = new JLabel("Class XII (%)");
        Twelve.setBounds(400,300,200,30);
        Twelve.setFont(new Font("serif",Font.BOLD,20));
        add(Twelve);
        textXII = new JTextField();
        textXII.setBounds(580,300,200,30);
        add(textXII);
        //Qualification
        JLabel qualification = new JLabel("Course");
        qualification.setBounds(50,350,200,30);
        qualification.setFont(new Font("serif",Font.BOLD,20));
        add(qualification);
        String course[] = {"BSCS","BSE","BBA","BCOM","BCA","MBA","MCOM","MSC"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(170,350,200,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);
        //Department
        JLabel department = new JLabel("Branch");
        department.setBounds(400,350,200,30);
        department.setFont(new Font("serif",Font.BOLD,20));
        add(department);
        String Department[] = {"Computer Science","Electrical","Math","Civil","IT"};
        departmentBox = new JComboBox(Department);
        departmentBox.setBounds(580,350,200,30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);
        //Buttons
        submit = new JButton("Submit");
        submit.setBounds(250,450,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        Cancel= new JButton("Cancel");
        Cancel.setBounds(450,450,120,30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        add(Cancel);



        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
//            String name=textName.getText();
//            String fname=textFather.getText();
//            String empID =empText.getText();
//            String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
//            String address=textAddress.getText();
//            String phone=textPhone.getText();
//            String email=textEmail.getText();
//            String  XII =textEmail.getText();
//            String  rollno =textEmail.getText();
//            String course=(String) courseBox.getSelectedItem();
//            String department =(String) departmentBox.getSelectedItem();
//
//            try{
//                String q="insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','" +phone+"','"+email+"','"+XII+"''"+course+"','"+department+"')";
//                Conn c=new Conn();
//                c.s.executeUpdate(q);
//                JOptionPane.showMessageDialog(null,"Details Inserted");
//                setVisible(false);
//            }
//            catch (Exception E){
//                E.printStackTrace();
//            }
            JOptionPane.showMessageDialog(null,"Details have been submitted successfully");
            setVisible(false);
        }
        else
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudents();
    }
}
