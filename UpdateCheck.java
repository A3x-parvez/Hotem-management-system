import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener
{
    Choice customer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending,tfday;
    JButton check,back,update;
    float total;

    UpdateCheck()
    {
        JLabel heading=new JLabel("Update status");
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


         JLabel lbcheckin=new JLabel("Checkin Time");
         lbcheckin.setFont(new Font("PLANE",Font.BOLD,18));
         lbcheckin.setBounds(40,220,150,30);
         lbcheckin.setForeground(Color.BLACK);
         add(lbcheckin);

         tfcheckin= new JTextField();
         tfcheckin.setBounds(220,220,150, 25);
         tfcheckin.setFont(new Font("Bold",Font.BOLD,14));
         add(tfcheckin);


         JLabel lbpaid=new JLabel("Amount Paid");
         lbpaid.setFont(new Font("PLANE",Font.BOLD,18));
         lbpaid.setBounds(40,265,150,30);
         lbpaid.setForeground(Color.BLACK);
         add(lbpaid);

         tfpaid= new JTextField();
         tfpaid.setBounds(220,265,150, 25);
         tfpaid.setFont(new Font("Bold",Font.BOLD,16));
         add(tfpaid);


         JLabel lbday=new JLabel("Day Stayed");
         lbday.setFont(new Font("PLANE",Font.BOLD,18));
         lbday.setBounds(40,310,150,30);
         lbday.setForeground(Color.BLACK);
         add(lbday);

         tfday= new JTextField();
         tfday.setBounds(220,310,150, 25);
         tfday.setFont(new Font("Bold",Font.BOLD,16));
         add(tfday);


         JLabel lbpending=new JLabel("Amount Pending");
         lbpending.setFont(new Font("PLANE",Font.BOLD,18));
         lbpending.setBounds(40,355,150,30);
         lbpending.setForeground(Color.BLACK);
         add(lbpending);

         tfpending= new JTextField();
         tfpending.setBounds(220,355,150, 25);
         tfpending.setFont(new Font("Bold",Font.BOLD,16));
         add(tfpending);


         check = new JButton("Check");
         check.setForeground(Color.BLACK);
         check.setBackground(Color.YELLOW);
         check.setBounds(40,390,100,35);
         check.setFont(new Font("bold",Font.PLAIN,20));
         check.addActionListener(this);
         add(check);
   
         update= new JButton("Update");
         update.setForeground(Color.BLACK);
         update.setBackground(Color.green);
         update.setBounds(150,390,100,35);
         update.setFont(new Font("bold",Font.PLAIN,20));
         update.addActionListener(this);
         add(update);

         
         back = new JButton("Back");
         back.setForeground(Color.BLACK);
         back.setBackground(Color.red);
         back.setBounds(260,390,100,35);
         back.setFont(new Font("bold",Font.PLAIN,20));
         back.addActionListener(this);
        add(back);



    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("searchroom_bg.jpg"));
    Image i5 = i4.getImage().getScaledInstance(1050, 700, Image.SCALE_DEFAULT); 
    ImageIcon i6 = new ImageIcon(i5);
    JLabel b_img =new JLabel(i6);
    b_img.setBounds(0,0,1050,700);//image position and attribute..
    add(b_img);


    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("checkin_out.jpg"));
    JLabel img2= new JLabel(i1);
    img2.setBounds(420,60,500,300);
    b_img.add(img2);

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
        String qu="select * from customer where Number ='"+id+"'";

        /*try {
            connect c = new connect();
            ResultSet rs = c.s.executeQuery(qu);

            while (rs.next()) {
                tfroom.setText(rs.getString("Room_no"));
                tfname.setText(rs.getString("Name"));
                tfcheckin.setText(rs.getString("Check_in_time"));
                tfpaid.setText(rs.getString("Deposit"));
                
            }
        String day =tfday.getText();

            ResultSet rs2 = c.s.executeQuery("select * from room where Room_no='"+tfroom.getText()+"'");
            
            while (rs2.next()) 
            {
                String price = rs2.getString("price");
                total=( Float.parseFloat(day)*Float.parseFloat(price) );
                float amount =total-Float.parseFloat(tfpaid.getText());
                tfpending.setText(""+amount);
            }
            
           } catch (Exception ec) {
               ec.printStackTrace();  
        }  */

        try {
            connect c = new connect();
            ResultSet rs = c.s.executeQuery(qu);

            while (rs.next()) {
                tfroom.setText(rs.getString("Room_no"));
                tfname.setText(rs.getString("Name"));
                tfcheckin.setText(rs.getString("Check_in_time"));
                tfpaid.setText(rs.getString("Deposit"));

                String day = tfday.getText();

                if (!day.isEmpty()) {
                    ResultSet rs2 = c.s.executeQuery("select * from room where Room_no='" + tfroom.getText() + "'");

                    while (rs2.next()) {
                        String price = rs2.getString("price");
                        total = Float.parseFloat(day) * Float.parseFloat(price);
                        float amount = total - Float.parseFloat(tfpaid.getText());
                        tfpending.setText("" + amount);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the number of days stayed.");
                }
            }
        } catch (Exception ec) {
            ec.printStackTrace();
        }


        }
        else if(e.getSource()==update) 
        {
           String number = customer.getSelectedItem();
           String room = tfroom.getText();
           String name = tfname.getText();
           String checkin = tfcheckin.getText();
           String deposit = tfpaid.getText();
           
           String Total=String.valueOf(total);
           
           if(room.equals("") || name.equals("") || checkin.equals("") || deposit.equals(""))
           {
            JOptionPane.showMessageDialog(null, "Please Fill the Information.");
            return ;
            }

           try {

            connect c = new connect();
            c.s.executeUpdate("update customer set Room_no ='"+room+"' , Name ='"+name+"',Deposit='"+deposit+"' where Number ='"+number+"'");
            c.s.executeUpdate("update Bill set Total ='"+Total+"',Deposit='"+deposit+"' where Number ='"+number+"'");
           // c.s.executeUpdate("insert into Bill values('"+number+"','"+name+"','"+room+"','"+deposit+"','"+Total+"')");


            JOptionPane.showMessageDialog(null,"Data update sucessfully");
            setVisible(false);
            new UpdateCheck();

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
        new UpdateCheck();
        
    }
}