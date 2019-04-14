import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile_BufferedInputStream_Read 
{
  //example of Buffer reader stream 
  public static void main(String [] pArgs) throws FileNotFoundException, IOException {
    String fileName = "C:\\Users\\lenovo\\Documents\\GitHub\\addressbook\\test.txt";
    File file = new File(fileName);
    FileInputStream fileInputStream = new FileInputStream(file);
    
    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
      int singleCharInt;
      char singleChar;
      
      while((singleCharInt = bufferedInputStream.read()) != -1) {
        singleChar = (char) singleCharInt;
        System.out.print(singleChar);
      }
    }
  }
}