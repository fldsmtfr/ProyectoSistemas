import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Automata{
 public static String linea="5 2/oct/2022 15/dic/2023 ";
 public static int [][] transmatrix={{1,-1,-1,2},
				      {1,-1,-1,2},
				      {3,-1,4,-1},
				      {3,-1,4,-1},
				      {-1,5,-1,-1},
				      {-1,5,6,-1},
				      {7,-1,-1,-1},
	  			      {7,-1,-1,3}};
public static String [] datos={"","",""}; 
 
 public Automata(){ 
 int estado=0, symbol=0;
 //symbol=0 para digito,1 para letra, 2 para / y 3 para  espacio
 String simboloaux="",simboloaux2="";
 int j=0;
   for(int i=0; i<linea.length();i++){
    simboloaux=linea.substring(i,i+1);
    simboloaux2=simboloaux2+simboloaux;
	//if(Character.isDigit(linea.charAt(i))){symbol=0;}
	//if(Character.isLetter(linea.charAt(i))){symbol=1;}
        //if(simboloaux.equals("/")){symbol=2;}
	if(simboloaux.equals(" ")){
	  symbol=3;
	  datos[j]=simboloaux2;
	  simboloaux2="";
 	  j++;
	}
	//estado=transmatrix[estado][symbol];
    //System.out.println(simboloaux+" "+"simbolo= "+ symbol+" estado= "+estado);
   }
 if(estado!=-1){System.out.println("Linea valida");
 }else{System.out.println("Linea no valida");}

 System.out.println("HELLO");
 System.out.println(datos[0]);
 System.out.println(datos[1]);
 System.out.println(datos[2]);
 }
 
 public static void main(String args[]){
   Automata newautomata=new Automata();
 }
}