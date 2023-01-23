 import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

///Interfaz de usuario, 

public class Customer extends JFrame implements ActionListener{
  private JLabel l1;
  private JButton b1,b2,b3,vb,cb;
  
  public Customer(){ 
    setLayout(null);
    l1=new JLabel("Escoga una salsa"); //Etiqueta 
    l1.setBounds(10,20,100,30);
    add(l1);

    b1=new JButton("Catsup");     ///Botones para cada una de las salsas
    b1.setBounds(40,70,150,30);   ///
    b1.addActionListener(this);
    add(b1);
  
    b2=new JButton("Mayo");
    b2.setBounds(40,110,150,30);
    b2.addActionListener(this);
    add(b2);

    b3=new JButton("Mustard");
    b3.setBounds(40,150,150,30);
    b3.addActionListener(this);
    add(b3);

    cb=new JButton("Back");
    cb.setBounds(20,190,70,30);
    cb.addActionListener(this);
    add(cb);

    vb=new JButton("Vote!");
    vb.setBounds(110,190,70,30);
    vb.addActionListener(this);
    add(vb);
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==b1){
      this.setVisible(false);
      Catsup trycat=new Catsup();
      trycat.setBounds(0,0,400,400);
      trycat.setVisible(true);
      trycat.setLocationRelativeTo(null);
    }
    if(e.getSource()==b2){  //Abre interfaz de mayonesa
      this.setVisible(false);
      Mayo trycat=new Mayo();
      trycat.setBounds(0,0,400,400);
      trycat.setVisible(true);
      trycat.setLocationRelativeTo(null);
    }

    if(e.getSource()==b3){ //Abre intefaz de mostaza
      this.setVisible(false);
      Mustard trycat=new Mustard();
      trycat.setBounds(0,0,400,400);
      trycat.setVisible(true);
      trycat.setLocationRelativeTo(null);
    }

    if(e.getSource()==cb){ //Regresa a interfaz principal
      this.setVisible(false);
      Welcome try1=new Welcome();
      try1.setBounds(0,0,300,250);
      try1.setLocationRelativeTo(null);
      try1.setVisible(true);
      try1.setResizable(false);
    }
    if(e.getSource()==vb){  //Abre interfaz de votos
     this.setVisible(false);
      Vote v1=new Vote();
      v1.setBounds(0,0,300,300);
      v1.setVisible(true);
      v1.setLocationRelativeTo(null);
    }
  }
  public static void main(String args[]){
    Customer tryc=new Customer();
    tryc.setBounds(0,0,300,300);
    tryc.setVisible(true);
    tryc.setLocationRelativeTo(null);
  }

}
