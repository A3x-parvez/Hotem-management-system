import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener
{
     JTextField tfroom,tfprice;
     JButton add_room,cancel;
     JComboBox typecombo,Availablecombo,cleancombo;

    AddRoom()
    {
        setLayout(null);//off Default layout..
        

   //main frame...
         setBounds(350,150,850,500);//set framesize..
         ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("add_room_bg.jpg"));
         Image i5 = i4.getImage().getScaledInstance(850, 500, Image.SCALE_DEFAULT); 
         ImageIcon i6 = new ImageIcon(i5);
         JLabel b_img =new JLabel(i6);
         b_img.setBounds(0,0,850,500);//image position and attribute..
         add(b_img);
   
         ImageIcon ia=new ImageIcon(ClassLoader.getSystemResource("room_bg.jpg"));
         Image ib = ia.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT); 
         ImageIcon ic = new ImageIcon(ib);
         JLabel b2_img =new JLabel(ic);
         b2_img.setBounds(420,0,500,500);//image position and attribute..
         b_img.add(b2_img);
   
   //ALL TEXT LEBELS...
      //Name section..
         //Name text.. 
         JLabel heading=new JLabel("Add Rooms");
         heading.setFont(new Font("PLANE",Font.BOLD,30));
         heading.setBounds(130,10,250,50);
         heading.setForeground(Color.BLACK);
         b_img.add(heading);

      //add room number...
        JLabel room_no=new JLabel ("Room Number");
        room_no.setFont(new Font("Tahoma",Font.BOLD,16));
        room_no.setBounds(60,80,120,20);
        room_no.setForeground(Color.BLACK);
        b_img.add(room_no);
        //add textbox..
        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        b_img.add(tfroom);
   
      //add available ..
        JLabel available=new JLabel ("Available");
        available.setFont(new Font("Tahoma",Font.BOLD,16));
        available.setBounds(60,130,120,30);
        available.setForeground(Color.BLACK);
        b_img.add(available);
        //add combobox...
        String AvailableOptions[]={"Available","Occupied"};
        Availablecombo=new JComboBox(AvailableOptions);//for drop down
        Availablecombo.setBounds(200,130,150,30);
        Availablecombo.setBackground(Color.white);
        b_img.add(Availablecombo);

      //add cleaning ...
        JLabel clean=new JLabel ("Cleaning Status");
        clean .setFont(new Font("Tahoma",Font.BOLD,16));
        clean.setBounds(59,180,140,30);
        clean.setForeground(Color.BLACK);
        b_img.add(clean);
        //add combobox..
        String cleanOptions[]={"Cleaned","Dirty"};
        cleancombo=new JComboBox(cleanOptions);//for drop down
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        b_img.add(cleancombo);

      //add price
        JLabel price=new JLabel ("Price");
        price.setFont(new Font("Tahoma",Font.BOLD,16));
        price.setBounds(60,230,120,30);
        price.setForeground(Color.BLACK);
        b_img.add(price);
        //add text box..
        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        b_img.add(tfprice);

      //add bedtype..
        JLabel type=new JLabel("Bed Type");
        type.setFont(new Font("Tahoma",Font.BOLD,16));
        type.setBounds(60,280,120,30);
        type.setForeground(Color.BLACK);
        b_img.add(type);
      //add combo box..
        String typeOptions[]={"Single Bed","Double Bed"};
        typecombo=new JComboBox(typeOptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.white);
        b_img.add(typecombo); 
        
      //submit button..
        add_room=new JButton("Add Room");
        add_room.setForeground(Color.black);
        add_room.setBackground(Color.green);
        add_room.setBounds(150,350,130,35);
        add_room.addActionListener(this);
        b_img.add(add_room);
      
      //cancel button
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.red);
        cancel.setBounds(150,400,130,35);
        cancel.addActionListener(this);
        b_img.add(cancel);
   
           setResizable(false);
           setVisible(true);
    }

    public void actionPerformed(ActionEvent ac)
    {
      String room,price,type,Available,clean;
      room=tfroom.getText();
      price=tfprice.getText();
      Available=(String)Availablecombo.getSelectedItem();
      clean=(String)cleancombo.getSelectedItem();
      type=(String)typecombo.getSelectedItem();

   if(ac.getSource()==add_room)
   { 

    if(room.equals("") || price.equals("") || Available.equals("") || clean.equals("") || type.equals(""))
     {
      JOptionPane.showMessageDialog(null, "Please Fill the Information.");
      return ;
      }
      
      try
    {
      connect ob = new connect();//connection object..
      String quarry = "insert into room values('"+room+"','"+Available+"','"+clean+"','"+price+"','"+type+"')";
      ob.s.executeUpdate(quarry);
      JOptionPane.showMessageDialog(null,"Room added");
      setVisible(false);
      new AddRoom();
  }catch(Exception e){
      e.printStackTrace();
    }
  }
  else if(ac.getSource()==cancel)
  {
    JOptionPane.showMessageDialog(null,"Canceled");
    setVisible(false);
  }
  

    }

    public static void main(String[] args)
    {
      new AddRoom();  
    } 
}
