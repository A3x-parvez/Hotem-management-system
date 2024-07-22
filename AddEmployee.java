import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener
{
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfadress,tfadhar;
    JButton submit,cancel;
    JRadioButton rbmale,rbfemale;
    JComboBox cbjob;
   AddEmployee()
   {
     setLayout(null);//off Default layout..
     //Declare all the text lebels...
     JLabel name,age,gender,job,salary,phone,email,adress,adhar;

//main frame...
      setBounds(350,150,850,570);//set framesize..
      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("reg_back.jpg"));
      Image i5 = i4.getImage().getScaledInstance(850, 540, Image.SCALE_DEFAULT); 
      ImageIcon i6 = new ImageIcon(i5);
      JLabel b_img =new JLabel(i6);
      b_img.setBounds(0,0,850,540);//image position and attribute..
      add(b_img);

      ImageIcon ia=new ImageIcon(ClassLoader.getSystemResource("reg_back2.jpg"));
      Image ib = ia.getImage().getScaledInstance(400, 540, Image.SCALE_DEFAULT); 
      ImageIcon ic = new ImageIcon(ib);
      JLabel b2_img =new JLabel(ic);
      b2_img.setBounds(450,0,400,540);//image position and attribute..
      b_img.add(b2_img);

//ALL TEXT LEBELS...
    //Name section..
      //Name text.. 
      name=new JLabel("FULL NAME");
      name.setBounds(60,30,120,30);
      name.setForeground(Color.BLACK);
      name.setFont(new Font("Tahoma",Font.PLAIN,17));
      b_img.add(name);        
      //Name text field..
      tfname= new JTextField();
      tfname.setBounds(200,30,150,30);
      b_img.add(tfname);

      //Age text.. 
      age=new JLabel("AGE");
      age.setBounds(60,80,120,30);
      age.setForeground(Color.BLACK);
      age.setFont(new Font("Tahoma",Font.PLAIN,17));
      b_img.add(age);        
      //Age text field..
      tfage= new JTextField();
      tfage.setBounds(200,80,150,30);
      b_img.add(tfage);
    
      //Gender text.. 
      gender=new JLabel("GENDER");
      gender.setBounds(60,130,120,30);
      gender.setForeground(Color.BLACK);
      gender.setFont(new Font("Tahoma",Font.PLAIN,17));
      b_img.add(gender);        
      //Gender Radio Buttons..
           //Male Radio Button..
           rbmale= new JRadioButton("Male");
           rbmale.setBounds(200,130,70,30);
           rbmale.setFont(new Font ("Tahoma",Font.PLAIN,14));
           rbmale.setBackground(Color.white);
           b_img.add(rbmale);
           //Female Radio Button..
           rbfemale= new JRadioButton("Female");
           rbfemale.setBounds(280,130,70,30);
           rbfemale.setFont(new Font ("Tahoma",Font.PLAIN,14));
           rbfemale.setBackground(Color.white);
           b_img.add(rbfemale);
                //group Male and Female button using ButtonGroup class..
                ButtonGroup ob = new ButtonGroup();
                ob.add(rbmale);
                ob.add(rbfemale);

      //Job text.. 
      job=new JLabel("JOB");
      job.setBounds(60,180,120,30);
      job.setForeground(Color.BLACK);
      job.setFont(new Font("Tahoma",Font.PLAIN,17));
      b_img.add(job);        
      //Job text field..
      String str[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
      cbjob = new JComboBox<>(str);
      cbjob.setBounds(200,180,150,30);
      cbjob.setBackground(Color.WHITE);
      b_img.add(cbjob);

      //Name text.. 
      salary=new JLabel("SALARY");
      salary.setBounds(60,230,120,30);
      salary.setForeground(Color.BLACK);
      salary.setFont(new Font("Tahoma",Font.PLAIN,17));
      b_img.add(salary);        
      //Name text field..
      tfsalary= new JTextField();
      tfsalary.setBounds(200,230,150,30);
      b_img.add(tfsalary);

      //Phone text.. 
      phone=new JLabel("PHONE NO");
      phone.setBounds(60,280,120,30);
      phone.setForeground(Color.BLACK);
      phone.setFont(new Font("Tahoma",Font.PLAIN,17));
      b_img.add(phone);        
      //Phone text field..
      tfphone= new JTextField();
      tfphone.setBounds(200,280,150,30);
      b_img.add(tfphone);

      //Email text.. 
      email=new JLabel("EMAIL");
      email.setBounds(60,330,120,30);
      email.setForeground(Color.BLACK);
      email.setFont(new Font("Tahoma",Font.PLAIN,17));
      b_img.add(email);        
      //Email text field..
      tfemail= new JTextField();
      tfemail.setBounds(200,330,150,30);
      b_img.add(tfemail);

      //Adress text.. 
      adress=new JLabel("ADRESS");
      adress.setBounds(60,380,120,30);
      adress.setForeground(Color.BLACK);
      adress.setFont(new Font("Tahoma",Font.PLAIN,17));
      b_img.add(adress);        
      //Adress text field..
      tfadress=new JTextField();
      tfadress.setBounds(200,380,150,30);
      b_img.add(tfadress);
      
      //Aadhar text.. 
      adhar=new JLabel("AADHAR NO");
      adhar.setBounds(60,430,120,30);
      adhar.setForeground(Color.BLACK);
      adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
      b_img.add(adhar);        
      //Adhar text field..
      tfadhar=new JTextField();
      tfadhar.setBounds(200,430,150,30);
      b_img.add(tfadhar);

//Submit button...
    submit=new JButton("SUBMIT");
    submit.setBackground(Color.BLUE);
    submit.setForeground(Color.BLACK);
    submit.setBounds(80,480,120,35);
    submit.addActionListener(this);
    b_img.add(submit);
//cancel button..
    cancel=new JButton("Exit");
    cancel.setBackground(Color.BLUE);
    cancel.setForeground(Color.BLACK);
    cancel.setBounds(210,480,120,35);
    cancel.addActionListener(this);
    b_img.add(cancel);
    
        setResizable(false);
        setVisible(true);
   }

   //action listner function
   public void actionPerformed(ActionEvent ae)
   {
   String name,age,salary,phone,email,address,adhar;
   name=tfname.getText();
   age=tfage.getText();
   salary=tfsalary.getText();
   phone=tfphone.getText();
   email=tfemail.getText();
   address=tfadress.getText();
   adhar=tfadhar.getText();

   String gender = null;
      if(rbmale.isSelected())
      {
        gender="male";
      }else if(rbfemale.isSelected())
      {
        gender="female";
      }

    String job= (String) cbjob.getSelectedItem();
    
    if(ae.getSource()==submit)
    {
     if(name.equals("")&& age.equals("")&& salary.equals("")&& phone.equals("")&& email.equals("")&& address.equals("") && adhar.equals("") )
     {
      JOptionPane.showMessageDialog(null, "Please Fill the Information.");
      return ;
      }

    try
    {
      connect obj = new connect();//connection object..
    String quarry = "insert into emp_details values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+address+"','"+adhar+"')";
    obj.s.executeUpdate(quarry);
    JOptionPane.showMessageDialog(null,"Employee added");
    setVisible(false);
  }catch(Exception e){
      e.printStackTrace();
    }
  }
  else if(ae.getSource()==cancel)
  {
    JOptionPane.showMessageDialog(null,"Are you sure");
    setVisible(false);
  }
  
   }
    public static void main(String[] args)
     {
       new AddEmployee(); 
    }
    
}
