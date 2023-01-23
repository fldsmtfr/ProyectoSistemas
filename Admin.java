import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

///Esta es la interfaz de administrador, le proporciona a este cuatro opciones:
//Ver Registros
//Ver Votos
//Camiar contraseña
//Apagar sistema

public class Admin extends JFrame implements ActionListener{
 private JButton b1,b2,b3,b4,bb; //un botón para cada opcion
 
  public Admin(){
    setLayout(null);
    
    b1=new JButton("Registros");
    b1.setBounds(50,50,100,30);
    b1.addActionListener(this);
    add(b1);

    b2=new JButton("Estadisticas");
    b2.setBounds(50,100,100,30);
    b2.addActionListener(this);
    add(b2);

    b3=new JButton("Cambio de contraseña");
    b3.setBounds(50,150,100,30);
    b3.addActionListener(this);
    add(b3);

    b4=new JButton("Apagar");
    b4.setBounds(50,200,100,30);
    b4.addActionListener(this);
    add(b4);

    bb=new JButton("Back"); //botón para regresar a la interfaz principal
    bb.setBounds(100,250,80,30);
    bb.addActionListener(this);
    add(bb);
  } 
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==b4){ //para apagar sistema
      int op=JOptionPane.showConfirmDialog(null,"Desea apagar el sistema?"," ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(op==0){System.exit(0);}
    } 
    if(e.getSource()==bb){ //para regresar a interfaz principal
      this.setVisible(false);
      Welcome try1=new Welcome();
      try1.setBounds(0,0,300,250);
      try1.setLocationRelativeTo(null);
      try1.setVisible(true);
      try1.setResizable(false);
    }
    if(e.getSource()==b1){ //para mostrar registros
      this.setVisible(false);
      Registros tryr=new Registros();
      tryr.setBounds(0,0,200,330);
      tryr.setVisible(true);
      tryr.setLocationRelativeTo(null);
      tryr.setResizable(false);
    }
   if(e.getSource()==b3){ //para cambiar contraseña
      this.setVisible(false);
      PasswordChange trypc=new PasswordChange();
      trypc.setBounds(0,0,200,330);
      trypc.setVisible(true);
      trypc.setLocationRelativeTo(null);
    }
   if(e.getSource()==b2){ //para mostrar los votos
      this.setVisible(false);
      ShowVotes trysvo=new ShowVotes(); 
      trysvo.setBounds(0,0,240,350);
      trysvo.setVisible(true);
      trysvo.setLocationRelativeTo(null);
      trysvo.setResizable(false);
    }
  }

  public static void main(String args[]){
    Admin trya=new Admin();
    trya.setBounds(0,0,200,330);
    trya.setVisible(true);
    trya.setLocationRelativeTo(null);
  }

}