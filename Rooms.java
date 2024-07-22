import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener 
{
    JTable table;
    JButton back;
    Rooms()
    {
      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("rooms.jpg"));
      Image i5 = i4.getImage().getScaledInstance(1050, 600, Image.SCALE_DEFAULT); 
      ImageIcon i6 = new ImageIcon(i5);
      JLabel b_img =new JLabel(i6);
      b_img.setBounds(0,0,1050,600);//image position and attribute..
      add(b_img);

     JLabel text = new JLabel("List of Rooms");
     text.setBounds(160,-10,300, 80);
     text.setFont(new Font("BOLD",Font.BOLD,30));
     text.setForeground(Color.BLACK);
     b_img.add(text);
         
     JLabel n=new JLabel("Room no");
     n.setBounds(15,60,100,40);
     n.setForeground(Color.BLACK);
     n.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n);

     JLabel n1=new JLabel("Availibility");
     n1.setBounds(115,60,100,40);
     n1.setForeground(Color.BLACK);
     n1.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n1);

     JLabel n2=new JLabel("Status");
     n2.setBounds(215,60,100,40);
     n2.setForeground(Color.BLACK);
     n2.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n2);

     JLabel n3=new JLabel("Price");
     n3.setBounds(315,60,100,40);
     n3.setForeground(Color.BLACK);
     n3.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n3);

     JLabel n4=new JLabel("Bed Type");
     n4.setBounds(415,60,100,40);
     n4.setForeground(Color.BLACK);
     n4.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n4);
     
      table = new JTable();
      //JScrollPane scrollPane = new JScrollPane(table);
      //scrollPane.setBounds(15,40,500,400);
      table.setBounds(15,95,500,390);
      table.setForeground(Color.BLACK);
      table.setBackground(null);
      table.setFont(new Font("BOLD",Font.BOLD,14));
      b_img.add(table);

      try 
      {
        connect c = new connect();
        ResultSet result = c.s.executeQuery("select * from room");
        table.setModel(DbUtils.resultSetToTableModel(result));
      } catch (Exception e) {
        e.printStackTrace();
      }

      back = new JButton("Back");
      back.setForeground(Color.BLACK);
      back.setBackground(Color.red);
      back.setBounds(200,500,120,40);
      back.setFont(new Font("bold",Font.PLAIN,20));
      back.addActionListener(this);
      b_img.add(back);

        setBounds(300,100,1050,600);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) 
    {
       //SwingUtilities.invokeLater(()-> new Rooms());
       new Rooms();
    }
}
