import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class SignupThree extends JFrame implements ActionListener{  
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);

    JLabel l1=new JLabel("page 3:Account Details");
     l1.setFont(new Font("Raleway",Font.BOLD,22));
     l1.setBounds(280,40,400,40);
     add(l1);

     JLabel card=new JLabel("page 3:Account type");
    card.setFont(new Font("Raleway",Font.BOLD,22));
     card.setBounds(100,110,300,30);
     add(card);
     
     r1=new JRadioButton("Saving Account");
     r1.setFont(new Font("Raleway",Font.BOLD,16));
     r1.setBackground(Color.WHITE);
     r1.setBounds(100,150,170,20);
     add(r1);
  
     r2=new JRadioButton("Fixed Deposit Account");
     r2.setFont(new Font("Raleway",Font.BOLD,16));
     r2.setBackground(Color.WHITE);
     r2.setBounds(350,150,250,20);
     add(r2);

     r3=new JRadioButton("Current Account");
     r3.setFont(new Font("Raleway",Font.BOLD,16));
     r3.setBackground(Color.WHITE);
     r3.setBounds(100,190,170,20);
     add(r3);

     r4=new JRadioButton("Recurring Deposit Account");
     r4.setFont(new Font("Raleway",Font.BOLD,16));
     r4.setBackground(Color.WHITE);
     r4.setBounds(350,190,250,20);
     add(r4);

     ButtonGroup groupaccount=new ButtonGroup();
     groupaccount.add(r1);
     groupaccount.add(r2);
     groupaccount.add(r3);
     groupaccount.add(r4);

     JLabel cards=new JLabel("Card Number");
    cards.setFont(new Font("Raleway",Font.BOLD,22));
     cards.setBounds(100,260,200,30);
     add(cards);

     JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
    number.setFont(new Font("Raleway",Font.BOLD,22));
     number.setBounds(330,260,300,30);
     add(number);

     JLabel carddetail=new JLabel("Your 16 Digit Card Number");
    carddetail.setFont(new Font("Raleway",Font.BOLD,12));
     carddetail.setBounds(100,290,300,20);
     add(carddetail);

     JLabel pin=new JLabel("PIN:");
    pin.setFont(new Font("Raleway",Font.BOLD,22));
     pin.setBounds(100,330,200,30);
     add(pin);

     JLabel pnumber=new JLabel("XXXX");
    pnumber.setFont(new Font("Raleway",Font.BOLD,22));
     pnumber.setBounds(330,330,300,30);
     add(pnumber);

     JLabel pindetail=new JLabel("Your 4 Digit Password");
    pindetail.setFont(new Font("Raleway",Font.BOLD,12));
     pindetail.setBounds(100,370,300,20);
     add(pindetail);

     JLabel services=new JLabel("Services Required:");
    services.setFont(new Font("Raleway",Font.BOLD,22));
     services.setBounds(100,420,400,30);
     add(services);

     c1=new JCheckBox("ATM CARD");
     c1.setBackground(Color.WHITE);
     c1.setFont(new Font("Raleway",Font.BOLD,16));
     c1.setBounds(100,470,200,30);
     add(c1);

     c2=new JCheckBox("Internet Banking");
     c2.setBackground(Color.WHITE);
     c2.setFont(new Font("Raleway",Font.BOLD,16));
     c2.setBounds(350,470,200,30);
     add(c2);

     c3=new JCheckBox("Mobile Banking");
     c3.setBackground(Color.WHITE);
     c3.setFont(new Font("Raleway",Font.BOLD,16));
     c3.setBounds(100,520,200,30);
     add(c3);

     c4=new JCheckBox("Email & SMS Alerts");
     c4.setBackground(Color.WHITE);
     c4.setFont(new Font("Raleway",Font.BOLD,16));
     c4.setBounds(350,520,200,30);
     add(c4);

     c5=new JCheckBox("Cheque Book");
     c5.setBackground(Color.WHITE);
     c5.setFont(new Font("Raleway",Font.BOLD,16));
     c5.setBounds(100,570,200,30);
     add(c5);

     c6=new JCheckBox("E-statement");
     c6.setBackground(Color.WHITE);
     c6.setFont(new Font("Raleway",Font.BOLD,16));
     c6.setBounds(350,570,200,30);
     add(c6);

     c7=new JCheckBox("I here by declare that the above entered details are correct to the best of my knowledge");
     c7.setBackground(Color.WHITE);
     c7.setFont(new Font("Raleway",Font.BOLD,12));
     c7.setBounds(100,620,600,30);
     add(c7);

     submit=new JButton("Submit");
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.setFont(new Font("Raleway",Font.BOLD,14));
     submit.setBounds(250,660,100,30);
     submit.addActionListener(this);
     add(submit);

     cancel=new JButton("Cancel");
     cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE);
     cancel.setFont(new Font("Raleway",Font.BOLD,14));
     cancel.setBounds(420,660,100,30);
     cancel.addActionListener(this);
     add(cancel);
 
     getContentPane().setBackground(Color.WHITE);




    setSize(850,820);
    setLocation(350,0);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
     setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType="";
    
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current account";
            }else if(r4.isSelected()){
                accountType="Reccuring Deposit Account";
            }
            Random random=new Random();
            String cardnumber=""+ Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        String pinnumber=""+ Math.abs((random.nextLong() % 9000L)  +1000L);
         
        String facility="";
        if(c1.isSelected()){
            facility=facility + "ATM Card";
        }else if(c2.isSelected()){
            facility=facility + "Internet Banking";
        }else if(c3.isSelected()){
            facility=facility + "Mobile Banking";
        }else if(c4.isSelected()){
            facility=facility + "Email & SMS Alert";
        }else if(c5.isSelected()){
            facility=facility + "Cheque Book";
        }else if(c6.isSelected()){
            facility=facility + "E-statement";
        }

     try{
        if(accountType.isEmpty()){
            JOptionPane.showMessageDialog(null,"Account Type is Required");
            
        }else{
            Conn conn=new  Conn();
            String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
            String query2="insert into login  values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);

             JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\n Pin: "+pinnumber);
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            }

     }catch(Exception e){
        System.out.println(e);
     }

        }else if(ae.getSource()==cancel){
           setVisible(false);
           new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new  SignupThree("");
    }
}
