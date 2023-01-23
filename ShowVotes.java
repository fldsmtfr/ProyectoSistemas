import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.io.File;

public class ShowVotes extends JFrame implements ActionListener{
   private JLabel titlel; 
   private JTextArea ta1;
   private JButton backb;
   public String ctimes, cscore, mtimes,mscore, mutimes,muscore;

   public ShowVotes(){
     setLayout(null);

     titlel=new JLabel("Los votos son:");
     titlel.setBounds(60,5,150,30);
     add(titlel);

     this.getVotes();

     ta1=new JTextArea("Catsup: votos: "+ctimes+ " puntos: " +cscore+ "\n"
			+"Mayo: votos: "+mtimes+ " puntos: " +mscore+ "\n"
			+"Mostaza: votos: "+mutimes+ "puntos: "+muscore);
     ta1.setBounds(10,30,200,200);
     add(ta1);
     
     
     backb=new JButton("Back");
     backb.setBounds(80,240,100,30);
     backb.addActionListener(this);
     add(backb);
   }
  public void getVotes(){ //Aquí recuperamos los votos de cada una de las salsas, para ello debemos
  			  //leer cada uno de los archivos.
	String lineaux="";
	String [] datos={"","",""};
		File archivo=null;
		FileReader fr=null;
		BufferedReader br=null;

		archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\catsupvotes.txt");
		try{
	   	fr=new FileReader(archivo);
	   	br=new BufferedReader(fr);
	   	lineaux=br.readLine();   
	  	} 
          	catch(Exception e){
	    	e.printStackTrace();
	  	}

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
		ctimes=datos[1]; 
		cscore=datos[2];

		archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\mayovotes.txt");
		try{
	   	fr=new FileReader(archivo);
	   	br=new BufferedReader(fr);
	   	lineaux=br.readLine();   
	  	} 
          	catch(Exception e){
	    	e.printStackTrace();
	  	}

  		auxiliar="";
		lineaux2="";
		j=0;

		for(int i=0; i<lineaux.length();i++){
			auxiliar=lineaux.substring(i,i+1);
			lineaux2=lineaux2+auxiliar;
			if(auxiliar.equals(" ")){
				datos[j]=lineaux2;
				j++;
				lineaux2="";
			}
		}
		mtimes=datos[1]; 
		mscore=datos[2];

		archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\mustardvotes.txt");
		try{
	   	fr=new FileReader(archivo);
	   	br=new BufferedReader(fr);
	   	lineaux=br.readLine();   
	  	} 
          	catch(Exception e){
	    	e.printStackTrace();
	  	}

  		auxiliar="";
		lineaux2="";
		j=0;
		for(int i=0; i<lineaux.length();i++){
			auxiliar=lineaux.substring(i,i+1);
			lineaux2=lineaux2+auxiliar;
			if(auxiliar.equals(" ")){
				datos[j]=lineaux2;
				j++;
				lineaux2="";
			}
		}
		mutimes=datos[1]; 
		muscore=datos[2];
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==backb){
	this.setVisible(false);
       Admin newadmin=new Admin();
       newadmin.setBounds(0,0,200,330);
       newadmin.setVisible(true);
       newadmin.setLocationRelativeTo(null);
    }
  }
  public static void main(String args[]){
    ShowVotes newShowVotes=new ShowVotes(); 
    newShowVotes.setBounds(0,0,240,350);
    newShowVotes.setVisible(true);
    newShowVotes.setLocationRelativeTo(null);
    newShowVotes.setResizable(false);
  }
}