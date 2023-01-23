import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.File;

public class Mustard extends JFrame implements ActionListener{
  private JLabel l1;
  private JButton b1,b2;
  private JTextArea ta1;
  private JComboBox cb1;
  private static int counter=0;
  public static int resto=0;

  public Mustard(){

    setLayout(null);
    l1=new JLabel("Mustard");
    l1.setBounds(40,20,100,30);
    add(l1);

    ShowVotes finalvotes=new ShowVotes();        

    ta1=new JTextArea("Ingredients: water,mustard seeds,vinegar,\n artificial colorants. \n"+
			"Spicy:0 \n"+
			"Votes:"+finalvotes.muscore+"/10");
    ta1.setBounds(40,60,300,100);
    add(ta1); //muestra datos de la mostaza
   
    cb1=new JComboBox(); //muestra opciones de porción
    cb1.setBounds(150,190,100,30);
      cb1.addItem("15");
      cb1.addItem("20");
      cb1.addItem("25");
    add(cb1);
    
    b1=new JButton("add"); //boton para agregar la porcion indicada
    b1.setBounds(160,240,80,30);
    b1.addActionListener(this);
    add(b1);
 
    b2=new JButton("back");
    b2.setBounds(30,280,70,30);
    b2.addActionListener(this);
    add(b2);

    File archivo=null;		   //se almacenan los restantes de cada salsa
    FileReader fr=null;
    BufferedReader br=null;
    String valorinicial=""; 	//aqui guardaremos la cantidad inicial de salsa 
    archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\mustardconsume.txt");
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
    if(e.getSource()==b2){
      this.setVisible(false);
      Customer tryc=new Customer();
      tryc.setBounds(0,0,300,300);
      tryc.setVisible(true);
      tryc.setLocationRelativeTo(null);
    }
    if(e.getSource()==b1){

      String portion=cb1.getSelectedItem().toString();
      String salsa="Mostaza";
      int addedportion=Integer.parseInt(portion);

      if(resto<15 || resto<addedportion){
		   Salidanohay newnoexit=new Salidanohay();
    		   newnoexit.setBounds(100,200,200,100);
    		   newnoexit.setVisible(true);
    		   newnoexit.setResizable(false);
      }else{
     
      this.mustardcounter(addedportion);
      Salida trysal=new Salida(portion,salsa);
      trysal.setBounds(100,200,240,100);
      trysal.setVisible(true);
      trysal.setResizable(false);
      
	//////AHORA GUARDAREMOS EL DATO NUEVO DEL RESTO
	File archivo=null;
	FileReader fr=null;
	fr=null;
	    	try{
	     	 BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\mustardconsume.txt"));
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

  public void mustardcounter(int addedportion){
    counter=counter+addedportion;
    counter = counter + addedportion;  //Ahora leemos un archivo externo donde 
    resto=resto-addedportion; //es la cantidad de salsa que queda en mostrador
	System.out.println("Se han usado "+counter+" grs de catsup, quedan "+resto);

}

  public static void main(String args[]){
    Mustard trycat=new Mustard();
    trycat.setBounds(0,0,400,400);
    trycat.setVisible(true);
    trycat.setLocationRelativeTo(null);
  }
}