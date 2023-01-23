import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Automata{
public static String linea="5 2/oct/2022 15/dic/2023 ";
public static String [] datos={"","",""}; 
 
 public Automata(){ 
 String simboloaux="",simboloaux2="";
 int j=0;
   for(int i=0; i<linea.length();i++){
    simboloaux=linea.substring(i,i+1);
    simboloaux2=simboloaux2+simboloaux;
	if(simboloaux.equals(" ")){
	  datos[j]=simboloaux2;
	  simboloaux2="";
 	  j++;
	}
	
   }
 System.out.println("HELLO");
 System.out.println(datos[0]);
 System.out.println(datos[1]);
 System.out.println(datos[2]);
 }
 
 public static void main(String args[]){
   Automata newautomata=new Automata();
 }
}