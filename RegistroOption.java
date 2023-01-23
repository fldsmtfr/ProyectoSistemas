import java.awt.event.*;
import javax.swing.*;
	
import javax.swing.event.*;

public class RegistroOption extends JFrame{
  
  private JLabel label1;	    
  private JTextArea txta1;	     //Elementos de la pestaña, etiqueta y area de texto
  public String lineaDatos;	     //es la linea del archivo donde se encuentran los datos de la salsa elegida
  public int option;  

  public RegistroOption(int option){
	

    String [] datos={"","",""};      //Aquí se guardan los datos: cantidad en stock, fecha de colocacion y caducidad

    Registros newOption=new Registros();
    lineaDatos=newOption.linea.substring(2,newOption.linea.length());   //Recuperamos la linea de datos de la salsa elegida
 
    String auxiliar1="",auxiliar2="";
    int j=0;			     //Estas son variables auxiliares
	

    for(int i=0; i<lineaDatos.length();i++){

      auxiliar1=lineaDatos.substring(i,i+1); //para cada caracter de la linea de datos lineaDatos, este se guarda en aux1
      auxiliar2=auxiliar2+auxiliar1;	     //vamos concatenando los caracteres
	if(auxiliar1.equals(" ")){	     //el separador es el espacio, si encontramos 1, guardamos el string
	  datos[j]=auxiliar2;		     //que llevamos como un nuevo dato
	  auxiliar2="";
 	  j++;
	}

    }
 
     switch(option){
	case 1:
		Catsup newCatsup= new Catsup();
		datos[0]=Float.toString(newCatsup.resto);
	break;

	case 2:
		Mayo newMayo= new Mayo();
		datos[0]=Float.toString(newMayo.resto);
	break;

	case 3:
		Mustard newMustard=new Mustard();
		datos[0]=Float.toString(newMustard.resto);
	break;
     }

    setLayout(null);

    label1=new JLabel("Registros de salsa");	//Diseño de la pestaña
    label1.setBounds(80,20,150,30);
    add(label1);
    
    
    
    txta1=new JTextArea("Queda en mostrador:" + datos[0]+ " ml \n"+
			"Fecha de colocacion: " + datos[1]+ "\n" +
			"Caducidad: "+datos[2]);
    txta1.setBounds(10,70,320,150);
    add(txta1);
  
    
  }


  public static void main(String args[]){
    RegistroOption newDisplay=new RegistroOption(1);
      newDisplay.setBounds(300,300,350,300);
      newDisplay.setVisible(true);
      newDisplay.setResizable(false);
  }
}