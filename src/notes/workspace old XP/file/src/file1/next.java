package file1;

import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class next {
   public static void main(String[] args) {
      FileInputStream ins = null;
      FileOutputStream outs = null;
      try {
    	 
    	  FileWriter writer = new FileWriter("C:\\Documents and Settings\\mips\\Desktop\\newfile.txt", true);
    	  
    	  writer.write("This is a example to copy a file");
          writer.write("\r\n");   // write new line
          writer.write("Have a great day !");
          writer.close();
          
    	  FileWriter writer2 = new FileWriter("C:\\Documents and Settings\\mips\\Desktop\\bbc.txt", true);
    	  
    	  
         File infile =new File("C:\\Documents and Settings\\mips\\Desktop\\newfile.txt");
         File outfile =new File("C:\\Documents and Settings\\mips\\Desktop\\bbc.txt");
         ins = new FileInputStream(infile);
         outs = new FileOutputStream(outfile);
         byte[] buffer = new byte[1024];
         int length;
         while ((length = ins.read(buffer)) > 0) {
            outs.write(buffer, 0, length);
         } 
         ins.close();
         outs.close();
         System.out.println("File copied successfully!!");
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } 
   }
}