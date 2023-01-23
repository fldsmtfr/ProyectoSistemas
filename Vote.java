import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.io.File;

public class Vote extends JFrame implements ActionListener{

  private JLabel label1,label2,label3;
  private JComboBox cbox1,cbox2;
  private JButton buton1,buton2;	//componentes de la pestaña, etiquetas y botones

  public static float cscore=0,mscore=0,muscore=0;
  public static float csuma=0, msuma=0, musuma=0;
  public static float ctimes,mtimes,mutimes;		//datos necesarios para calcular los votos

  public Vote(){

   setLayout(null);

   label1=new JLabel("Salsa:");
   label1.setBounds(50,50,100,30);
   add(label1);
  
   label2=new JLabel("Puntuation:");
   label2.setBounds(170,50,100,30);
   add(label2);
   
   label3=new JLabel(" ");
   label3.setBounds(50,180,100,30);
   add(label3);

    cbox1=new JComboBox();
    cbox1.setBounds(55,70,100,30);
      cbox1.addItem("Catsup");
      cbox1.addItem("Mayo");
      cbox1.addItem("Mustard");
    add(cbox1);
 
    cbox2=new JComboBox();
    cbox2.setBounds(170,70,100,30);
      for(int i=0;i<10;i++){
        cbox2.addItem(String.valueOf(i+1));
      }
    add(cbox2);
   
   buton1=new JButton("Vote");
   buton1.setBounds(110,110,100,30);
   buton1.addActionListener(this);
   add(buton1);					

   buton2=new JButton("Back");
   buton2.setBounds(50,160,80,30);
   buton2.addActionListener(this);
   add(buton2);						//Diseño de los componentes
  }

public void writeData(String linea,int option){ //Esta funcion nos permite guardar los datos de los votos en un archivo, este se actuzaliza cada vez que se vota
	File archivo=null;
	FileReader fr=null;

	switch(option){
	  case 1:
		fr=null;
	    	try{
	     	 BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\catsupvotes.txt"));
	      	 bw.write("");
	      	 bw.write(linea);
              	 bw.close();   
	    } 
            catch(Exception b){
	      b.printStackTrace();
	    }
	  break;

	  case 2:
    	    	fr=null;
	    	try{
	      	BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\mayovotes.txt"));
	      	bw.write("");
	     	bw.write(linea);
              	bw.close();   
	    	} 
            	catch(Exception b){
	      b.printStackTrace();
	    }
	  break;

	  case 3:
    	    	fr=null;
	    	try{
	      	BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\mustardvotes.txt"));
	      	bw.write("");
	      	bw.write(linea);
              	bw.close();   
	    	} 
            	catch(Exception b){
	      	b.printStackTrace();
	    	}
	  break;
	}
}

public void recoverData(int option){
	File archivo=null;
    	FileReader fr=null;
    	BufferedReader br=null;
	String lineaux=" ";  
	String [] datos={"","",""};
	switch(option){
	  case 1:
		archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\catsupvotes.txt");
		try{
	   	fr=new FileReader(archivo);
	   	br=new BufferedReader(fr);
	   	lineaux=br.readLine();   
	  	} 
          	catch(Exception e){
	    	e.printStackTrace();
	  	}
		//System.out.println("Hemos recuperado:"+lineaux);
	  break;

	  case 2:
		archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\mayovotes.txt");
		try{
	   	fr=new FileReader(archivo);
	   	br=new BufferedReader(fr);
	   	lineaux=br.readLine();   
	  	} 
          	catch(Exception e){
	    	e.printStackTrace();
	  	}
		//System.out.println("Hemos recuperado:"+lineaux);
	  break;

	  case 3:
		archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\mustardvotes.txt");
		try{
	   	fr=new FileReader(archivo);
	   	br=new BufferedReader(fr);
	   	lineaux=br.readLine();   
	  	} 
          	catch(Exception e){
	    	e.printStackTrace();
	  	}
		//System.out.println("Hemos recuperado:"+lineaux);
	  break;
	}
	//////////Ahora vayamos recuperar los datos
	System.out.println("Tenemos la linea "+lineaux);
	String auxiliar="",lineaux2="";
	int j=0;
	for(int i=0; i<lineaux.length();i++){
		auxiliar=lineaux.substring(i,i+1);
		lineaux2=lineaux2+auxiliar;
		if(auxiliar.equals(" ")){
			datos[j]=lineaux2;
			j++;
			lineaux2="";
		}
	}
	switch(option){
	  case 1:
		csuma=Float.valueOf(datos[0]);
		ctimes=Float.valueOf(datos[1]);
		cscore=Float.valueOf(datos[2]);
	  break;
	  case 2:
		msuma=Float.valueOf(datos[0]);
		mtimes=Float.valueOf(datos[1]);
		mscore=Float.valueOf(datos[2]);
	  break;
	  case 3:
		musuma=Float.valueOf(datos[0]);
		mutimes=Float.valueOf(datos[1]);
		muscore=Float.valueOf(datos[2]);
	  break;
	}
}

  public void actionPerformed(ActionEvent e){		//Definimos las acciones de cada boton

  int selectedSauce=0;
    if(e.getSource()==buton2){				//Si queremos regresar a la interfaz anterior
      this.setVisible(false);
      Customer newCustomer=new Customer();
      newCustomer.setBounds(0,0,300,300);
      newCustomer.setVisible(true);
      newCustomer.setLocationRelativeTo(null);
    }
    if(e.getSource()==buton1){				//Para puntuar una salsa
      String sauce=cbox1.getSelectedItem().toString();	//obtenemos la salsa elegida
      
	if(sauce.equals("Catsup")){selectedSauce=1;	 		//dependiendo de la salsa que se eleigio, asignamos una opcion
	   }else{if(sauce.equals("Mayo")){selectedSauce=2;		//opcion 1=catsup, opcion 2=mayonesa, opcion 3=mostaza
 	          }else{if(sauce.equals("Mustard")){selectedSauce=3;}}
	   } 
	       
      String calificacion=cbox2.getSelectedItem().toString();
      String linea="";
      switch(selectedSauce){
	case 1:
	  this.recoverData(1);
	  ctimes++;
	  csuma=csuma+Integer.parseInt(calificacion);
	  cscore=(csuma/ctimes);
	  linea=Float.toString(csuma)+" "+Float.toString(ctimes)+" "+Float.toString(cscore)+" ";
	  this.writeData(linea,1);
        break;										
	case 2:	
	  this.recoverData(2);									
	  mtimes++;
	  msuma=msuma+Integer.parseInt(calificacion);
	  mscore=(msuma/mtimes);
	  linea=Float.toString(msuma)+" "+Float.toString(mtimes)+" "+Float.toString(mscore)+" ";
	  this.writeData(linea,2);
	break;
	case 3:
	  this.recoverData(3);
	  mutimes++;
	  musuma=musuma+Integer.parseInt(calificacion);
	  muscore=(musuma/mutimes);
	  linea=Float.toString(musuma)+" "+Float.toString(mutimes)+" "+Float.toString(muscore)+" ";
	  this.writeData(linea,3);
	break;
      } 
    }
    label3.setText("Thanks uwu");	//Para verificar que se haya registrado su voto
  }

  public static void main(String args[]){
    Vote newVote=new Vote();
    newVote.setBounds(0,0,300,300);
    newVote.setVisible(true);
    newVote.setLocationRelativeTo(null);
 }
}