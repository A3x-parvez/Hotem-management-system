import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reception extends JFrame implements ActionListener
{   
    JButton exit,done;
    JButton new_cust,room,dept,all_emp_info,cust_info,aboutus,check_out,update_status,update_room_status,pick_up,search_room,logout;
    Reception()
    {
    //set background image..
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("reps_bg.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1160, 650, Image.SCALE_DEFAULT); 
    ImageIcon i3 = new ImageIcon(i2);
    JLabel img_bg= new JLabel(i3);
    img_bg.setBounds(0,0,1160,650);
    add(img_bg);

//Customer add button...
      new_cust =new JButton("New Customer");
      new_cust.setBounds(112,62,200,35);
      new_cust.setBackground(Color.WHITE);
      new_cust.setFont(new Font ("Bold",Font.BOLD,15));
      new_cust.setForeground(Color.BLACK);
      new_cust.addActionListener(this);
      img_bg.add(new_cust);

//Room add button...
      room =new JButton("Rooms");
      room.setBounds(112,108,200,35);
      room.setBackground(Color.WHITE);
      room.setFont(new Font ("Bold",Font.BOLD,15));
      room.setForeground(Color.BLACK);
      room.addActionListener(this);
      img_bg.add(room);

//Department Button...
      search_room =new JButton("Search Room");
      search_room.setBounds(112,153,200,35);
      search_room.setBackground(Color.WHITE);
      search_room.setFont(new Font ("Bold",Font.BOLD,15));
      search_room.setForeground(Color.BLACK);
      search_room.addActionListener(this);
      img_bg.add(search_room);

//Customer info
      cust_info =new JButton("Customer Info");
      cust_info.setBounds(112,198,200,35);
      cust_info.setBackground(Color.WHITE);
      cust_info.setFont(new Font ("Bold",Font.BOLD,15));
      cust_info.setForeground(Color.BLACK);
      cust_info.addActionListener(this);
      img_bg.add(cust_info);

      //update status...
      update_status =new JButton("Update Status");
      update_status.setBounds(112,243,200,35);
      update_status.setBackground(Color.WHITE);
      update_status.setFont(new Font ("Bold",Font.BOLD,15));
      update_status.setForeground(Color.BLACK);
      update_status.addActionListener(this);
      img_bg.add(update_status);
      
      //check out..
      check_out =new JButton("Check Out");
      check_out.setBounds(112,288,200,35);
      check_out.setBackground(Color.WHITE);
      check_out.setFont(new Font ("Bold",Font.BOLD,15));
      check_out.setForeground(Color.BLACK);
      check_out.addActionListener(this);
      img_bg.add(check_out);
      
      //update room status...
      update_room_status =new JButton("Update Room Status");
      update_room_status.setBounds(112,333,200,35);
      update_room_status.setBackground(Color.WHITE);
      update_room_status.setFont(new Font ("Bold",Font.BOLD,15));
      update_room_status.setForeground(Color.BLACK);
      update_room_status.addActionListener(this);
      img_bg.add(update_room_status);
      
      //pick up services
      pick_up =new JButton("Pick Up");
      pick_up.setBounds(112,378,200,35);
      pick_up.setBackground(Color.WHITE);
      pick_up.setFont(new Font ("Bold",Font.BOLD,15));
      pick_up.setForeground(Color.BLACK);
      pick_up.addActionListener(this);
      img_bg.add(pick_up);
      
      //Department..
      dept =new JButton("Department");
      dept.setBounds(112,423,200,35);
      dept.setBackground(Color.WHITE);
      dept.setFont(new Font ("Bold",Font.BOLD,15));
      dept.setForeground(Color.BLACK);
      dept.addActionListener(this);
      img_bg.add(dept);
      
      //all employee info..
      all_emp_info =new JButton("All Employee Info");
      all_emp_info.setBounds(112,468,200,35);
      all_emp_info.setBackground(Color.WHITE);
      all_emp_info.setFont(new Font ("Bold",Font.BOLD,15));
      all_emp_info.setForeground(Color.BLACK);
      all_emp_info.addActionListener(this);
      img_bg.add(all_emp_info);
      
      //manager info...
      aboutus =new JButton("About Us");
      aboutus.setBounds(112,513,200,35);
      aboutus.setBackground(Color.WHITE);
      aboutus.setFont(new Font ("Bold",Font.BOLD,15));
      aboutus.setForeground(Color.BLACK);
      aboutus.addActionListener(this);
      img_bg.add(aboutus);
      
      //log out..
      logout =new JButton("Log Out");
      logout.setBounds(112,558,200,35);
      logout.setBackground(Color.WHITE);
      logout.setFont(new Font ("Bold",Font.BOLD,15));
      logout.setForeground(Color.BLACK);
      logout.addActionListener(this);
      img_bg.add(logout);

//Exit button..
      exit =new JButton("EXIT");
      exit.setBounds(1014,576,74,38);
      exit.setBackground(Color.RED);
      exit.setFont(new Font ("Bold",Font.BOLD,15));
      exit.setForeground(Color.BLACK);
      exit.addActionListener(this);
      img_bg.add(exit);

//Done Button...
      done =new JButton("OK");
      done.setBounds(912,576,75,38);
      done.setBackground(Color.GREEN);
      done.setFont(new Font ("Bold",Font.BOLD,15));
      done.setForeground(Color.BLACK);
     // new_cust.addActionListener(this);
      img_bg.add(done);

   
    // Create the full frame (main frame).... 
       setBounds(200,90,1160,685);
       //setResizable(false);
       setVisible(true);
    }

    public void actionPerformed(ActionEvent ac)
    {
      if(ac.getSource()==new_cust)
      {
            setVisible(false);
            new AddCust();
      }
      else if(ac.getSource()==room)
      {
            setVisible(false);
            new Rooms();
      }
      else if(ac.getSource()==search_room)
      {
           setVisible(false);
           new searchRoom();
      }
      else if(ac.getSource()==cust_info)
      {
        setVisible(false);
        new Custinfo();
      }
      else if(ac.getSource()==check_out)
      {
        setVisible(false);
        new Checkout();
      }
      else if(ac.getSource()==update_status)
      {
         setVisible(false);
         new UpdateCheck();
      }
      else if(ac.getSource()==update_room_status)
      {
         setVisible(false);
         new UpdateRoom();
      }
      else if(ac.getSource()==pick_up)
      {
        JOptionPane.showMessageDialog(null,"Currently not available");
      }
      else if(ac.getSource()==dept)
      {
         setVisible(false);
         new Dept();
      }
      else if(ac.getSource()==all_emp_info)
      {
            setVisible(false);
        new Empinfo();
      }
      else if(ac.getSource()==aboutus)
      {
          new about();
      }
      else if(ac.getSource()==logout)
      {
         JOptionPane.showMessageDialog(null, "Log out sucessfull");
         setVisible(false);
         new Login();
      }
      else if(ac.getSource()==exit)
      {
            setVisible(false);
      }
    }
    public static void main(String[] args) 
    {
     new Reception();
    }
}

