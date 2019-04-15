//package contact;

import java.util.*;
import java.Scanner;


/**
* This class manages the contacts.
* @author Jheanel Brown && Esther E
* @version 1.0
*/
public class AddressBook 
{
	private ArrayList<Contact> contacts;
	private DataManager data;
	private String username;

	public AddressBook(String userName)
	{
		this.username = userName;
		data = new DataManager();
		this.contacts = DataManager.readFile(username);
	}

	public void add(String firstName, String lastName, Gender gender, long dob)
	{
		Contact newC = new Contact(firstName, lastName, gender, dob);
		contacts.add(newC);
	}

	public void add()
	{
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
		
		System.out.println("_____________________________________________________________________________________________________")
		System.out.println("Would you like to add a phone number? 'Y' for yes, 'N' for no.");
		String response = add.nextLine();
		while(response.toUpperCase().compareTo("Y")== 0)
		{
					
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Phone type, ie M - Mobile, W - Work, H- Home");

			char type = sc1.next().charAt(0);

			System.out.println("10 digit number: ");
			long number = Long.parseLong(sc1.nextLine());
		
			newC.addPhone(type, number);
		}
		/*System.out.println("Phone type, ie M - Mobile, W - Work, H- Home");
		char type = add.next().charAt(0);

		System.out.println("10 digit number: ");
		long number = Long.parseLong(add.nextLine());
		newC.addPhone(type, number);

		System.out.println("Would you like to add another number? 'Y' for yes, 'N' for no.");
		String response = add.nextLine();
		
		if(response.toUpperCase().compareTo("Y")== 0)
		{
			String response2 = "";
			do
			{ 
				System.out.println("Input next phone type then  number: " );
				char addType = phone.next().charAt(0);
				long addNumber = phone.nextLong();
				newC.addPhone(addType, addNumber);
				System.out.println();
				System.out.println("Would you like to add another number? 'Y' for yes, 'N' for no");
				Scanner sc1 = new Scanner(System.in);
				response2 = sc1.nextLine();
			}
			while(response2.toUpperCase().compareTo("Y")== 0);*/
		}
		System.out.println("_____________________________________________________________________________________________________")

		System.out.println();
		System.out.println("Email address: ");
		String emailAdd = add.nextLine();
		newC.addEmail(emailAdd);
		System.out.println();
		System.out.println("EMAIL: Would you like to add another email address? 'Y' for yes, 'N' for no.");
		String emailR = add.nextLine();
		
		if(emailR.toUpperCase().compareTo("Y")== 0)
		{
			String response3 = "";
			do
			{ 
				System.out.println("Input next email: " );
				Scanner sc2 = new Scanner(System.in);
				String addEmail2 = sc2.nextLine();
				System.out.println("Would you like to add another email? 'Y' for yes, 'N' for no. ");
				response3 = sc2.nextLine();
				newContact.addEmail(addEmail2);
			}
			while(response3.toUpperCase().compareTo("Y")== 0);
		}

