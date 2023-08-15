import javax.swing.*;
import  java.sql.*;
import java.awt.Color;
import   java.awt.event.*;
public class MiniStatement  extends JFrame{
    String  pinnumber;

    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");

        setLayout(null);
        JLabel mini=new JLabel();
        add(mini);

        JLabel bank=new  JLabel("Federal Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from login where pinnumber='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }                           
        }catch(Exception e){
            System.out.println(e);
        }  
        
        try{
            Conn conn=new Conn();
            int bal=0;
              ResultSet rs=conn.s.executeQuery("select * from atm where pin='"+pinnumber+"'");
              while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
             
                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else if(rs.getString("type").equals("Withdraw")){
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current Balance is Rs " +bal);
        }catch(Exception  e){
            System.out.println(e);
        }
   
        mini.setBounds(20,140,400,200);    
           
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
