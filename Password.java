import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.File;

//Esta seccion del programa verifica la contraseña y permite el acceso a la interfaz de admin
//si la contraseña ingresada es correcta

public class Password extends JFrame implements ActionListener{
  private JButton buton1, backbuton;
  private JLabel label1; 		//Elementos para la nueva pestaña,etiqueta y boton
  public static String password;	//Esta es la contraseña correcta que se lee desde un archivo
  private JPasswordField psf1;		//La contraseña ingresada por el usuario
    
  public Password(){

    setLayout(null);

    //Aquí leemos la contraseña correcta desde un archivo

    File archivo=null;
    FileReader fr=null;
    BufferedReader br=null;
    archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\passwordreg.txt");
    String lineaux=" ";  
	try{
	   fr=new FileReader(archivo);
	   br=new BufferedReader(fr);
	   lineaux=br.readLine();   
	  } 
          catch(Exception e){
	    e.printStackTrace();
	  }
	password=lineaux;
		
    //Componentes de la pestaña, boton y etiqueta

    label1=new JLabel("Introduzca contraseña");
    label1.setBounds(50,50,100,30);
    add(label1);
 
    psf1=new JPasswordField();
    psf1.setBounds(50,90,150,30);
    add(psf1);

    buton1=new JButton("Go");
    buton1.setBounds(50,130,60,30);
    buton1.addActionListener(this);
    add(buton1);

    backbuton=new JButton("Back");
    backbuton.setBounds(80,170,80,30);
    backbuton.addActionListener(this);
    add(backbuton); 
  }

  //Definimos las acciones de los botones

  public void actionPerformed(ActionEvent e){
    if(e.getSource()==buton1){

      String chain=String.valueOf(psf1.getPassword()); //comparamos la contraseña ingresada con
						       //que leimos del archivo
      if(this.password.compareTo(chain)==0){	       //Si es correcta dejamos que pase
        this.setVisible(false);
        Admin newAdmin=new Admin();
        newAdmin.setBounds(0,0,200,330);
        newAdmin.setVisible(true);
        newAdmin.setLocationRelativeTo(null);
      }
      else{
        JOptionPane.showMessageDialog(null,"Contrasena incorrecta");  //si no es correcta
      }
    }

    if(e.getSource()==backbuton){
      this.setVisible(false);
      Welcome newWelcome=new Welcome();
      newWelcome.setBounds(0,0,300,250);
      newWelcome.setLocationRelativeTo(null);
      newWelcome.setVisible(true);
      newWelcome.setResizable(false);
    }
  }

  public static void main(String args[]){
    Password newPassword=new Password();
    newPassword.setBounds(0,0,250,300);
    newPassword.setLocationRelativeTo(null);
    newPassword.setVisible(true);
  }


}