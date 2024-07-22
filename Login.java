import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
      JTextField username;
      JPasswordField password;
      JButton login,cancel;
    Login()
    {
      getContentPane().setBackground(Color.WHITE);//change background colour..

      setLayout(null);//set custom layout..
//set background image..
      ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("login_page.jpg"));
      JLabel l_img =new JLabel(i2);
      l_img.setBounds(-7,0,400,600);//image position and attribute..
      add(l_img);//add image into the frame..

//login text on the top of the screen..
      JLabel log =new JLabel("Login");
      log.setBounds(150,20,100,60);
      log.setFont(new Font("serif",Font.BOLD,40));
      l_img.add(log);

 //user name section...
      //Username title...
      JLabel user = new JLabel("Username");
      user.setBounds(85,100,100,30);
      user.setFont( new Font ("serif",Font.BOLD,20));
      l_img.add(user);
      //Text box for username...
      username = new JTextField();
      username.setBounds(85,130,230,30);
      l_img.add(username);

 //password section...
      //Password title...
      JLabel pass = new JLabel("Password");
      pass.setBounds(85,170,100,30);
      pass.setFont(new Font ("serif",Font.BOLD,20));
      l_img.add(pass);
      //Text box for password..
      password = new JPasswordField();
      password.setBounds(85,200,230,30);
      l_img.add(password);
//*Buttons.
      //login button...
      login = new JButton("Log in");
      login.setBounds(145,280,110,40);
      login.setBackground(Color.CYAN);
      login.setFont(new Font ("serif",Font.BOLD,20));
      login.setForeground(Color.BLACK);
      login.addActionListener(this);
      l_img.add(login);

      //cancel button...
      cancel =new JButton("Cancel");
      cancel.setBounds(145,330,110,40);
      cancel.setBackground(Color.CYAN);
      cancel.setFont(new Font ("serif",Font.BOLD,20));
      cancel.setForeground(Color.BLACK);
      cancel.addActionListener(this);
      l_img.add(cancel);
    

// Create the full frame (main frame).... 
        setBounds(500,200,400,500);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==login)
      {
        String user =username.getText();
        String pass =password.getText();
      //  String pass =password.getName();

        try{
          //Employee login..
           connect c =new connect();
           String query ="select * from login where username = '"+user+"' and password = '"+pass+"'"; 
          ResultSet rs= c.s.executeQuery(query);
          //Admin login..
          connect d = new connect();
          String query1 ="select * from admin_log where username = '"+user+"' and password = '"+pass+"'"; 
          ResultSet ad= d.s.executeQuery(query1);

            if(rs.next())
            {
               JOptionPane.showMessageDialog(null,"Login sucessfull as a Employee");
               setVisible(false);
               new Emp_daseboard();
            }
            else if(ad.next())
            {
              JOptionPane.showMessageDialog(null,"Login sucessfull as a Admin");
              setVisible(false);
              new Daseboard();  
            }
            else
            {
               JOptionPane.showMessageDialog(null,"Invalid username or password");
               setVisible(false);
               new Login();
            }

        }catch(Exception c){
            c.printStackTrace();
        }
      }
      else if(ae.getSource()==cancel)
      {
         setVisible(false);
      }
    }
    public static void main(String [] args)
    {
        new Login();
    }
}
