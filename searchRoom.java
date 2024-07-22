import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;


public class searchRoom extends JFrame implements ActionListener
{
    JTable table;
    JButton submit,back;
    JComboBox type,stat,cl;
    //JCheckBox stat;
    searchRoom()
    {
      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("searchroom_bg.jpg"));
      Image i5 = i4.getImage().getScaledInstance(1050, 700, Image.SCALE_DEFAULT); 
      ImageIcon i6 = new ImageIcon(i5);
      JLabel b_img =new JLabel(i6);
      b_img.setBounds(0,0,1050,700);//image position and attribute..
      add(b_img);
//Heading....
     JLabel text = new JLabel("Search Rooms");
     text.setBounds(290,-10,300, 80);
     text.setFont(new Font("BOLD",Font.BOLD,30));
     text.setForeground(Color.BLACK);
     b_img.add(text);

//Search filters...
     //bed type level..
     JLabel b_type = new JLabel("Bed Type");
     b_type.setBounds(40,95,80,40);
     b_type.setForeground(Color.BLACK);
     b_type.setFont(new Font("Tahoma",Font.BOLD,16));
     b_img.add(b_type);
     //bed type combobox..
     String list[]={"None","Single Bed","Double Bed"};
     type=new JComboBox<>(list);
     type.setBounds(123,100,110,28);
     type.setForeground(Color.BLACK);
     type.setFont(new Font("Tahoma",Font.PLAIN,16));
     b_img.add(type);
     
     //room status...     
     JLabel b_stat= new JLabel("Availibility Type");
     b_stat.setBounds(250,95,150,40);
     b_stat.setForeground(Color.BLACK);
     b_stat.setFont(new Font("Tahoma",Font.BOLD,16));
     b_img.add(b_stat);
     //room status checkbox..
     String l[]={"None","Available","Occupied"};
     stat=new JComboBox<>(l);
     stat.setBounds(388,100,110,28);
     stat.setForeground(Color.BLACK);
     stat.setFont(new Font("Tahoma",Font.PLAIN,16));
     b_img.add(stat);

     JLabel clean= new JLabel("Room Status");
     clean.setBounds(518,95,150,40);
     clean.setForeground(Color.BLACK);
     clean.setFont(new Font("Tahoma",Font.BOLD,16));
     b_img.add(clean);
     //room status checkbox..
     String l2[]={"None","Cleaned","Dirty"};
     cl=new JComboBox<>(l2);
     cl.setBounds(628,100,110,28);
     cl.setForeground(Color.BLACK);
     cl.setFont(new Font("Tahoma",Font.PLAIN,16));
     b_img.add(cl);



     JLabel n=new JLabel("Room no");
     n.setBounds(40,160,100,40);
     n.setForeground(Color.BLACK);
     n.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n);

     JLabel n1=new JLabel("Availibility");
     n1.setBounds(180,160,100,40);
     n1.setForeground(Color.BLACK);
     n1.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n1);

     JLabel n2=new JLabel("Status");
     n2.setBounds(320,160,100,40);
     n2.setForeground(Color.BLACK);
     n2.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n2);

     JLabel n3=new JLabel("Price");
     n3.setBounds(460,160,100,40);
     n3.setForeground(Color.BLACK);
     n3.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n3);

     JLabel n4=new JLabel("Bed Type");
     n4.setBounds(600,160,100,40);
     n4.setForeground(Color.BLACK);
     n4.setFont(new Font("Tahoma",Font.BOLD,15));
     b_img.add(n4);
     
      table = new JTable();
      //JScrollPane scrollPane = new JScrollPane(table);
      //scrollPane.setBounds(15,40,500,400);
      table.setBounds(40,195,700,300);
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

      submit = new JButton("Submit");
      submit.setForeground(Color.BLACK);
      submit.setBackground(Color.green);
      submit.setBounds(260,530,120,40);
      submit.setFont(new Font("bold",Font.PLAIN,20));
      submit.addActionListener(this);
      b_img.add(submit);


      back = new JButton("Back");
      back.setForeground(Color.BLACK);
      back.setBackground(Color.red);
      back.setBounds(410,530,120,40);
      back.setFont(new Font("bold",Font.PLAIN,20));
      back.addActionListener(this);
      b_img.add(back);

        setBounds(300,100,800,650);
        setLayout(null);
        setVisible(true);
}

public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
        
       String Avl=(String)stat.getSelectedItem();
       String Type=(String)type.getSelectedItem();
       String cl_st=(String)cl.getSelectedItem();
          
            try {
                connect c = new connect();

                if(Avl=="None" && Type=="None" && cl_st=="None")
                {
                String q="select * from room";
                ResultSet rs1=c.s.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(rs1));
                }
                else if(Type=="None")
                {
                    String q2="select * from room where  availability ='"+Avl+"' and clean_status ='"+cl_st+"'";
                    ResultSet rs2=c.s.executeQuery(q2);
                    table.setModel(DbUtils.resultSetToTableModel(rs2));
                }
                else if(Avl=="None")
                {
                    String q3="select * from room where  bed_type ='"+Type+"' and clean_status ='"+cl_st+"'";
                    ResultSet rs3=c.s.executeQuery(q3);
                    table.setModel(DbUtils.resultSetToTableModel(rs3));
                }
                else if(cl_st=="None")
                {
                    String q4="select * from room where availability ='"+Avl+"' and  bed_type ='"+Type+"'";
                    ResultSet rs4=c.s.executeQuery(q4);
                    table.setModel(DbUtils.resultSetToTableModel(rs4));
                }
                else if(cl_st=="None" && Type=="None")//error
                {
                    String q5="select * from room where availability ='"+Avl+"'";
                    ResultSet rs5=c.s.executeQuery(q5);
                    table.setModel(DbUtils.resultSetToTableModel(rs5));
                }
                else if(cl_st=="None" && Avl=="None" )//error
                {
                    String q6="select * from room where bed_type ='"+Type+"'";
                    ResultSet rs6=c.s.executeQuery(q6);
                    table.setModel(DbUtils.resultSetToTableModel(rs6));
                }
                else if(Type=="None" && Avl=="None")//error
                {
                    String q7="select * from room where clean_status ='"+cl_st+"'";
                    ResultSet rs7=c.s.executeQuery(q7);
                    table.setModel(DbUtils.resultSetToTableModel(rs7));
                }
                else
                {
                String quarry = "select * from room where availability ='"+ Avl+"' and bed_type ='"+Type+"' and clean_status ='"+cl_st+"'";
                ResultSet rs = c.s.executeQuery(quarry);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back)
        {
        setVisible(false);
        new Reception();
        }
    }

    public static void main(String[] args) 
    {
       SwingUtilities.invokeLater(()-> new searchRoom());
      // new searchRoom();
    }
}
