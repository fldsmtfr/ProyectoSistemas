import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Welcome extends JFrame implements ActionListener{
  private JLabel l1,l2;
  private JButton b1,b2;

  public Welcome(){
    setLayout(null);
    setTitle("Bienvenido");
    getContentPane().setBackground(new Color(250,5,0));
    
    l1=new JLabel("Bienvenido");
    l1.setBounds(110,10,200,30);
    add(l1);

    l2=new JLabel("Escoga una opcion");
    l2.setBounds(100,45,200,30);
    add(l2);

    b1=new JButton("Admin");
    b1.setBounds(40,80,100,30);
    b1.addActionListener(this);
    add(b1);

    b2=new JButton("Cliente");
    b2.setBounds(160,80,100,30);
    b2.addActionListener(this);
    add(b2);
    
  }
  public void actionPerformed(ActionEvent e){

    if(e.getSource()==b2){
      this.setVisible(false);
      Customer tryc=new Customer();
      tryc.setBounds(0,0,300,330);
      tryc.setVisible(true);
      tryc.setLocationRelativeTo(null);
      tryc.setResizable(false);
    }
    if(e.getSource()==b1){
     this.setVisible(false);
     Password tryp=new Password();
     tryp.setBounds(0,0,250,300);
     tryp.setLocationRelativeTo(null);
     tryp.setVisible(true);
     tryp.setResizable(false);
    }
  }
  public static void main(String args[]){
    Welcome try1=new Welcome();
    try1.setBounds(0,0,300,250);
    try1.setLocationRelativeTo(null);
    try1.setVisible(true);
    try1.setResizable(false);
  }


}