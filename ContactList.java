//This file shall utilize the FileManager class in an a strong agregation type relationship 
//Sunch that we can read information from a a specific contact file 

public class ContactList extends FileManager
{
	private FileManager contactList = new FileManager(String path) //to be fleshed out better 
	private ArrayList <Contact> ContactList = new ArrayList<Contact>();
	private String[] allInfo ;
    
	
    public ContactFileManager(String filename)
	//to revisit and revise post tutorial 
	//file name would be same as path here
	  {
		try 
		{	
			FileReader fr = new FileReader("contactlist.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String eachLine = "";
			
			
			while ((eachLine = br.readLine()) != null)
			{
				//slit the line into tokens
					allInfo = eachLine.split("\");

					//convert initial string split
					String contactInfo = allInfo[0]; //needs to be string, string, gender, long
					String contactAddress = allInfo[1];
					String contactPhones = allInfo[2];//needs to be CHAR and LONG
					String contactEmails = allInfo[3];
				}
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
