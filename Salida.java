import java.awt.event.*;
import javax.swing.*;	
import javax.swing.event.*;

public class Salida extends JFrame{
   private JLabel l1;
  public Salida(String portion, String salsa){
    setLayout(null);

    l1=new JLabel("Usted agrego "+portion+"ml de "+salsa);
    l1.setBounds(20,20,250,30);
    add(l1);
  }
  public static void main(String args[]){
    Salida trysal=new Salida(" "," ");
    trysal.setBounds(100,200,200,100);
    trysal.setVisible(true);
    trysal.setResizable(false);
  }
}