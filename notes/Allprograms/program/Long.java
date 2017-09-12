package program;
import java.util.Scanner;
import java.io.*;

public class Long {
	

	     public static void main(String [ ] args) throws FileNotFoundException {
	    	 
	    	 Long f = new Long();
	    	 
	    	 
	    f.getLongestWords();
	 }

	public String getLongestWords() throws FileNotFoundException {

	    String longestWord = "";
	    String current;
	    Scanner scan = new Scanner(new File("D:\\TESTING EXERCISE\\forest.txt"));


	    while (scan.hasNext()) {
	        current = scan.next();
	        if ((current.length() > longestWord.length()) && (!current.matches(".*\\d.*"))) {
	            longestWord = current;
	        }

	    }
	    System.out.println(longestWord);
	    
	    
	    
	            return longestWord;
	        }

	}


