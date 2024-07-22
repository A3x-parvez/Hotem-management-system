import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Daseboard extends JFrame implements ActionListener
{   JButton exit;
    Daseboard()
    {
//set a frame..
    setBounds(-6,0,1550,830);
    setLayout(null);
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Home_page.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT); 
    ImageIcon i3 = new ImageIcon(i2);
    JLabel img_bg= new JLabel(i3);
    img_bg.setBounds(0,0,1550,830);
    add(img_bg);

//set title..
    JLabel text = new JLabel("The Grand Oberoi Hotel");
    text.setBounds(440,45,1500,60);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif",Font.ITALIC,65));
    img_bg.add(text);

//menue bar..
    JMenuBar mb= new JMenuBar();
    mb.setBounds(0,0,1550,30);
    mb.setBackground(Color.ORANGE);
    img_bg.add(mb);

//##Main Menue ..

//Hotel Management menu...
    /*JMenu hotel=new JMenu("  HOTEL MANAGEMENT ");
    hotel.setForeground(Color.BLACK);
    mb.add(hotel);

    //Menue item for Hotel Management option..
    JMenuItem reception =new JMenuItem("RECEPTION");
    hotel.add(reception);
*/

//Admin menu...
    JMenu admin=new JMenu(" ADMIN  ");
    admin.setForeground(Color.BLACK);
    mb.add(admin);

    //Menue item for Hotel Admin option..
    JMenuItem add_emp =new JMenuItem("ADD EMPLOYEE");
    add_emp.addActionListener(this);
    admin.add(add_emp);

    JMenuItem add_room =new JMenuItem("ADD ROOMS");
    add_room.addActionListener(this);
    admin.add(add_room);

    JMenuItem add_driver =new JMenuItem("ADD DRIVER");
    add_driver.addActionListener(this);
    admin.add(add_driver);

    
//log out button..
   exit= new JButton("Log Out");
   exit.setBackground(Color.red);
   exit.setForeground(Color.BLACK);
   exit.setBounds(1370,710,120,35);
   exit.addActionListener(this);
   img_bg.add(exit);

   setVisible(true);

    }
     public void actionPerformed(ActionEvent ab)
     {
        if(ab.getSource()==exit)
        {
            JOptionPane.showMessageDialog(null, "Log out sucessfull");
            setVisible(false);
            new Login();
        }
        else if(ab.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee();
        }
        else if(ab.getActionCommand().equals("ADD ROOMS"))
        {
           new AddRoom();
        }
        else if(ab.getActionCommand().equals("ADD DRIVER"))
        {

        }

     }
       public static void main(String [] args)
    {
       new Daseboard();
    }
}
