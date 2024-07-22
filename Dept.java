import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Dept extends JFrame implements ActionListener 
{
    JTable table;
    JButton back;
    Dept()
    {
      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("dept_bg.jpg"));
      Image i5 = i4.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT); 
      ImageIcon i6 = new ImageIcon(i5);
      JLabel b_img =new JLabel(i6);
      b_img.setBounds(0,0,600,500);//image position and attribute..
      add(b_img);

     JLabel text = new JLabel("List of Department");
     text.setBounds(170,-10,300, 80);
     text.setFont(new Font("BOLD",Font.BOLD,30));
     text.setForeground(Color.BLACK);
     b_img.add(text);
         
     JLabel n=new JLabel("Department");
     n.setBounds(120,75,150,40);
     n.setForeground(Color.BLACK);
     n.setFont(new Font("Tahoma",Font.BOLD,18));
     b_img.add(n);

     JLabel n2=new JLabel("Budget");
     n2.setBounds(390,75,150,40);
     n2.setForeground(Color.BLACK);
     n2.setFont(new Font("Tahoma",Font.BOLD,18));
     b_img.add(n2);

     
      table = new JTable();
      //JScrollPane scrollPane = new JScrollPane(table);
      //scrollPane.setBounds(15,40,500,400);
      table.setBounds(40,110,500,250);
      table.setForeground(Color.BLACK);
      table.setFont(new Font("BOLD",Font.PLAIN,17));
      b_img.add(table);

      try 
      {
        connect c = new connect();
        ResultSet result = c.s.executeQuery("select * from dept");
        table.setModel(DbUtils.resultSetToTableModel(result));
      } catch (Exception e) {
        e.printStackTrace();
      }

      back = new JButton("Exit");
      back.setBounds(230,390,120,40);
      back.setBackground(Color.RED);
      back.setFont(new Font("Bold",Font.BOLD,20));
      back.setForeground(Color.BLACK);
      back.addActionListener(this);
      b_img.add(back);

        setBounds(300,100,600,500);
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
       new Dept();
    }
}
