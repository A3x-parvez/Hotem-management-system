import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;;

public class AddCust extends JFrame implements ActionListener
{
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JButton submit,back;
    JRadioButton rbmale,rbfemale;
    JComboBox cbid;
    Choice croom_no;
    JLabel checkin;

   AddCust()
   {
     setLayout(null);//off Default layout..
     //Declare all the text lebels...
     JLabel id,number,name,gender,country,room_no,check_in_time,deposit;

//main frame...
      setBounds(350,150,850,570);//set framesize..
      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("reg_back.jpg"));
      Image i5 = i4.getImage().getScaledInstance(850, 540, Image.SCALE_DEFAULT); 
      ImageIcon i6 = new ImageIcon(i5);
      JLabel b_img =new JLabel(i6);
      b_img.setBounds(0,0,850,540);//image position and attribute..
      add(b_img);

      //ImageIcon ia=new ImageIcon(ClassLoader.getSystemResource("add_cust_bg.jpg"));
      //Image ib = ia.getImage().getScaledInstance(400, 540, Image.SCALE_DEFAULT); 
      //ImageIcon ic = new ImageIcon(ib);
      //JLabel b2_img =new JLabel(ic);
      //b2_img.setBounds(450,0,400,540);//image position and attribute..
      //b_img.add(b2_img);


//Add heading..
      JLabel heading=new JLabel("Add Customer");
      heading.setFont(new Font("PLANE",Font.BOLD,30));
      heading.setBounds(105,0,250,40);
      heading.setForeground(Color.BLACK);
      b_img.add(heading);
//ALL TEXT LEBELS...
    //id section..
      //id text...
      id=new JLabel("CUSTOMER ID");
      id.setBounds(60,60,150,30);
      id.setForeground(Color.BLACK);
      id.setFont(new Font("Tahoma",Font.BOLD,17));
      b_img.add(id);        
      //id text field..
      String str[]={"Voter Id","Adhard","Passport","Driving License","Ration Card"};
      cbid = new JComboBox<>(str);
      cbid.setBounds(210,60,150,30);
      cbid.setFont(new Font("Tahoma",Font.PLAIN,15));
      cbid.setBackground(Color.WHITE);
      b_img.add(cbid);

    //Number section..
      //Number text.. 
      number=new JLabel("NUMBER");
      number.setBounds(60,110,120,30);
      number.setForeground(Color.BLACK);
      number.setFont(new Font("Tahoma",Font.BOLD,17));
      b_img.add(number);        
      //Number text field..
      tfnumber= new JTextField();
      tfnumber.setBounds(210,110,150,30);
      b_img.add(tfnumber);
    
    //Name section..
      //Name text.. 
      name=new JLabel("FULL NAME");
      name.setBounds(60,160,120,30);
      name.setForeground(Color.BLACK);
      name.setFont(new Font("Tahoma",Font.BOLD,17));
      b_img.add(name);        
      //Name text field..
      tfname= new JTextField();
      tfname.setBounds(210,160,150,30);
      b_img.add(tfname);
    
    //Gender section...
      //Gender text.. 
      gender=new JLabel("GENDER");
      gender.setBounds(60,210,120,30);
      gender.setForeground(Color.BLACK);
      gender.setFont(new Font("Tahoma",Font.BOLD,17));
      b_img.add(gender);        
      //Gender Radio Buttons..
           //Male Radio Button..
           rbmale= new JRadioButton("Male");
           rbmale.setBounds(210,210,70,30);
           rbmale.setFont(new Font ("Tahoma",Font.PLAIN,14));
           rbmale.setBackground(Color.white);
           b_img.add(rbmale);
           //Female Radio Button..
           rbfemale= new JRadioButton("Female");
           rbfemale.setBounds(290,210,70,30);
           rbfemale.setFont(new Font ("Tahoma",Font.PLAIN,14));
           rbfemale.setBackground(Color.white);
           b_img.add(rbfemale);
                //group Male and Female button using ButtonGroup class..
                ButtonGroup ob = new ButtonGroup();
                ob.add(rbmale);
                ob.add(rbfemale);

    //country section..
      //country text.. 
      country=new JLabel("COUNTRY");
      country.setBounds(60,260,120,30);
      country.setForeground(Color.BLACK);
      country.setFont(new Font("Tahoma",Font.BOLD,17));
      b_img.add(country);        
      //Name text field..
      tfcountry= new JTextField();
      tfcountry.setBounds(210,260,150,30);
      b_img.add(tfcountry);

