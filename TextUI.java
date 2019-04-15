import java.util.*
iport java.util.Scanner;

public class TextUI
{
	private String username;
	private String password;
	private ArrayList<String> addressBookusers = new ArrayList<String>();
	private String[] eachLine;

	public TextUI()
	{

	}
		
		



	public void loginUI()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                        Welcome!                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                        Please input your Username then Password                                     |");
		System.out.println("|                             NOTE: Both are case sensitive!                                          |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("_____________________________________________________________________________________________________");
		
		int numtries=3;
		while(numtries!=0) 
		{
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Username:");
			userN = sc.nextLine();
			System.out.println("Password:");
			passW = sc.nextLine();
		
			Authentication try = new Authentication(userN, passW);
		
			if(try.check() == 0)
			{
				numtries = 0;
				//Launch addressbook app
				
			} else
			{
				System.out.println("Username or password is incorrect, you have two more tries");
				numtries--1;
			}
	
		}
		System.out.println("You have exceeded your number of tries, Goodbye");
		System.exit(0);

	}

	public void mainMenu()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                        Welcome!                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|   A- Create New Contact                                                                             |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|   B- Search                                                                                         |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|   C- View all Contacts                                                                              |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|   D- Delete a Contact                                                                               |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|   E - Save AddressBook to File                                                                      |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|   F - EXIT                                                                                          |");
		System.out.println("|                                                                                                     |");
		System.out.println("_____________________________________________________________________________________________________");
	}


}
