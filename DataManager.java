package contact;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.*;
import java.util.ArrayList;


/**
* This class allows for the management of files (reading from, writing to, creating file).
* @author Jheanel Brown and Esther E
* @version 2.0
*/
public class DataManager
{
	private final String ABSOLUTEPATH = "datamanager\\Session\\";
  	private File fileForUser = null;
  	private AddressBook activeSession;


//TODO: Rewrite  constructor to not take file/ create a method to add a file to a path.
  	/**
  	* This allows for the creation of a file.
  	* @param nameOfFile allows for a file to be created based on the data passed in.
  	*/
	public void createFile(String nameOfFile)
	{
		File pathToFile = null;
	    try
		{
		    pathToFile = new File(ABSOLUTEPATH);
		    String pathForUser = "";

		    if(doesPathExist(pathToFile))
			{
		       	pathForUser = createUserFileExt(nameOfFile);

		       	if(doesUserFileExist(new File(pathForUser)))
		       	{    
		       		this.fileForUser = addFileForUser(pathForUser);
		       	}
				else
				{
		        	this.fileForUser = createNewFileForUser(pathForUser);
		       	}	
	    	}
			else
			{
		      pathToFile = createPath(ABSOLUTEPATH);
		      pathForUser = createUserFileExt(nameOfFile);

		        if(pathToFile != null)
				{
			        if(doesUserFileExist(new File(pathForUser)))
					{
			          this.fileForUser = addFileForUser(pathForUser);
			        }
					else
					{
		          		this.fileForUser = createNewFileForUser(pathForUser);
		        	}
		      	}
		    }
		}
		catch (FileNotFoundException noFile)
		{
	    	System.out.println("No File exists.");
	    	noFile.printStackTrace();
	    }
		catch(IOException e)
		{
		    System.out.println("ERROR!");
		    e.printStackTrace();
	  	}
	}


	/**
	* This method is used by the contact.DataManager constructor to check if a particular file path exists.
	* @param obj Represents a file object that will be used to evaluate the if a path exists
	* @return True if file path exists and false otherwise.
	**/
	private boolean doesPathExist(File obj) throws IOException{

      return obj.exists();

    }

    /**
    * Allows for the creation of a file path 
    * @param path Represents the path where a file will be added.
    * @return Adds a file to the path specified.
    */
    private File createPath(String path)
	{
      File fpath = new File (path);

      if(fpath.mkdirs())
      {
        return fpath;
      }
      else
      {
        System.out.println("Unable to create directory");
      }
      return null;
    }

    /**
    * Checks if for the presence of a file in a specified path
    * @param obj represents an object representation of a file 
    * @return true if the object exists in the path specified, false if not.
    **/
    private boolean doesUserFileExist(File obj)throws IOException{

      return obj.exists();

    }

    /**
    * Allows for the addition of the File to the path
    * @param userPath allows for the literal file to be added to the path specified
    * @return establishes the file in the path.
	*/
    private File addFileForUser(String userPath){

      return new File(userPath);

    }

    /**
    *
    * @param uFilepath takes in the name of the file path
    * @return File  creates a file
    **/
    private File createNewFileForUser(String uFilepath) throws IOException{

      File newUserFP = new File(uFilepath);

      if (newUserFP.createNewFile())
      {
        return newUserFP;
      }
      else
      {
        System.out.println("failed to create new file");

      }

      return null;

    }

    /**
    * This method allows for the name of the file to be created with the .txt estension.
    * @param username the parameter used to create the txt file with a given name.
    * @return The formatted string to be used as file name.
    **/
    private String createUserFileExt(String username){

      return ABSOLUTEPATH.concat(username).concat(".txt");

    }

	/**
	* This allows for a User credentials to be verified by checking the User Credentials database for matching data.
	* @param username Captures the username of the User trying to log into the contact.AddressBook system
	* @param password Captures the password of the User trying to log into the contact.AddressBook system
	**/
	public boolean Authenticate(String username, String password)
	{
		try
		{
			FileReader fr = new FileReader("C:\\Users\\lenovo\\Desktop\\contact\\datamanager\\Session\\UserCredentials.txt");
			BufferedReader br = new BufferedReader(fr);
			String oneLine = "";
			while ((oneLine = br.readLine()) != null)
			{
				//slit the line into tokens
				String[] eachLine = oneLine.split(";");

				//convert where necessary
				String userN = eachLine[0];
				String passW = eachLine[1];

				if(userN.equals(username) && passW.equals(password))
				{
					return true;
				}
			}
			return false;
		}
		catch(IOException error)
		{
			System.out.println("An error has occured.");
			return false;
		}
	}