    //add room section.
      //room no text..
      room_no=new JLabel("ROOM NO");
      room_no.setBounds(60,310,120,30);
      room_no.setForeground(Color.BLACK);
      room_no.setFont(new Font("Tahoma",Font.BOLD,17));
      b_img.add(room_no);        
      //room no combo box..
      croom_no = new Choice();
      try {
        connect con =new connect();
        String qu="select * from room where availability='Available' and clean_status = 'Cleaned'";
        ResultSet rs = con.s.executeQuery(qu);
        while(rs.next())
        {
          String no=rs.getString("room_no");
          String ty=rs.getString("bed_type");
          croom_no.add(no+" ("+ty+")");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      croom_no.setBounds(210,313,150,30);
      croom_no.setBackground(Color.WHITE);
      croom_no.setFont(new Font("Tahoma",Font.PLAIN,15));
      b_img.add(croom_no);
   
    //check in time section..
      //check in time text.. 
      check_in_time=new JLabel("CHECK IN TIME");
      check_in_time.setBounds(60,360,150,30);
      check_in_time.setForeground(Color.BLACK);
      check_in_time.setFont(new Font("Tahoma",Font.BOLD,17));
      b_img.add(check_in_time);        
      //checkin time field..
      Date d=new Date();
      checkin= new JLabel(""+d);
      checkin.setBounds(210,360,150,30);
      checkin.setFont(new Font("Raleway",Font.BOLD,15));
      checkin.setForeground(Color.black);
      b_img.add(checkin);

    //Deposit section..
      //deposit text.. 
      deposit=new JLabel("DEPOSIT");
      deposit.setBounds(60,410,120,30);
      deposit.setForeground(Color.BLACK);
      deposit.setFont(new Font("Tahoma",Font.BOLD,17));
      b_img.add(deposit);        
      //Adress text field..
      tfdeposit=new JTextField();
      tfdeposit.setBounds(210,410,150,30);
      b_img.add(tfdeposit);
      

//Submit button...
    submit=new JButton("SUBMIT");
    submit.setBackground(Color.GREEN);
    submit.setForeground(Color.BLACK);
    submit.setBounds(80,480,120,35);
    submit.addActionListener(this);
    b_img.add(submit);
//cancel button..
    back=new JButton("BACK");
    back.setBackground(Color.RED);
    back.setForeground(Color.BLACK);
    back.setBounds(210,480,120,35);
    back.addActionListener(this);
    b_img.add(back);
    
        setResizable(false);
        setVisible(true);
   }

   //action listner function
   public void actionPerformed(ActionEvent ae)
   {
    String name,number,country,deposit;
         name=tfname.getText();
         number=tfnumber.getText();
         country=tfcountry.getText();
         deposit=tfdeposit.getText();
    
    String gender = null;
       if(rbmale.isSelected())
       {
         gender="male";
       }else if(rbfemale.isSelected())
       {
         gender="female";
       }
 
    String id= (String)cbid.getSelectedItem();
    String oroom=croom_no.getSelectedItem();
    String room = oroom.split("\\ ")[0];
    String time=checkin.getText();

     if(ae.getSource()==submit)
     {
      if(name.equals("") || id.equals("")|| number.equals("")&& deposit.equals("")&& country.equals("")&& gender.equals("") && room.equals("") )
      {
       JOptionPane.showMessageDialog(null, "Please Fill the Information.");
       return ;
       }
 
     try
     {
       connect obj= new connect();//connection object..
     String quarry = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
     String quarry2="update room set availability='Occupied' where room_no='"+room+"'";
     obj.s.executeUpdate(quarry);
     obj.s.executeUpdate(quarry2);
     obj.s.executeUpdate("insert into Bill values('"+number+"','"+name+"','"+room+"','"+deposit+"','0')");
     JOptionPane.showMessageDialog(null," New Customer Added");
     setVisible(false);
     new AddCust();
   }catch(Exception e){
       e.printStackTrace();
     }
   }
   else if(ae.getSource()==back)
   {
     JOptionPane.showMessageDialog(null,"Are you sure");
     setVisible(false);
     new Reception();
   }
    
   }
    public static void main(String[] args)
     {
       new AddCust(); 
    }
    
}


