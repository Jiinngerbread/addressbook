import java.util.*
iport java.util.Scanner;

public class TextUI
{
	public TextUI()
	{

	}
		
	//create a main method for stepwise launch of the interface	
	public void onLaunch()
	{
		ystem.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                       AddressBook!                                                  |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                 Welcome, Lets get started.                                          |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("_____________________________________________________________________________________________________");
		
	}



	public void userLogin()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                        Please input your Username then Password                                     |");
		System.out.println("|                             NOTE: Both are case sensitive!                                          |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("_____________________________________________________________________________________________________");
		System.out.println();
		System.out.println();
		
		AddressBook.statusToLaunch();

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
		
		Scanner capture = new Scanner(System.in);
		String option = capture.nextLine().toUpperCase();

		mainMenuNavigation();
	}

	public void subMenu_A()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                 CREATE A NEW CONTACT                                                |");
		System.out.println("|                                                                                                     |");
		System.out.println("|    To create a contact you need to provide the following information:                               |");
		System.out.println("|       *  The contact's Name (firs, then lastname);                                                  |");
		System.out.println("|       *  Gender;                                                                                    |");
		System.out.println("|       *  Date of Birth in the format of yyyymmdd;                                                   |");
		System.out.println("|       *  An Alias for the contact;                                                                  |");
		System.out.println("|                                                                                                     |");
		System.out.println("|       *  An address                                                                                 |") 
		System.out.println("|             (this is written in one line with a semicolons to specify where a new line begins       |");
		System.out.println("|               no more than 5 lines are permitted);                                                  |");
		System.out.println("|                                                                                                     |");
		System.out.println("|       *  Phone numbers                                                                              |");
		System.out.println("|             (Here you will specify the type of phone: H- home, W- Work, M - Mobile,                 |");
		System.out.println("|               and 10 digit phone number);                                                           |");
		System.out.println("|                                                                                                     |");
		System.out.println("|       *  Email address                                                                              |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |") 
		System.out.println("|                                                                                                     |");
		System.out.println("|_____________________________________________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		AddressBook.add();
		mainMenu();
	}

		public void subMenu_B()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                     SEARCH FOR CONTACT                                                   |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|    1 - Search by entry Number 							2 - Search by Email                                                                                               |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |") 
		System.out.println("|                                                                                                     |");
		System.out.println("|_____________________________________________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println("Input 1 to search for a contact by entry number or 2 to search by email: ");
		int searchBy = sc.nextInt();
		switch
		{
			case 1:
				AddressBook.searchByEntry();
				//the method called will display the contact
				// subsubMenu_1() can be called to further edit a contact
			break;
			case 2: 
				AddressBook.searchByEmail();
				// subsubMenu_1() to further edit a contact
			break;
			default:
			System.out.println("Input invalid!");
			mainMenu()
		}
		mainMenu();
	}

		public void subMenu_C()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                     VIEW All CONTACT                                                   |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|    1 - Sorted by entry Number 							2 - Sorted by Name                                                                                               |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |") 
		System.out.println("|                                                                                                     |");
		System.out.println("|_____________________________________________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println("Input 1 to search for a contact by entry number or 2 to search by email: ");
		int searchBy = sc.nextInt();
		switch
		{
			case 1:
				AddressBook.sortAllByEntry();
				// subsubMenu_1() to further edit a contact
			break;
			case 2: 
				AddressBook.sortAllByName();
				// subsubMenu_1() to further edit a contact
			break;
			default:
			System.out.println("Input invalid!");
			mainMenu()
		}
		mainMenu();
	}

	public void subsubMenu_1()
	{
		System.out.println("__________________________________________________________________________________");
		System.out.println("|                                                                                |");
		System.out.println("|                                      EDIT CONTACT DATA                         |");
		System.out.println("|                                                                                |");
		System.out.println("|                                                                                |");
		System.out.println("|     A - Change Last Name                                                       |");
		System.out.println("|     B - Change Alias                                                           |");
		System.out.println("|     C - Change Address                                                         |");
		System.out.println("|     D - Add Phone Number                                                       |");
		System.out.println("|     E - Add Email Address                                                      |"); 
		System.out.println("|     F - Delete Phone Number                                                    |");
		System.out.println("|     G - Delete Email Address                                                   |");
		System.out.println("|     X - Return to Main Menu                                                    |");
		System.out.println("|                                                                                |");
		System.out.println("|________________________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		AddressBook.subsub_NavigationMenu();
		mainMenu();
	}


	public void subMenu_D()
	{
		System.out.println("_____________________________________________________________________");
		System.out.println("|                                                                   |");
		System.out.println("|                                                                   |");
		System.out.println("|                          DELETE A CONTACT                         |");
		System.out.println("|                                                                   |");
		System.out.println("|                                                                   |");
		System.out.println("|  1 - Specify Entry Number                                         |");
		System.out.println("|                                                                   |");
		System.out.println("|                                                                   |");
		System.out.println("|                                                                   |") 
		System.out.println("|  2 - Specify Email Address                                        |");
		System.out.println("|                                                                   |");
		System.out.println("|                                                                   |");
		System.out.println("|                                                                   |");
		System.out.println("|___________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		Scanner sc5 = new Scanner(System.in);
		System.out.println("Input 1 to search for a contact by entry number or 2 to search by email: ");
		int searchBy = sc5.nextInt();
		switch
		{
			case 1:
				String delByEN = sc5.nextLine();
				AddressBook.deleteContactbyEN(delByEN);
				System.out.println("Contact removed from AddressBook.");
			break;
			case 2: 
				String delByEmail = sc5.nextLine();
				AddressBook.deleteContactbyEmail(delByEmail);
				System.out.println("Contact removed from AddressBook.");
			break;
			default:
			System.out.println("Input invalid!");
			mainMenu()
		}
		mainMenu();
	}


	public void subMenu_E()
	{
		System.out.println("________________________________________________");
		System.out.println("|              SAVE TO FILE                    |");
		System.out.println("|                                              |");
		System.out.println("|                                              |");
		System.out.println("| Great!                                       |");
		System.out.println("|                                              |");
		System.out.println("| Lets update your database,                   |");
		System.out.println("|   Addressbook saves your contacts to         |");
		System.out.println("|   a text file with your username.            |");
		System.out.println("|                                              |") 
		System.out.println("|                                              |");
		System.out.println("|              . . . . . . . . .               |");
		System.out.println("|______________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		AddressBook.saveToFile();
		mainMenu();
	}


	public void subMenu_F()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                       	Goodbye!                                                  |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|_____________________________________________________________________________________________________|")

	
	}


	/*public void subMenu_()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |") 
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |") 
		System.out.println("|                                                                                                     |");
		System.out.println("|_____________________________________________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		AddressBook.add();
		mainMenu();*/
}




