package datamanager;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.*;
import java.nio.file.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;



/**
* This class allows for the management of files (reading from, writing to, creating file).
* @author Jheanel Brown and Esther E
* @version 2.0
*/
public class DataManager
{
	private final String ABSOLUTEPATH = "datamanager\\Session\\";
  private File fileForUser = null;

	public DataManager(String username)
		File pathToFile = null;

    try
		{
	    pathToFile = new File(ABSOLUTEPATH);
	    String pathForUser = "";

	    if(checkDirectory(pathToFile))
			{
	      //asking if file directory exists
	      //*System.out.println("Directory exists");
	        pathForUser = createUserFilePath(username);

	        if(checkUserFile(new File(pathForUser))){
	            //user path exists
	            //*System.out.println("file exists");
	          this.fileForUser = createUserFile(pathForUser);
	            // add more
	        }
					else
					{
	            //user file don't exists
	          this.fileForUser = createNewUserFile(userfilepath);
	        }

    }
		else
		{
      //file path don't exists
      //*System.out.println("Directory doesn't exists");
      pathToFile = createDirectory(ABSOLUTEPATH);
      pathForUser = createUserFilePath(username);

      if(pathToFile != null)
			{
        if(checkUserFile(new File(pathForUser)))
				{
          //user file exists
          //*System.out.println("file exists");
          this.fileForUser = createUserFile(pathForUser);
          // add more
        }
				else
				{
          //user file don't exists
          this.fileForUser = createNewUserFile(pathForUser);
        }
      }
    }
  }
	catch (FileNotFoundException noFile)
	{
    System.out.println("No File exists.");
    error.printStackTrace();
  }
	catch(IOException e)
	{
    System.out.println("ERROR!");
    error.printStackTrace();
  }
  }

	/**
	* This allows for a User credentials to be verified by checking the file database for matching credentials
	* @param username Captures the username of the User trying to log into the AddressBook system
	* @param password Captures the password of the User trying to log into the AddressBook system
	**/
	public boolean Authenticate(String username, String password)
	{
		try
		{
			FileReader fr = new FileReader("UserCredentials.txt");
			BufferedReader br = new BufferedReader(fr);
			String oneLine = "";
			while ((oneLine = br.readLine()) != null)
			{
				//slit the line into tokens
				String[] eachLine = oneLine.split(";");

				//convert where necessary
				String userN = eachLine[0];
				String passW = eachLine[1];

				if(userN == username && passW == password)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		catch(IOException error)
		{
			System.out.println("An error has occured.");
		}
	}

	/**
	* When called allows for a file to be written to
	*
	*
	**/
	public void writeToFile(String data, String path)
	{
		File pathToFile = new File(path);

		if (pathToFile.exists() == true)
		{
			pathToFile.format
		}
		else
		{
			final Formatter makeFile;
			try
			{
				makeFile = new Formatter(pathToFile)
			}
			catch(Exception e)
			{
				System.out.println("An error has occured")
			}
		}
	}

	public ArrayList<Contacts> readFile(String username)
	{
		try
		{
			String filename = username+"_addressbook.txt"
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);

			String eachLine = "";


			while ((eachLine = br.readLine()) != null)
			{
				//slit the line into tokens
				allInfo = eachLine.split("\"");

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
				Gender gender = Gender.valueOf(contactData[2]).toUpperCase();
				long dateOB = Long.parseLong(contactData[3]);

				//________________________
				String[] phoneData = contactPhones.split(";");
				String[] eachPhone = phoneData.split(",");
				char pType = eachPhone[0].charAt(0);
				long pNumber = Long.parseLong(eachPhone[1]);
				//________________________
				String[] emails = contactEmails.split(",");
				//________________________
				Contact eachContact = new Contact(firstN, lastN, gender,dateOB);
				eachContact.setAddress(contactAddress);
				eachContact.setAlias(contactAlias);


				for(String each: phoneData)
				{

					String[] eachPhone = each.split(",");
					char pType = each[0].charAt(0);
					long pNumber = Long.parseLong(eachPhone[1]);
					eachContact.addPhone(pType, pNumber);
				}

				for(int i = 0; i< emails.length(); i++ )
				{
					eachContact.addEmail(i);
				}

				ContactList.add(eachContact);
			}
			return ContactList;
		}
		catch(IOException error)
		{
			System.out.println("An error has occured.");
		}

		catch(NumberFormatException hasTobeNumError)
		{
			System.out.println("NOTE: the input has to be a number.");
		}
	}



}
