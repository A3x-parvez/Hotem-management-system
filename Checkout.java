import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener
{
    Choice customer;
    JTextField tfroom,tfname,tfcheckin,tfpaid;
    JLabel tfcheckout;
    JButton check,back,leave,cal;
    String id,rm;
    Checkout()
    {
      JLabel heading=new JLabel("Checkout");
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


         JLabel checkout=new JLabel("Checkout Time");
         checkout.setFont(new Font("PLANE",Font.BOLD,18));
         checkout.setBounds(40,265,150,30);
         checkout.setForeground(Color.BLACK);
         add(checkout);

         Date date=new Date();
         tfcheckout=new JLabel(""+date);
         tfcheckout.setFont(new Font("PLANE",Font.BOLD,14));
         tfcheckout.setBounds(220,265,150,30);
         tfcheckout.setForeground(Color.BLACK);
         add(tfcheckout);

         JLabel paid=new JLabel("Amount Pending");
         paid.setFont(new Font("PLANE",Font.BOLD,18));
         paid.setBounds(40,305,150,30);
         paid.setForeground(Color.BLACK);
         add(paid);

         tfpaid= new JTextField();
         tfpaid.setBounds(220,305,150, 25);
         tfpaid.setFont(new Font("Bold",Font.BOLD,16));
         add(tfpaid);


         check= new JButton("Check");
         check.setForeground(Color.BLACK);
         check.setBackground(Color.green);
         check.setBounds(40,380,120,35);
         check.setFont(new Font("bold",Font.PLAIN,20));
         check.addActionListener(this);
         add(check);


         leave = new JButton("Checkout");
         leave.setForeground(Color.BLACK);
         leave.setBackground(Color.YELLOW);
         leave.setBounds(180,380,120,35);
         leave.setFont(new Font("bold",Font.PLAIN,20));
         leave.addActionListener(this);
         add(leave);
         leave.setVisible(false);
   
         back = new JButton("Back");
         back.setForeground(Color.BLACK);
         back.setBackground(Color.red);
         back.setBounds(320,380,120,35);
         back.setFont(new Font("bold",Font.PLAIN,20));
         back.addActionListener(this);
         add(back);

         cal = new JButton("Pay Bill");
         cal.setForeground(Color.BLACK);
         cal.setBackground(Color.green);
         cal.setBounds(180,380,120,35);//460
         cal.setFont(new Font("bold",Font.PLAIN,20));
         cal.addActionListener(this);
         add(cal);
         cal.setVisible(false);
         



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

    public void actionPerformed(ActionEvent ac)
    {
      /*if(ac.getSource()==check)
      {
        String id = customer.getSelectedItem();
        String qu="select * from customer where Number='"+id+"'";
        String q2="select * from Bill where Number='"+id+"'";
        float pend = 0.0f;

        try {
            connect c = new connect();
            ResultSet rs = c.s.executeQuery(qu);
            ResultSet rs2=c.s.executeQuery(q2);

            while (rs.next()) {
                tfroom.setText(rs.getString("Room_no"));
                tfname.setText(rs.getString("Name"));
               tfcheckin.setText(rs.getString("Check_in_time"));
            }
            rs.close();

            while (rs2.next()) {
              String depo = rs2.getString("Deposit");
              String tot = rs2.getString("Total");
              if (!tot.isEmpty() && !depo.isEmpty()) {
                  pend = Float.parseFloat(tot) - Float.parseFloat(depo);
                  if (pend != 0) {
                      JOptionPane.showMessageDialog(null, "Atfast pay the Bill ..");
                      add(cal);
                  }
              } else {
                  JOptionPane.showMessageDialog(null, "Total or Deposit is empty");
              }
          }

          rs2.close();
          // Set tfpaid text field outside the loop
          tfpaid.setText("" + pend);
      } catch (Exception e) {
          e.printStackTrace();
      }
      }*/

      if (ac.getSource() == check) {
        
        leave.setVisible(false);
        cal.setVisible(false);

        id = customer.getSelectedItem();
        String qu = "select * from customer where Number='" + id + "'";
        String q2 = "select * from Bill where Number='" + id + "'";

        ResultSet rs = null;
        ResultSet rs2 = null;

        try {
            connect c = new connect();
            rs = c.s.executeQuery(qu);

            while (rs.next()) {
                tfroom.setText(rs.getString("Room_no"));
                tfname.setText(rs.getString("Name"));
                tfcheckin.setText(rs.getString("Check_in_time"));
            }

            rs2 = c.s.executeQuery(q2);
            float pend = 0.0f;

            while (rs2.next()) {
                String depo = rs2.getString("Deposit");
                String tot = rs2.getString("Total");
                if (!tot.isEmpty() && !depo.isEmpty()) {
                    pend = Float.parseFloat(tot) - Float.parseFloat(depo);

                    tfpaid.setText("" + pend);

                    if (pend != 0) {
    
                        JOptionPane.showMessageDialog(null, "Bill amount pending atfast pay the pending amount.");
                        cal.setVisible(true);
                    }
                    else
                    {
                       
                        JOptionPane.showMessageDialog(null, "No amount pending you can checkout.");
                        leave.setVisible(true);
                    }

                    
                    } else {
                    JOptionPane.showMessageDialog(null, "Total or Deposit is empty");
                    }
            }
            rm=tfroom.getText();
            //tfpaid.setText("" + pend);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (rs2 != null) {
                    rs2.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
      } 
        else if(ac.getSource()==leave)
      {
        String q1="delete from customer where Number = '"+id+"'";
        String q2="update room set availability ='Available' where room_no='"+rm+"'";
        String q3="delete from Bill where Number = '"+id+"'";

        try {
            connect c = new connect();
            c.s.executeUpdate(q1);
            c.s.executeUpdate(q2);
            c.s.executeUpdate(q3);
            JOptionPane.showMessageDialog(null,"Checkout done");
            setVisible(false);
            new Checkout();
        } catch (Exception e) {
            
        }
      }
      else if(ac.getSource()==cal)
      {
        new UpdateCheck();
      }
      else
      {
         setVisible(false);
         new Reception();
      }
    }

    public static void main(String[] args) 
    {
        new Checkout();
    }
}
