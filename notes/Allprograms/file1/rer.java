package file1;
                         

import java.io.FileWriter;
import java.io.IOException;
 
/**
 * This program demonstrates how to write characters to a text file.
 * @author www.codejava.net
 *
 */
public class rer {
 
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("C:\\Documents and Settings\\mips\\Desktop\\newfile.txt", true);
            writer.write("This is a example to write a file");
            writer.write("\r\n");   // write new line
            writer.write("Have a great day !");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}