package test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
public class Stf {
public static void main(String[] args) {
BufferedWriter bufferedWriter = null;
try {
String strContent = "Objectives of defects:"+System.lineSeparator()+"Finding defects which may get created by the programmer while developing the software."+System.lineSeparator()+"To prevent defects."+System.lineSeparator()+"To gain confidence of the customer by providing them a quality product.";
File myFile = new File("d:/text1.txt");
System.out.println("Content successfully written.");
// check if file exist, otherwise create the file before writing
if (!myFile.exists()) {
myFile.createNewFile();
}
Writer writer = new FileWriter(myFile);
bufferedWriter = new BufferedWriter(writer);
bufferedWriter.write(strContent);
} catch (IOException e) {
e.printStackTrace();
} finally{
try{
                if(bufferedWriter != null) bufferedWriter.close();
            } catch(Exception ex){
                 
            }
        }
    }
}



