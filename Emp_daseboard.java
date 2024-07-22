import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Emp_daseboard extends JFrame implements ActionListener
{
    Emp_daseboard()
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
    JMenu hotel=new JMenu("  HOTEL MANAGEMENT ");
    hotel.setForeground(Color.BLACK);
    mb.add(hotel);

    //Menue item for Hotel Management option..
    JMenuItem reception =new JMenuItem("RECEPTION");
    hotel.add(reception);
    reception.addActionListener(this);
    setVisible(true);
    }

    public void actionPerformed(ActionEvent ac)
    {
        setVisible(false);
        new Reception();
    }
    
       public static void main(String [] args)
    {
       new Emp_daseboard();
    }
}
