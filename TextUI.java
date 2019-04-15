import java.util.*
iport java.util.Scanner;

public class TextUI
{
	public TextUI()
	{

	}
		
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
		int numtries=0;
		boolean loginStatus = false;

		while(numtries<3) 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Username:");
			String userN = sc.nextLine();
			System.out.println("Password:");
			String passW = sc.nextLine();
		
			if(DataManager.Authenticate(userN, passW) == true)
			{
				loginStatus = true;
				//Launch addressbook app
				
			} else
			{
				System.out.println("Username or password is incorrect, you have two more tries");
				numtries++;
			}

			if(loginStatus == true)
			{
				AddressBook activeUserAB = new AddressBook(userN);
				mainMenu();

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
		
		Scanner capture = new Scanner(System.in);
		String option = capture.nextLine().toUpperCase();

		while (!option.equals("F")) 
		{
			if (option.equals("A")) 
			{	
	
		 	} 
		 	
		 	else if (option.equals("B")) 
		 	{
			 				 	
			} 

			else if (option.equals("C")) 
			{
		 	
		 	}
		 	else if(option.equals("D"))
		 	{

		 	}
		 	else(option.equals("E"))
		 	{

		 	}

		 	System.out.println("A - Create a contact\nB - Search\nC - View Contacts\nD - Delete a contact\nE - Save AddressBook to file" );
			option = capture.nextLine();
		}
		System.out.println("-------------Goodbye---------------");
	}

	public void subMenu_A()
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                 CREATE A NEW CONTACT                                                |");
		System.out.println("|                                                                                                     |");
		System.out.println("|    To create a contact you need to provide the following information:                               |");
		System.out.println("|       * The contact's Name (firs, then lastname);                                                   |");
		System.out.println("|       * Gender;                                                                                     |");
		System.out.println("|       * Date of Birth in the format of yyyymmdd;                                                    |");
		System.out.println("|       * An Alias for the contact;                                                                   |");
		System.out.println("|                                                                                                     |");
		System.out.println("|       * An address                                                                                  |")
		System.out.println("|         (this is written in one line with a semicolons to specify where a new line begins           |");
		System.out.println("|            no more than 5 lines are permitted);                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|       * Phone numbers                                                                               |");
		System.out.println("|         (Here you will specify the type of phone: H- home, W- Work, M - Mobile,                     |");
		System.out.println("|           and 10 digit phone number);                                                               |");
		System.out.println("|                                                                                                     |");
		System.out.println("|       * Email address                                                                                             |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|_____________________________________________________________________________________________________|");
		System.out.println();
		System.out.println();
		System.out.println();

		Scanner add = new Scanner(System.in);

		System.out.println("Firstname: ");
		String first = add.nextLine();

		System.out.println("Lastname: ");
		String last = add.nextLine();

		System.out.println("Date of Birth, yyyymmdd: ");
		Long dob = Long.parseLong(add.nextLine());

		System.out.println("Gender (MALE or FEMALE): ");
		Gender gender = Gender.valueOf(add.nextLine());

		Contact newC = new Contact(first, last, gender, dob);
		//AddressBook.add(String firstName, String lastName, Gender gender, long dob)

		System.out.println("Alias");
		String altName = add.nextLine();
		newC.setAlias(altName);

		System.out.println("Addres (street;street2;street3;city;country): ")
		String address = add.nextLine();
		newC.setAddress(address);

		System.out.println("Phone type, ie M - Mobile, W - Work, H- Home");
		char type = add.next().charAt(0);

		System.out.println("10 digit number: ");
		long number = Long.parseLong(add.nextLine());
		newC.addPhone(type, number);

		System.out.println("Email address: ");
		String emailAdd = add.nextLine();
		newC.addEmail(emailAdd);







	}


}
