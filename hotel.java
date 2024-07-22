import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class hotel extends JFrame implements ActionListener
{
    hotel()
    {
//setframe
        setSize(1300,600);
        setLocation(100,100);
        setLayout(null);
        setResizable(false);


    //Add Background Image..
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel_firstlook.jpg"));
        JLabel image =new JLabel(i1);

    //Set custom boundries
        image.setBounds(0,0,1365,600);

        add(image);//add picture..

    //Add text in the sceen..
        JLabel text = new JLabel("Hotel Management System");
    //set text attribute and position and color etc...
        text.setBounds(370,30,1000,90);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif",Font.PLAIN,50));

        
        image.add(text);//add text over image.

//Add redirect Button..
        //create button..
        JButton next= new JButton("NEXT");
        next.setBounds(1155,490,90,40);//button position.
        next.setBackground(Color.ORANGE);//button colour..
        next.setForeground(Color.BLACK);//button text colour..
        next.setFont(new Font("serif",Font.PLAIN,20));//frontsize..
        image.add(next);//add button over the image..
        next.addActionListener(this);
        setVisible(true);//set visibility of the output (By default false ).

//blink function of the text..
     /*    while(true){
               text.setVisible(false); //*hide text..
            try
            {
                Thread.sleep(500); //*delay 500 ms..
            }catch(Exception e)
            {
                e.printStackTrace();
            }
               text.setVisible(true); //*Show the text..
            try
            {
                Thread.sleep(500); //*delay 500ms..
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }*/
    }
    //Function of interface..
    public void actionPerformed(ActionEvent ac)
    {
       setVisible(false);
       new Login();
    }
      public static void main(String [] args)
      {
        new hotel();
      } 
}
