package contact;

import java.util.Scanner;
import java.lang.*;


public class TextUI
{
	
	private  AddressBook activeUserAB;
	private DataManager userContactFile;
	private DataManager verifyContact;




	//create a main method for stepwise launch of the interface
	public void onLaunch()
	{
		System.out.println("______________________________________________________________________________________________________");
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


	public void loginTerminal()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|               Please indicate:                                                                      |");
		System.out.println("|                      1 - Create new  User                                                           |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                      2 - Login to Your AddressBook                                                  |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                            .      .        .                                        |");
		System.out.println("|_____________________________________________________________________________________________________|");
		System.out.println();
		System.out.println();

		Scanner loginR = new Scanner(System.in);
		int logOrCreate = loginR.nextInt();

		switch(logOrCreate)
		{
			case 1:
				Scanner loginNow = new Scanner(System.in);
				System.out.println("Please input your Username: ");
				String userName = loginNow.nextLine();
				System.out.println("Please input your Password: ");
				String password = loginNow.nextLine();
				String dataToStore = ( userName + ";" + password );

				DataManager user = new DataManager();
				user.createFile("UserCredentials");

				user.writeToFile(dataToStore, "C:\\Users\\lenovo\\Desktop\\contact\\datamanager\\Session\\UserCredentials.txt");

				this.userContactFile = new DataManager();
				userContactFile.createFile(userName);
				System.out.println("Awesome! An account has been created. Please login with your credentials.");
				userLogin();
			break;

			case 2: userLogin();
			break;

			default: loginTerminal();
		}
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

		int numtries=0;

		while(numtries<3)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Username:");
			String userN = sc.nextLine();
			System.out.println("Password:");
			String passW = sc.nextLine();

			this.verifyContact = new DataManager();

			if(verifyContact.Authenticate(userN, passW) == true)
			{
				this.activeUserAB = new AddressBook(userN);
				mainMenu();
				break;
			} else
			{
				numtries++;
				System.out.println("Username or password is incorrect, you have " + numtries +"/3 tries left.");
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
		System.out.println("|   D- Delete a Contact                                                                               |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|   E - Save AddressBook to File                                                                      |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|   N - See Next Menu                                                                                 |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|   F - EXIT                                                                                          |");
		System.out.println("|                                                                                                     |");
		System.out.println("|_____________________________________________________________________________________________________|");


		Scanner capture = new Scanner(System.in);
	    String aletter = capture.nextLine().toUpperCase();
	    Character letter = aletter.charAt(0);

		switch(letter)
		{
			case 'A' : subMenu_A();
				break;
			case 'B': subMenu_B();
				break;
			//case 'C': subMenu_C();
					//break;
			case 'D': subMenu_D();
				break;
			case 'E': subMenu_E();
				break;
			case 'N': subsubMenu_1();
				break;
			case 'F': subMenu_F();
				break;
			default:
				System.out.println("A - Create a contact\nB - Search\nC - View Contacts\nD - Delete a contact\nE - Save contact.AddressBook to file" );
				String bletter = capture.nextLine().toUpperCase();
				letter = bletter.charAt(0);
		}
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
		System.out.println("|       *  An address                                                                                 |");
		System.out.println("|             (this is written in one line with a semicolons to specify where a new line begins       |");
		System.out.println("|               no more than 5 lines are permitted);                                                  |");
		System.out.println("|                                                                                                     |");
		System.out.println("|       *  Phone numbers                                                                              |");
		System.out.println("|             (Here you will specify the type of phone: H- home, W- Work, M - Mobile,                 |");
		System.out.println("|               and 10 digit phone number);                                                           |");
		System.out.println("|                                                                                                     |");
		System.out.println("|       *  Email address                                                                              |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|_____________________________________________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		activeUserAB.add();
		mainMenu();
	}

		public void subMenu_B()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                     SEARCH FOR CONTACT                                              |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|    1 - Search by entry Number 							2 - Search by Email                       |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|_____________________________________________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println("Input 1 to search for a contact by entry number or 2 to search by email: ");
		int searchBy = sc.nextInt();
		switch(searchBy)
		{
			case 1:
				System.out.println("Please input entry number of contact");
				int entryNumber = sc.nextInt();

				activeUserAB.searchByEntry(entryNumber);
			break;
			case 2:
				System.out.println("Please input the email address for the contact whose details you would like to see: ");
				String email = sc.nextLine();
				activeUserAB.searchByEmail(email);
			break;
			default:
			System.out.println("Input invalid! Only 1 or 2 are acceptable inputs!");
			subMenu_B();
			//mainMenu()
		}
		mainMenu();
	}

		/*public void subMenu_C()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                     VIEW All CONTACT                                                |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|    1 - Sorted by entry Number  							2 - Sorted by Name                        |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
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
				activeUserAB.sortAllByEntry();
				//View method
				// subsubMenu_1() to further edit a contact
			break;
			case 2:
				activeUserAB.sortAllByName();
				//method to view
				// subsubMenu_1() to further edit a contact
			break;
			default:
			System.out.println("Input invalid!");
			mainMenu()
		}
		mainMenu();
	}*/

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
		System.out.println("|     X - Back                                                                   |");
		System.out.println("|                                                                                |");
		System.out.println("|________________________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		Scanner optionEdit = new Scanner(System.in);
		String editChoice = optionEdit.nextLine().toUpperCase();
		Character choice = editChoice.charAt(0);

		switch(choice)
		{
			case 'A':
				Scanner subsubChangeLN = new Scanner(System.in);
			 	System.out.println("Please input the name of the contact whose last name you would like to change, firstname, lastname, then the new lastname");
			 	String currentFN = subsubChangeLN.nextLine();
			 	String currentLN = subsubChangeLN.nextLine();
			 	String newLastN = subsubChangeLN.nextLine();


				activeUserAB.changeLastName(currentFN, currentLN, newLastN);

		 		subsubChangeLN.close();
		 	break;

		 	case 'B':
			 	Scanner subsubAlias = new Scanner(System.in);
			 	System.out.println("Please input the old Alias of the contact you wpuld like to edit, then the new Alias");
			 	String oldalias = subsubAlias.nextLine();
			 	String newAlias = subsubAlias.nextLine();

			 	activeUserAB.changeAlias(oldalias, newAlias);
			 	System.out.println("Successfully updated Alias");
				subsubAlias.close();
			break;

			case 'C':
		 		Scanner subsubAddress = new Scanner(System.in);
			 	System.out.println("Please input the Alias for the contact whose address you wish to change");
			 	String contactalias = subsubAddress.nextLine();
			 	System.out.println("Please enter the new contact.Address in one line, noting that each new line is indicated by a semicolon: ';'. ");
			 	String newAdd = subsubAddress.nextLine();
			 	activeUserAB.changeAddress(contactalias, newAdd);
				subsubAddress.close();
			break;

			case 'D':
		 		Scanner subsubAddPhone = new Scanner(System.in);

		 		System.out.println("Please input the Alias of the contact you wish to add another phone number");
		 		String capturedAlias = subsubAddPhone.nextLine();

			 	System.out.println("Please input the type of Phone; M- mobile, W- Work, H- Home: ");
			 	char newPhonetype = subsubAddPhone.next().charAt(0);

			 	System.out.println("Please input the 10 digit phone number ");
			 	long number = Long.parseLong(subsubAddPhone.nextLine());

			    subsubAddPhone.close();

			    for(Contact forEachcontact: activeUserAB.getContactList())
				{
					if(forEachcontact.getAlias().equals(capturedAlias))
					{
						forEachcontact.addPhone(newPhonetype, number);
					}

				}

		 	    System.out.println("Successfully added phone to contact");


				subsubAddPhone.close();
			break;

		 	case 'E':
		 		Scanner subsubAddEmail = new Scanner(System.in);

				System.out.println("Please input the Alias of the contact you wish to add another phone number");
				String tempAlias = subsubAddEmail.nextLine();

			 	System.out.println("Please input the new Email");
			 	String newEmail = subsubAddEmail.nextLine();

				for(Contact cont: activeUserAB.getContactList())
				{
					if(cont.getAlias().equals(tempAlias))
					{
						cont.addEmail(newEmail);
					}

				}

			 	System.out.println("Successfully added email to contact");

				subsubAddEmail.close();
			break;

		 	case 'F':
		 		Scanner subsubDeletePh = new Scanner(System.in);
		 		System.out.println("Please input the first and last name of the contact whos phone number you wish to delete");
			 	System.out.println("Firstname: ");
			 	String firstN = subsubDeletePh.nextLine();
			 	System.out.println("Lastname: ");
			 	String lastN = subsubDeletePh.nextLine();
			 	System.out.println("Please input the phone number you would like removed for this contact: ");
			 	long phoneToDelete = Long.parseLong(subsubDeletePh.nextLine());

			 	activeUserAB.deletePhone(firstN, lastN, phoneToDelete);

			 	subsubDeletePh.close();
			break;

		 	case 'G':
		 		Scanner subsubDeleteEmail = new Scanner(System.in);
			 	System.out.println("Please input the email you want to delete");
			 	String emailToDelete = subsubDeleteEmail.nextLine();
				for(Contact delforCont: activeUserAB.getContactList())
				{
					delforCont.deleteEmail(emailToDelete);
				}

			 	System.out.println("Email  has been deleted.");
			 	subsubDeleteEmail.close();
			break;

			case 'X': mainMenu();
			break;

			default:
				System.out.println("A - Change lastname\nB - Change Alias\nC - Change contact.Address\nD - Add Phone Number \nE - Add Email contact.Address\nF - Delete Phone Number\n G - Delete Email contact.Address\nH - Delete contact from contact.AddressBook\nX - Return to Main Menu" );
				editChoice = optionEdit.nextLine().toUpperCase();
		}
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
		System.out.println("|                                                                   |");
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
		switch(searchBy)
		{
			case 1:
				int delByEN = Integer.parseInt(sc5.nextLine());
				activeUserAB.deleteContactbyEntry(delByEN);
				System.out.println("contact.Contact removed from contact.AddressBook.");
			break;
			case 2:
				String delByEmail = sc5.nextLine();
				activeUserAB.deleteContactbyEmail(delByEmail);
				System.out.println("contact.Contact removed from contact.AddressBook.");
			break;
			default:
			System.out.println("Input invalid!");
			mainMenu();
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
		System.out.println("|                                              |");
		System.out.println("|                                              |");
		System.out.println("|              . . . . . . . . .               |");
		System.out.println("|______________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		activeUserAB.saveToFile();
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
		System.out.println("|_____________________________________________________________________________________________________|");


	}

	public static void main(String[] args)
	{
		TextUI session = new TextUI();
		session.onLaunch();

		session.loginTerminal();
	}
}
