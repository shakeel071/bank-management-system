import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;

public class PinChange extends JFrame  implements ActionListener {
    String pinnumber;
    JPasswordField Rpin,repin;
    JButton change,back;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon  i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon  i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,200,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        JLabel pintext=new JLabel("New PIN:");
        pintext.setBounds(165,240,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);

        Rpin=new JPasswordField();
        Rpin.setFont(new Font("Raleway",Font.BOLD,16));
        Rpin.setBounds(330,240,180,25);
        image.add(Rpin);

        JLabel repintext=new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165,280,180,25);
        repintext.setForeground(Color.WHITE);
       repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);

        repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setBounds(330,280,180,25);
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(355,385,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
        back.setBounds(355,420,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
      try{
      String npin=Rpin.getText();
      String rpin=repin.getText();
      if(!npin .equals(rpin)){
        JOptionPane.showMessageDialog(null,"Entered PIN does not match");
        return;
      }
      if(npin.equals("")){
        JOptionPane.showMessageDialog(null,"Please enter new PIN");
        return;
      }
      if(rpin.equals("")){
        JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
        return;
      }
      Conn conn=new Conn();
      String query1="update atm set pin='"+rpin+"' where pin='"+pinnumber+"'";
    String query2="update login set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
    String query3="update signupthree set pin='"+rpin+"' where pin='"+pinnumber+"'";

    conn.s.executeUpdate(query1);
    conn.s.executeUpdate(query2);
    conn.s.executeUpdate(query3);

   JOptionPane.showMessageDialog(null,"PIN changed succesfully");
    setVisible(false);
   new Transaction(rpin).setVisible(true);
      }catch(Exception e){
        System.out.println(e);
      }
    }else{
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
}
    public static void main(String[] args) {
        new  PinChange("").setVisible(true);
    }
}
