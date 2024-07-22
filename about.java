import javax.swing.*;
import java.awt.*;

public class about extends JFrame {
    public about() {
    JLabel l1,l2,l3,l4,l5,lbl,proj,desc;

        setTitle("About Us");
        setBounds(300,200,1000,500);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        lbl=new JLabel("Hotel Management System");
        lbl.setBounds(220,20,1000,50);
        lbl.setForeground(Color.BLACK);
        lbl.setFont(new Font("Tahoma",Font.BOLD,35));
        add(lbl);

        proj=new JLabel("About Our Team");
        proj.setBounds(340,80,1000,40);
        proj.setForeground(Color.BLACK);
        proj.setFont(new Font("Tahoma",Font.BOLD,25));
        add(proj);


        l1=new JLabel("Rijwanool Karim    Roll No-UG/02/BTCSEAIML/2022/004    Reg No-AU/2022/0007168    Dept-CSE (AIML)");
        l1.setBounds(40,140,1000,40);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l1);

        l2=new JLabel("Arijit Dey    Roll No-UG/02/BTCSEAIML/2022/001    Reg No-AU/2022/0006880    Dept-CSE (AIML)");
        l2.setBounds(40,180,1000,40);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l2);

        l3=new JLabel("Asmita Ghosh    Roll No -UG/02/BTCESCSF/2022/002    Reg No-AU/2022/0007156    Dept-CSE (CSF)");
        l3.setBounds(40,220,1000,40);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l3);

        l4=new JLabel("Sayantan Saha    Roll-UG/02/BTCSE/2022/003    Reg No-AU/2023/0010168    Dept-CSE");
        l4.setBounds(40,260,1000,40);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l4);

        l5=new JLabel("Rahul R Jawalkar   Roll-UG/02/BTCSEAIML/2022/007    Reg No-AU/2022/0007180    Dept-CSE (AIML)");
        l5.setBounds(40,300,1000,40);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l5);

        desc = new JLabel("Description: It is a class project of Hotel Management system,our team uses Java Swing concept to build this project.");
        desc.setBounds(30, 340, 1000, 40); 
        desc.setForeground(Color.BLACK);
        desc.setFont(new Font("Tahoma", Font.BOLD, 15));
        desc.setVerticalAlignment(SwingConstants.BOTTOM);
        add(desc);

    



        setVisible(true);
    }

    public static void main(String[] args) {
        new about();
    }
}
