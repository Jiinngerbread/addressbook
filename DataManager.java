import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;
import java.util.*;

/**
* This class allows for the interaction of the Addressbook and User classes with their respective files. 
* @author Jheanel Brown and Esther E
* @version 1.0
*/
public class DataManager
{
	private ArrayList <Contact> ContactList = new ArrayList<Contact>();
	private String[] allInfo ;
	
	//private ArrayList <User> userList; 

	//Check if there exists a folder in directory
	// specific Users folder ie Addressbook user && specific user folder ie James 

	// We want to create the create the Users folder
	// We want to create a folder for a user in the Users folder 


	// We want to check if a file exists

	// We want to create a file in a specific destination folder 
	// we want to write to the file 

	//we want to edit the file /manipulate the file 

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
