import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon  i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        back=new JButton("Back");
        back.setBounds(355,420,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn c=new Conn();
        int balance=0;
        try{
          ResultSet rs=c.s.executeQuery("select * from atm where pin='"+pinnumber+"'");
          
          while(rs.next()){
            if(rs.getString("type").equals("Deposit")){
                balance+=Integer.parseInt(rs.getString("amount"));
            }else if(rs.getString("type").equals("Withdraw")){
                balance-=Integer.parseInt(rs.getString("amount"));
            }
        }
    }catch(Exception e){
        System.out.println(e);
    }
       JLabel text=new JLabel("Your current Account Balance is Rs "+balance);
       text.setForeground(Color.WHITE);
       text.setBounds(170,200,400,30);
       image.add(text);



        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
