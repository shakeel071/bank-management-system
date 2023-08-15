import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdrawl,back;
    String  pinnumber;
       Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
      setLayout(null);
       
        ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon  i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to  Withdraw");
        text.setBounds(170,270,400,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,320,320,20);
        image.add(amount);

        withdrawl=new JButton("Withdraw");
        withdrawl.setBounds(355,435,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back=new JButton("Back");
        back.setBounds(355,470,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


       }
       public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==withdrawl){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else{
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
                  if(ae.getSource()!=back && balance<Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                  }
                  String query="insert into atm values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
                  c.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null,"Rs "+number+"Debited Succesfully");
                  setVisible(false);
                  new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
                 
          }
        }else if(ae.getSource()==back){
         setVisible(false);
         new Transaction(pinnumber).setVisible(true);
          }
       }
    public static void main(String[] args) {
        new Deposit("");
    }
} 