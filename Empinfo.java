import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Empinfo extends JFrame implements ActionListener 
{
    JTable table;
    JButton back;
    Empinfo()
    {
      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("dept_bg.jpg"));
      Image i5 = i4.getImage().getScaledInstance(1100, 500, Image.SCALE_DEFAULT); 
      ImageIcon i6 = new ImageIcon(i5);
      JLabel b_img =new JLabel(i6);
      b_img.setBounds(0,0,1100,500);//image position and attribute..
      add(b_img);

     JLabel text = new JLabel("All Employee Details");
     text.setBounds(380,-10,300, 80);
     text.setFont(new Font("BOLD",Font.BOLD,30));
     text.setForeground(Color.BLACK);
     b_img.add(text);
         
     JLabel n=new JLabel("Name");
     n.setBounds(30,75,150,40);
     n.setForeground(Color.BLACK);
     n.setFont(new Font("Tahoma",Font.BOLD,17));
     b_img.add(n);

     JLabel n2=new JLabel("Age");
     n2.setBounds(145,75,150,40);
     n2.setForeground(Color.BLACK);
     n2.setFont(new Font("Tahoma",Font.BOLD,17));
     b_img.add(n2);

     JLabel n3=new JLabel("Gender");
     n3.setBounds(258,75,150,40);
     n3.setForeground(Color.BLACK);
     n3.setFont(new Font("Tahoma",Font.BOLD,17));
     b_img.add(n3);

     JLabel n4=new JLabel("Job");
     n4.setBounds(374,75,150,40);
     n4.setForeground(Color.BLACK);
     n4.setFont(new Font("Tahoma",Font.BOLD,17));
     b_img.add(n4);

     JLabel n5=new JLabel("Salary");
     n5.setBounds(484,75,150,40);
     n5.setForeground(Color.BLACK);
     n5.setFont(new Font("Tahoma",Font.BOLD,17));
     b_img.add(n5);

     JLabel n6=new JLabel("Phone");
     n6.setBounds(595,75,150,40);
     n6.setForeground(Color.BLACK);
     n6.setFont(new Font("Tahoma",Font.BOLD,17));
     b_img.add(n6);

     JLabel n7=new JLabel("Email");
     n7.setBounds(710,75,150,40);
     n7.setForeground(Color.BLACK);
     n7.setFont(new Font("Tahoma",Font.BOLD,17));
     b_img.add(n7);
 
     JLabel n8=new JLabel("Adress");
     n8.setBounds(825,75,150,40);
     n8.setForeground(Color.BLACK);
     n8.setFont(new Font("Tahoma",Font.BOLD,17));
     b_img.add(n8);

     JLabel n9=new JLabel("Adhar No");
     n9.setBounds(940,75,150,40);
     n9.setForeground(Color.BLACK);
     n9.setFont(new Font("Tahoma",Font.BOLD,17));
     b_img.add(n9);

     
      table = new JTable();
      //JScrollPane scrollPane = new JScrollPane(table);
      //scrollPane.setBounds(15,40,500,400);
      table.setBounds(30,110,1020,250);
      table.setForeground(Color.BLACK);
      table.setFont(new Font("BOLD",Font.PLAIN,15));
      b_img.add(table);

      try 
      {
        connect c = new connect();
        ResultSet result = c.s.executeQuery("select * from emp_details");
        table.setModel(DbUtils.resultSetToTableModel(result));
      } catch (Exception e) {
        e.printStackTrace();
      }

      back = new JButton("Exit");
      back.setBounds(470,390,120,40);
      back.setBackground(Color.RED);
      back.setFont(new Font("Bold",Font.BOLD,20));
      back.setForeground(Color.BLACK);
      back.addActionListener(this);
      b_img.add(back);

        setBounds(300,100,1100,500);
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
       new Empinfo();
    }
}

