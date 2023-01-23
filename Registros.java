import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Registros extends JFrame implements ActionListener{
  private JLabel title;
  private JButton catsup,mayo,mustard,backb;
  public static int op;
  public  static String linea;
  
  public Registros(){
    setLayout(null);

    title=new JLabel("Registros de consumo");
    title.setBounds(40,20,150,30);
    add(title);
   
    catsup=new JButton("Catsup");
    catsup.setBounds(40,50,100,30);
    catsup.addActionListener(this);
    add(catsup);

    mayo=new JButton("Mayo");
    mayo.setBounds(40,100,100,30);
    mayo.addActionListener(this);
    add(mayo);

    mustard=new JButton("Mostaza");
    mustard.setBounds(40,150,100,30);
    mustard.addActionListener(this);
    add(mustard);

    backb=new JButton("Back");
    backb.setBounds(100,200,80,30);
    backb.addActionListener(this);
    add(backb);
  }
  public void readRegis(int op){
    File archivo=null;
    FileReader fr=null;
    BufferedReader br=null;
    archivo=new File("C:\\Users\\HP\\Documents\\septimo\\SISTEMAS\\Proyectoeval\\registrosc.txt");
    int aux=op;
    String lineaux=" ";  
	try{
	   fr=new FileReader(archivo);
	   br=new BufferedReader(fr);
	     while(aux>0){
	       lineaux=br.readLine();
		aux--;
	      }
	  } 
          catch(Exception e){
	    e.printStackTrace();
	  }
	linea=lineaux;
  }

  public void actionPerformed(ActionEvent e){
    if(e.getSource()==catsup){ 
      op=1; 
      readRegis(op);
      RegistroOption tryro=new RegistroOption(1);
      tryro.setBounds(300,300,350,200);
      tryro.setVisible(true);
      tryro.setResizable(false);
    }
    if(e.getSource()==mayo){
      op=2;
      readRegis(op);
      RegistroOption tryro=new RegistroOption(2);
      tryro.setBounds(300,300,350,200);
      tryro.setVisible(true);
      tryro.setResizable(false);
    }
    if(e.getSource()==mustard){
      op=3;
      readRegis(op);
      RegistroOption tryro=new RegistroOption(3);
      tryro.setBounds(300,300,350,200);
      tryro.setVisible(true);
      tryro.setResizable(false);
    }
    if(e.getSource()==backb){
      this.setVisible(false);
      Admin trya=new Admin();
      trya.setBounds(0,0,200,330);
      trya.setVisible(true);
      trya.setLocationRelativeTo(null);
    }
  }

  public static void main(String args[]){
    Registros tryr=new Registros();
    tryr.setBounds(0,0,200,330);
    tryr.setVisible(true);
    tryr.setLocationRelativeTo(null);
    tryr.setResizable(false);
  }
}