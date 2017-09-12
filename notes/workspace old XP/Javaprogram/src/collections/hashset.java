package collections;

import java.util.*;

public class hashset {
   public static void main(String [] args) {   
      System.out.println( "Collection Example!\n" ); 
      int size;
      HashSet <String>collection = new HashSet <String>();
      
      String str1 = "Yellow", str2 = "White", str3 = "Green", str4 = "Blue" ,str5="Green", str6="",str7 = "Blue",str8="";  
      Iterator iterator;
      collection.add(str1);    
      collection.add(str2);   
      collection.add(str3);   
      collection.add(str4);
      collection.add(str5);
      collection.add(str6);
      collection.add(str7);
      collection.add(str8);
      System.out.print("Collection data: ");  
      iterator = collection.iterator();     
      
      while (iterator.hasNext()){
         System.out.print(iterator.next() + " ");  
      }
      System.out.println();
      collection.remove(str2);
      System.out.println("After removing [" + str2 + "]\n");
      System.out.print("Now collection data: ");
      iterator = collection.iterator();     
      
      while (iterator.hasNext()){
         System.out.print(iterator.next() + " ");  
      }
      System.out.println();
      size = collection.size();
      System.out.println("Collection size: " + size + "\n");
   }
}