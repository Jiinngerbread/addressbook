public class ContactList extends Contact
{
  
   private ArrayList <Contact> ContactList = new ArrayList<Contact>();
   private String[] allInfo ;
    
    public ContactFileManager(String filename)
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
