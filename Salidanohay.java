import java.awt.event.*;
import javax.swing.*;	
import javax.swing.event.*;

public class Salidanohay extends JFrame{
   private JLabel l1;
 public Salidanohay(){
    setLayout(null);

    l1=new JLabel("No queda mas salsa unu ");
    l1.setBounds(20,20,250,50);
    add(l1);
  }
  public static void main(String args[]){
    Salidanohay newnoexit=new Salidanohay();
    newnoexit.setBounds(100,200,200,100);
    newnoexit.setVisible(true);
    newnoexit.setResizable(false);
  }
}