		contacts.add(newC);
		System.out.println("Contact Added!");
	}

	public void statusToLaunch()
	{
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

	public void mainMenuNavigation()
	{
		Scanner capture = new Scanner(System.in);
		String letter = capture.nextLine().toUpperCase();

		while (!letter.equals("F")) 
		{
			if (letter.equals("A")) 
			{	
				return subMenu_A();
			} 
				 	
			else if (letter.equals("B")) 
			{
				return subMenu_B();			 	
			} 

			else if (letter.equals("C")) 
			{
				return subMenu_C();
			}
			else if(letter.equals("D"))
			{
				return subMenu_D();
			}
			else(letter.equals("E"))
			{
				return subMenu_E();
		 	}
		System.out.println("A - Create a contact\nB - Search\nC - View Contacts\nD - Delete a contact\nE - Save AddressBook to file" );
		letter = capture.nextLine();
		}   
		subMenu_F();
		System.exit();
	}

	public void changeAlias(String newAlias)
	{
		newC.getAlias() = newAlias;
	}
	public void changeAddress(String newAdd)
	{
		newC.getAddress() = newC.setAddress(newAdd);
	}

	public String[] searchByEntry()
	{

	}

	public String[] searchByEntry()
	{

	}

	public String[] searchByEmail()
	{

	}

	public ArralList<Contact> sortAllByEntry()
	{

	}

	public ArralList<Contact> sortAllByName()
	{
		
	}

	public void deleteContactbyEN(int entry)
	{

	}

	public void deleteContactbyEmail(String email)
	{
		
	}

	public void saveToFile()
	{
		
	}

 	public void subsubNavigationMenu()
 	{
    	Scanner optionEdit = new Scanner(System.in);
		String editChoice = optionEdit.nextLine().toUpperCase();

		while (!editChoice.equals("X")) 
		{
			if (editChoice.equals("A")) 
			{	
				Scanner subsubChangeLN = new Scanner(System.in);
			 	System.out.println("Please input the new Alias");
			 	String newLastN = subsubChangeLN.nextLine();
			 	
				newc.updateName(newLastN);
				//can i call the contact object here 
				System.out.println("Successfully updated Lastname");
		 		subsubChangeLN.close();
		 	} 
		 	
		 	else if (editChoice.equals("B")) 
		 	{
			 	Scanner subsubAlias = new Scanner(System.in);
			 	System.out.println("Please input the new Alias");
			 	String newAlias = subsubAlias.nextLine();
			 	
			 	newC.changeAlias(newAlias);
			 	System.out.println("Successfully updated Alias");			 	
				subsubAlias.close();
			} 

			else if (editChoice.equals("C")) 
			{
		 		Scanner subsubAddress = new Scanner(System.in);
			 	System.out.println("Please input the new Address, each line separated by ';'. ");
			 	String newAdd = subsubAddress.nextLine();
			 	newC.changeAddress(newAdd);
			 	System.out.println("Successfully updated Address");
				subsubAddress.close();
			}
		 	else if(editChoice.equals("D"))
		 	{
		 		Scanner subsubAddPhone = new Scanner(System.in);
			 	System.out.println("Please input the type of Phone; M- mobile, W- Work, H- Home: ");
			 	Char newPhonetype = subsubAddPhone.next().charAt(0);
			 	System.out.println("Please input the 10 digit phone number ");
			 	Long number = Long.parseLong(subsubAddPhone.nextLine());
			 	Scanner.close();
			 	newC.addPhone(newPhonetype, number);
			 	System.out.println("Successfully added phone to contact");
		 		//below for multiple adds
		 		/*System.out.println("Phone type, ie M - Mobile, W - Work, H- Home");
				char type = subsubAddPhone.next().charAt(0);

				System.out.println("10 digit number: ");
				long number = Long.parseLong(subsubAddPhone.nextLine());
				newC.addPhone(type, number);

				System.out.println("Would you like to add another number? 'Y' for yes, 'N' for no.");
				String response = subsubAddPhone.nextLine();
				
				if(response.toUpperCase().compareTo("Y")== 0)
				{
					String response3 = "";
					do
					{ 
						System.out.println("Input next phone type then  number: " );
						char addType = subsubAddPhone.next().charAt(0);
						long addNumber = subsubAddPhone.nextLong();
						newC.addPhone(addType, addNumber);
						System.out.println();
						System.out.println("Would you like to add another number? 'Y' for yes, 'N' for no");
					
						response3 = subsubAddPhone.nextLine();
					}
					while(response3.toUpperCase().compareTo("Y")== 0);
				}*/
				subsubAddPhone.close();
		 	}
		 	else if(editChoice.equals("E"))
		 	{
		 		Scanner subsubAddEmail = new Scanner(System.in);
			 	System.out.println("Please input the new Email");
			 	String newEmail = subsubAddEmail.nextLine();
			 	
			 	newC.changeAlias(newEmail);
			 	System.out.println("Successfully added email to contact");
		 	
		 		/*System.out.println("Would you like to add another email address? 'Y' for yes, 'N' for no.");
				String emailR = subsubAddEmail.nextLine();
		
				if(emailR.toUpperCase().compareTo("Y")== 0)
				{
					String response5 = "";
					do
					{ 
						System.out.println("Input next email: " );
						Scanner subsubAddEmail = new Scanner(System.in);
						String addEmail2 = subsubAddEmail.nextLine();
						System.out.println("Would you like to add another email? 'Y' for yes, 'N' for no. ");
						response5 = subsubAddEmail.nextLine();
						newContact.addEmail(addEmail2);
					}
					while(response5.toUpperCase().compareTo("Y")== 0);
				}*/
				subsubAddEmail.close();
		 	}
		 	else if(editChoice.equals("F"))
		 	{
		 		Scanner subsubDeletePh = new Scanner(System.in);
			 	System.out.println("Please input the number you want to delete");
			 	Long phoneToDelete = Long.parseLong(subsubDeletePh.nextLine()); 
			 	
			 	newC.deletePhone(phoneToDelete);
			 	System.out.println("Phone number has been deleted.");
			 	subsubDeletePh.close();
		 	}
		 	else if(editChoice.equals("G"))
		 	{
		 		Scanner subsubDeleteEmail = new Scanner(System.in);
			 	System.out.println("Please input the email you want to delete");
			 	String emailToDelete = subsubDeleteEmail.nextLine(); 
			 	
			 	newC.deletePhone(emailToDelete);
			 	System.out.println("Email  has been deleted.");
			 	subsubDeleteEmail.close(); 
		 	}
		 	System.out.println("A - Change lastname\nB - Change Alias\nC - Change Address\nD - Add Phone Number \nE - Add Email Address\nF - Delete Phone Number\n G - Delete Email Address\nH - Delete contact from AddressBook\nX - Return to Main Menu" );
			editChoice = optionEdit.nextLine().toUpperCase();
		}	 	
	}
}
