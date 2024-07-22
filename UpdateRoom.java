import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener
{
    Choice customer;
    JTextField tfroom,tfname,tfavailable,tfclean;
    JButton check,back,update;
    UpdateRoom()
    {
        JLabel heading=new JLabel("Update Room");
        heading.setFont(new Font("PLANE",Font.BOLD,30));
        heading.setBounds(100,20,250,30);
        heading.setForeground(Color.BLACK);
        add(heading);

         JLabel lbid=new JLabel("Customer id");
         lbid.setFont(new Font("PLANE",Font.BOLD,19));
         lbid.setBounds(40,80,150,30);
         lbid.setForeground(Color.BLACK);
         add(lbid);

         customer = new Choice();
         customer.setBounds(220,80,150,25);
         customer.setFont(new Font("Bold",Font.BOLD,16));
         add(customer);

         try {
            connect c= new connect();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) 
            {
                customer.add(rs.getString("Number"));
            }
         } catch (Exception e) {
            e.printStackTrace();
         }


         JLabel lbroom=new JLabel("Room Number");
         lbroom.setFont(new Font("PLANE",Font.BOLD,18));
         lbroom.setBounds(40,130,150,30);
         lbroom.setForeground(Color.BLACK);
         add(lbroom);

         tfroom = new JTextField();
         tfroom.setBounds(220,130,150, 25);
         tfroom.setFont(new Font("Bold",Font.BOLD,16));
         add(tfroom);


         JLabel lbname=new JLabel("Customer Name");
         lbname.setFont(new Font("PLANE",Font.BOLD,18));
         lbname.setBounds(40,175,150,30);
         lbname.setForeground(Color.BLACK);
         add(lbname);

         tfname= new JTextField();
         tfname.setBounds(220,175,150, 25);
         tfname.setFont(new Font("Bold",Font.BOLD,16));
         add(tfname);


         JLabel lbavailable=new JLabel("Availability");
         lbavailable.setFont(new Font("PLANE",Font.BOLD,18));
         lbavailable.setBounds(40,220,150,30);
         lbavailable.setForeground(Color.BLACK);
         add(lbavailable);

         tfavailable= new JTextField();
         tfavailable.setBounds(220,220,150, 25);
         tfavailable.setFont(new Font("Bold",Font.BOLD,14));
         add(tfavailable);


         JLabel lbclean=new JLabel("Cleaning status");
         lbclean.setFont(new Font("PLANE",Font.BOLD,18));
         lbclean.setBounds(40,265,150,30);
         lbclean.setForeground(Color.BLACK);
         add(lbclean);

         tfclean= new JTextField();
         tfclean.setBounds(220,265,150, 25);
         tfclean.setFont(new Font("Bold",Font.BOLD,16));
         add(tfclean);


    
         check = new JButton("Check");
         check.setForeground(Color.BLACK);
         check.setBackground(Color.YELLOW);
         check.setBounds(40,380,100,35);
         check.setFont(new Font("bold",Font.PLAIN,20));
         check.addActionListener(this);
         add(check);
   
         update= new JButton("Update");
         update.setForeground(Color.BLACK);
         update.setBackground(Color.green);
         update.setBounds(150,380,100,35);
         update.setFont(new Font("bold",Font.PLAIN,20));
         update.addActionListener(this);
         add(update);

         
         back = new JButton("Back");
         back.setForeground(Color.BLACK);
         back.setBackground(Color.red);
         back.setBounds(260,380,100,35);
         back.setFont(new Font("bold",Font.PLAIN,20));
         back.addActionListener(this);
        add(back);



    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("new_room.jpg"));
    Image i5 = i4.getImage().getScaledInstance(960, 490, Image.SCALE_DEFAULT); 
    ImageIcon i6 = new ImageIcon(i5);
    JLabel b_img =new JLabel(i6);
    b_img.setBounds(0,0,960,490);//image position and attribute..
    add(b_img);


    //ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("checkin_out.jpg"));
    //JLabel img2= new JLabel(i1);
    //img2.setBounds(420,60,500,300);
    //b_img.add(img2);

     getContentPane().setBackground(Color.WHITE);
     setBounds(300,200,960,490);
     setLayout(null);
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==check)
        {
        String id = customer.getSelectedItem();
       // String qu1="select * from customer where Room_no='"+id+"'";
        String qu="select * from customer where Number='"+id+"'";

        try {
            connect c = new connect();
            ResultSet rs = c.s.executeQuery(qu);

            while (rs.next()) {
                tfroom.setText(rs.getString("Room_no"));
                tfname.setText(rs.getString("Name"));
               // tfcheckin.setText(rs.getString("Check_in_time"));
            }

            ResultSet rs2 = c.s.executeQuery("select * from room where Room_no='"+tfroom.getText()+"'");
            
            while (rs2.next()) 
            {
                tfavailable.setText(rs2.getString("availability"));
                tfclean.setText(rs2.getString("clean_status"));
            }
            
           } catch (Exception ec) {
               ec.printStackTrace();  
        }

        }
        else if(e.getSource()==update) 
        {
           String room_no = tfroom.getText();
           String number= customer.getSelectedItem();
           String name = tfname.getText();
           String avl_sts = tfavailable.getText();
           String clean = tfclean.getText();

           try {

            connect c = new connect();
            c.s.executeUpdate("update room set  availability='"+avl_sts+"',clean_status ='"+clean+"' where Room_no ='"+room_no+"'");
            JOptionPane.showMessageDialog(null,"Data update sucessfully");
            setVisible(false);
            new UpdateRoom();

           } catch (Exception ed) {
           ed.printStackTrace();
           }
        }
        else if(e.getSource()==back)
        {
            JOptionPane.showMessageDialog(null, "Are you sure ? ");
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) 
    {
        new UpdateRoom();
        
    }
}