	/**
	* When called allows for a file to be written to the default file path
	* @param data captures information to be written to a file
	*
	**/
	public void writeToFile(String data, String where)
	{
		FileWriter fr = null;
		BufferedWriter br = null;
		File pathToFile = new File(where);
		try
		{
			fr = new FileWriter(where, true);
			br = new BufferedWriter(fr);


			br.write("\n"+ data);
			
			br.close();
			fr.close();
		}
		catch(FileNotFoundException fnfErr)
		{
			System.out.println("There is no file to write to.");
			fnfErr.printStackTrace();
		}
		catch(IOException error)
		{
			System.out.println("ERROR!");
			error.printStackTrace();
		}

		/*final{
			try
			{
				br.close();
				fr.close();
			}
			catch(IOException writerError)
			{
				writerError.printStackTrace();
			}
		}*/
	}

	/**
	* When called allows for a file to be written to the default file path
	* @param data captures information to be written to a file
	*
	**/
	public void writeToFile(String data)
	{
		FileWriter fr = null;
		BufferedWriter br = null;
		File pathToFile = new File(data);
		try
		{
			fr = new FileWriter(fileForUser, true);
			br = new BufferedWriter(fr);

			//br.newLine();
			//br.newLine();
			br.write(data);
			
			br.close();
			fr.close();
		}
		catch(FileNotFoundException fnfErr)
		{
			System.out.println("There is no file to write to.");
			fnfErr.printStackTrace();
		}
		catch(IOException error)
		{
			System.out.println("ERROR!");
			error.printStackTrace();
		}

	}

	/**
	* Method is being used to read a contact file to capture information about all contacts in a given User's Addressbook
	* @param filename Used to find a given contact's addressbook file
	* @return Will generate a list of contacts based on the data stored in the contact.AddressBook.
	**/
	public ArrayList readContactFile(String filename)
	{
		try
		{
			String fileName = createUserFileExt(filename);
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String eachLine = "";


			while ((eachLine = br.readLine()) != null)
			{
				//slit the line into tokens
				String[] allInfo = eachLine.split("%");

				//convert initial string split
				String contactAlias = allInfo[0];
				String contactInfo = allInfo[1]; //needs to be string, string, gender, long
				String contactAddress = allInfo[2];
				String contactPhones = allInfo[3];//needs to be CHAR and LONG
				String contactEmails = allInfo[4];

				//converting derived strings into more useful form

				String[] contactData = contactInfo.split(",");
				String firstN = contactData[0]; //needs to be string, string, gender, long
				String lastN = contactData[1];
				String uppercaseGender = contactData[2];
				Gender gender = Gender.valueOf(uppercaseGender);
				long dateOB = Long.parseLong(contactData[3]);

				//________________________
				String[] phoneData = contactPhones.split(";");
				//String[] eachPhone = phoneData.split(",");
				char pType = phoneData[0].charAt(0);
				long pNumber = Long.parseLong(phoneData[1]);
				//________________________
				String[] emails = contactEmails.split(",");
				//________________________
				//Addressbook
				Contact eachContact = new Contact(firstN, lastN, gender,dateOB);
				this.activeSession = new AddressBook();
				eachContact.setAddress(contactAddress);
				eachContact.setAlias(contactAlias);


				for(String each: phoneData)
				{

					//String[] singlePhone = phoneData.split(",");
					String phTypecapture = phoneData[0];
					Character phType = phTypecapture.charAt(0);

					long phNumber = Long.parseLong(phoneData[1]);
					eachContact.addPhone(phType, phNumber);
				}

				for(String mail: emails)
				{
					eachContact.addEmail(mail);
				}

				activeSession.getContactList().add(eachContact);

				fr.close();
				br.close();
			}
			return activeSession.getContactList();
		}

		catch(NullPointerException nul)
		{
			return new ArrayList<Contact>();
		}
		catch(IOException error)
		{
			System.out.println("An error has occured.");
			error.printStackTrace();
		}

		catch(NumberFormatException hasTobeNumError)
		{
			System.out.println("NOTE: the input has to be a number.");
		}

		return null;
	}

	public void deleteFile()
	{
  		fileForUser.deleteOnExit();
	}
}
