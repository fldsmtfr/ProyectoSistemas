import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.io.File;

public class PasswordChange extends JFrame implements ActionListener{
	private JLabel label1;
	private JTextField txta1;
	private JButton changeb,backb; //componentes de la pestaña
	private String newPassword; //la nueva contraseña que guardará el usuario

    public PasswordChange(){
      setLayout(null);
      
      label1=new JLabel("Introduzca nueva contrasena: ");
      label1.setBounds(10,10,280,30);
      add(label1);
   
      txta1=new JTextField();
      txta1.setBounds(10,60,150,30);
      add(txta1);
      
      changeb=new JButton("Cambiar");
      changeb.setBounds(30,90,100,30);
      changeb.addActionListener(this);
      add(changeb);

      backb=new JButton("Back");
      backb.setBounds(100,150,70,30);
      backb.addActionListener(this);
      add(backb);			//Diseño de los componentes
    }

  public void actionPerformed(ActionEvent e){ //Acciones de cada boton

    if(e.getSource()==backb){ //Para regresar a la interfaz anterior
      this.setVisible(false);
      Admin newAdmin=new Admin();
      newAdmin.setBounds(0,0,200,330);
      newAdmin.setVisible(true);
      newAdmin.setLocationRelativeTo(null);
    }

   if(e.getSource()==changeb){
      String auxiliar=txta1.getText(); //recuperamos el texto ingresado y lo almacenamos en una
					//variable auxiliar
        if(auxiliar.length()>0){	//verificamos que la nueva contraseña no sea vacia

	    Password newPasswordint=new Password();
	    newPasswordint.password=auxiliar;	//cambiamos la contraseña anterior por la
						//recien ingresada
	    File archivo=null;			//y la sobreescribimos en el archivo
    	    FileReader fr=null;
	    try{
	      BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\passwordreg.txt"));
	      bw.write("");
	      bw.write(auxiliar);
              bw.close();   
	    } 
            catch(Exception b){
	      b.printStackTrace();
	    }

	  JOptionPane.showMessageDialog(null,"Cotrasena cambiada"); //Se notifica el cambio
	  this.setVisible(false);				    //regresamos a la interfaz
	  Admin newAdmin=new Admin();
          newAdmin.setBounds(0,0,200,330);
          newAdmin.setVisible(true);
          newAdmin.setLocationRelativeTo(null);

	}else{
	  JOptionPane.showMessageDialog(null,"Itroduzca cotasena"); //si la conitraseña es vacia
	}							    //pedimos una nueva
    }
  }
  public static void main(String args[]){
    PasswordChange newPsChange=new PasswordChange();
    newPsChange.setBounds(0,0,200,250);
    newPsChange.setVisible(true);
    newPsChange.setLocationRelativeTo(null);
  }

}