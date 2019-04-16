package datamanager;
import java.io.*;// file class
import java.nio.file.Files;// contain methods to move files
import java.nio.file.*;// contain methods to move files
import java.io.IOException;// error handler
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.ArrayList;

public class DataManagement{
  private final String DEFAULTDIRECTORY = "DataManager\\Files\\";
  private File userfile = null;


  //------ PRIVATE CLASSESS -------
    private boolean checkDirectory(File obj) throws IOException{

      return obj.exists();

    }

    private File createDirectory(String directoryPath){
      File directory = new File (directoryPath);

      if(directory.mkdirs()){
        System.out.println("Directory created");
        return directory;
      }
      else
      {
        System.out.println("Unable to create directory");
      }
      return null;
    }


    private boolean checkUserFile(File obj)throws IOException{

      return obj.exists();

    }

    private File createUserFile(String userfilepath){

      return new File(userfilepath);

    }

    private File createNewUserFile(String userfilepath) throws IOException{

      File user = new File(userfilepath); //create object of file
      //create the actual file
      if (user.createNewFile()){
        System.out.println("New file created");
        return user;
      }
      else
      {
        System.out.println("failed to create new file");

      }

      return null;

    }

    private String createUserFilePath(String username){

      return DEFAULTDIRECTORY.concat(username).concat(".txt");

    }

//------ CONSTRUCTORS ------


  public DataManagement(String username){
    File directory = null;
    try{
    directory = new File(DEFAULTDIRECTORY);
    String userfilepath = "";

    if(checkDirectory(directory)){
      //file directory exists
      System.out.println("Directory exists");
        userfilepath = createUserFilePath(username);

        if(checkUserFile(new File(userfilepath))){
            //user file exists
            System.out.println("file exists");
          this.userfile = createUserFile(userfilepath);
            // add more
        }else{
            //user file don't exists

          this.userfile = createNewUserFile(userfilepath);

        }

    }else{
      //file directory don't exists
      System.out.println("Directory doesn't exists");

      directory = createDirectory(DEFAULTDIRECTORY);
      userfilepath = createUserFilePath(username);

      if(directory != null){

        if(checkUserFile(new File(userfilepath))){
          //user file exists
          System.out.println("file exists");
          this.userfile = createUserFile(userfilepath);
          // add more
        }else{
          //user file don't exists

          this.userfile = createNewUserFile(userfilepath);

        }

      }

    }



  } catch (FileNotFoundException error){
    System.out.println("An error occured.");
    error.printStackTrace();

  }catch(IOException error){
    System.out.println("An error occured.");
    error.printStackTrace();
  }

  }


  // ------ CODE TO WRITE TO FILE -------

  public void writeToFile(String text){
    if(userfile.canWrite()){
      FileWriter file = null;
      try{

        file = new FileWriter(userfile);
        text = "\n" + text;
        file.write(text);

       } catch (FileNotFoundException error){
         System.out.println("An error occured.");
         error.printStackTrace();

       }catch(IOException error){
         System.out.println("An error occured.");
         error.printStackTrace();

       }finally{

         try{
         file.close();

        }catch(IOException error){

          error.printStackTrace();
        }
      }

    }

    else System.out.println("Unable to write to file.");


  }



// ------ CODE TO READ FROM FILE -------


  public void readFromFile(){

    //Scanner file = null;
    FileReader file = null;
    BufferedReader br = null;

    try{
      // file = new Scanner(obj);
      // while (file.hasNextLine()){
      //   String Data = file.nextLine();
      //   data.add(Data);
      //   System.out.println(Data);
      // }

        file = new FileReader(userfile);
         br = new BufferedReader(file);

        while (br.readLine() != null){
          String Data = br.readLine();
          //data.add(Data);
          System.out.println(Data);


        }
      }
    catch(IOException error){
       System.out.println("An error occured.");
       error.printStackTrace();
      }
    finally{
       try{
       //file.close();
          br.close();
          file.close();
          }
      catch(Exception error){
          error.printStackTrace();
          }

          }

  }

//------- CODE TO APPEND FILE -------


public void appendToFile(String text){
  FileWriter fr = null;
  //BufferedWriter br = null;
  //PrintWriter pr = null;
  try{
    fr = new FileWriter(userfile, true);
    //br = new BufferedWriter(fr);
    //pr = new PrintWriter(br);

    //pr.println();
    //pr.println(text);
    fr.write(";");
    fr.write(text);


   } catch (FileNotFoundException error){
     System.out.println("An error occured.");
     error.printStackTrace();

   }catch(IOException error){
     System.out.println("An error occured.");
     error.printStackTrace();
   }finally{

     try{

     //pr.close();
     //br.close();
     fr.close();
   }catch(IOException error){
     error.printStackTrace();
   }
   }

}


public void addToFile(String text){
  FileWriter fr = null;
  BufferedWriter br = null;
  //PrintWriter pr = null;
  try{
    fr = new FileWriter(userfile, true);
    br = new BufferedWriter(fr);
    //pr = new PrintWriter(br);

    //pr.println();
    //pr.println(text);
    //text += "\n" + text;
    br.newLine();
    br.newLine();
    br.write(text);

   } catch (FileNotFoundException error){
     System.out.println("An error occured.");
     error.printStackTrace();

   }catch(IOException error){
     System.out.println("An error occured.");
     error.printStackTrace();
   }finally{

     try{

     //pr.close();
     br.close();
     fr.close();
   }catch(IOException error){
     error.printStackTrace();
   }
   }

}


//------- CODE FOR FUNCTIONALITY -------

public void deleteFile(){
  userfile.deleteOnExit();
}


}
