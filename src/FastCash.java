import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JButton f1,f2,f5,exit,f6,f4,f3;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
            
        ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon  i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRWAL AMOUNT");
        text.setBounds(210,300,900,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

         f1=new JButton("Rs 100");
        f1.setBounds(170,415,150,30);
        f1.addActionListener(this);
        image.add(f1);

         f2=new JButton("Rs 500");
        f2.setBounds(355,415,150,30);
        f2.addActionListener(this);
        image.add(f2);

         f3=new JButton("Rs 1000");
        f3.setBounds(170,450,150,30);
        f3.addActionListener(this);
        image.add(f3);

          f4=new JButton("Rs 2000");
        f4.setBounds(355,450,150,30);
        f4.addActionListener(this);
        image.add(f4);

         f5=new JButton("Rs 5000");
        f5.setBounds(170,485,150,30);
        f5.addActionListener(this);
        image.add(f5);

         f6=new JButton("Rs 10000");
        f6.setBounds(355,485,150,30);
        f6.addActionListener(this);
        image.add(f6);

         exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);

    
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==exit){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }else {
        String amount=((JButton)ae.getSource()).getText().substring(3);//taking name of Rs...
        Conn c=new Conn();
        try{
          ResultSet rs=c.s.executeQuery("select * from atm where pin='"+pinnumber+"'");
          int balance=0;
          while(rs.next()){
            if(rs.getString("type").equals("Deposit")){
                balance+=Integer.parseInt(rs.getString("amount"));
            }else if(rs.getString("type").equals("Withdraw")){
                balance-=Integer.parseInt(rs.getString("amount"));
            }
          }
          if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
            JOptionPane.showMessageDialog(null,"Insufficient Balance");
            return;
          }
          Date date=new Date();
          String query="insert into atm values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Rs "+amount+"Debited Succesfully");
          setVisible(false);
          new Transaction(pinnumber).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}

