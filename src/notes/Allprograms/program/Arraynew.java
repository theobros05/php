package program;
	
import java.io.*;
import  java.util.Scanner;

class Arraynew {
public static void main(String a[]){

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of an Array");

    int num = sc.nextInt();

    System.out.println("Enter the Element "+num+" of an Array");

    int n []= new int[num];

    for (int i = 0; i < n.length; i++)
    {

        System.out.println("Please enter number");

        n[i] = sc.nextInt();

    }
        System.out.print("Enter the postion you want to insert:");

            
       int x = sc.nextInt();

       for (int i = 0; i < n.length; i++) 

       {

           if(n[i] == n[x])
           {
        	   
        	   
           }
           
           }
       
       

}}