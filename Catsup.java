import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.File;

//Esta es la interfaz de Catsup, desde aquí se puede agregar esta salsa

public class Catsup extends JFrame implements ActionListener{
  private JLabel label1;
  private JButton buton1,buton2;
  private JTextArea txta1;
  private JComboBox cbox1;
  private static int counter=0; //el total de las porciones que se han agregado
  public static int resto=0; //la salsa que queda en mostrador después de agregar una porción
  
  public Catsup(){

    setLayout(null);

    label1=new JLabel("Catsup");
    label1.setBounds(40,20,100,30);
    add(label1);
    ShowVotes finalvotes=new ShowVotes();
    
    txta1=new JTextArea("Ingredients: water,tomatoes,vinegar,artificial colorants. \n"+
			"Spicy:0 \n"+
			"Votes:"+finalvotes.cscore + "/10");
    txta1.setBounds(40,60,300,100);
    add(txta1);

    //arriba se muestran los ingredientes de la salsa, la calificación que le dan los usuarios
    // y el nivel de picante
   
    cbox1=new JComboBox(); //Opciones de porción para el usuario
    cbox1.setBounds(150,190,100,30);
      cbox1.addItem("15");
      cbox1.addItem("20");
      cbox1.addItem("25");
    add(cbox1);
    
    buton1=new JButton("add"); //Para agregar la porción
    buton1.setBounds(160,240,80,30);
    buton1.addActionListener(this);
    add(buton1);
 
    buton2=new JButton("back"); //regresa a interfaz anterior
    buton2.setBounds(30,280,70,30);
    buton2.addActionListener(this);
    add(buton2);			//Diseño de los componentes

    File archivo=null;		   //se almacenan los restantes de cada salsa
    FileReader fr=null;
    BufferedReader br=null;
    String valorinicial=""; 	//aqui guardaremos la cantidad inicial de salsa 
    archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\catsupconsume.txt");
	try{
	   fr=new FileReader(archivo);
	   br=new BufferedReader(fr);
	   valorinicial=br.readLine();

	  } 
          catch(Exception e){
	   e.printStackTrace();
	  } //leemos el dato de la salsa que queda
	resto=Integer.valueOf(valorinicial);
	//System.out.println("Justo ahora hay:"+resto);
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==buton2){ //regresa a la interfaz de cliente 
      this.setVisible(false);
      Customer newCustomer=new Customer();
      newCustomer.setBounds(0,0,300,300);
      newCustomer.setVisible(true);
      newCustomer.setLocationRelativeTo(null);
    }
    if(e.getSource()==buton1){ 

      String portion=cbox1.getSelectedItem().toString(); //leemos la porcion agregada
      String salsa="Catsup";
      int addedportion=Integer.parseInt(portion);

	if(resto<15 || resto<addedportion){
		    Salidanohay newnoexit=new Salidanohay();
    		   newnoexit.setBounds(100,200,200,100);
    		   newnoexit.setVisible(true);
    		   newnoexit.setResizable(false);
	}
	else{
	this.catsupcounter(addedportion);

      Salida newExit=new Salida(portion,salsa); //Le avisamos al usuario que ha agregado la sasla
      newExit.setBounds(100,200,240,100);
      newExit.setVisible(true);
      newExit.setResizable(false);
	//////AHORA GUARDAREMOS EL DATO NUEVO DEL RESTO
	File archivo=null;
	FileReader fr=null;
	fr=null;
	    	try{
	     	 BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\catsupconsume.txt"));
	      	 bw.write("");
	      	 bw.write(Integer.toString(resto));
              	 bw.close();   
	    } 
            catch(Exception b){
	      b.printStackTrace();
	    }	
	}
    }
  }

  public void catsupcounter(int addedportion){
    counter = counter + addedportion;  //Ahora leemos un archivo externo donde 
    resto=resto-addedportion; //es la cantidad de salsa que queda en mostrador
	System.out.println("Se han usado "+counter+" grs de catsup, quedan "+resto);
  }
  public static void main(String args[]){
    Catsup trycat=new Catsup();
    trycat.setBounds(0,0,400,400);
    trycat.setVisible(true);
    trycat.setLocationRelativeTo(null);
  }
}