//package contact;

import java.util.*;
java.util.ArrayList class;
import java.Scanner;
import datamanager;


/**
* This class manages the contacts.
* @author Jheanel Brown && Esther E
* @version 1.0
*/
public class AddressBook implements Comparable<Contact> implements Comparator<Contact>
{
	private ArrayList<Contact> contacts;
	private DataManager data;
	private String username;

	/**
	* Allows for the reading of a specific Users contact file
	* @param userName capturs the contacts UserName which is used to get their AddressBook; Contacts are retrieved and stored into a list.
	*
	*/
	public AddressBook(String userName)
	{
		this.username = userName;
		//data = new DataManager();
		this.contacts = DataManager.readFile(username);
	}

	/**
	* Allows for a contact to be created and added to the list of contacts
	* Only the default parameters are captured.
	* @param firstName Holds the first name of a given contact. 
	* @param lastName Holds the last name of a given contact.
	* @param gender Captures the gender of the contact.
	* @param dob Captures the date of birthof the contact.
	*
	**/
	public void add(String firstName, String lastName, Gender gender, long dob)
	{
		Contact newC = new Contact(firstName, lastName, gender, dob);
		contacts.add(newC);
	}
	/**
	* Allows for a contact to be created through input from the user, then the data for the contact is added to a list of contacts
	**/
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
			System.out.println("Would you like to add a phone number? 'Y' for yes, 'N' for no.");
			response = add.nextLine();
			
		
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
				newContact.addEmail(addEmail2);
				
				System.out.println("Would you like to add another email? 'Y' for yes, 'N' for no. ");
				response3 = sc2.nextLine();
			}
			while(response3.toUpperCase().compareTo("Y")== 0);
		}

		contacts.add(newC);
		System.out.println("Contact Added!");
	}

	/**
	* Monitors the User Login interface for verified users and ensuring that unauthorized user does not gain access the system.
	*
	**/
	public void statusToLaunch()
	{
		int numtries=0;

		while(numtries<3) 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Username:");
			String userN = sc.nextLine();
			System.out.println("Password:");
			String passW = sc.nextLine();
			
			if(DataManager.Authenticate(userN, passW) == true)
			{
				AddressBook activeUserAB = new AddressBook(userN);
				//mainMenu();	
			} else
			{
				System.out.println("Username or password is incorrect, you have two more tries");
				numtries++;
			}
		}
		System.out.println("You have exceeded your number of tries, Goodbye");
		System.exit(0);
	}

	/**
	* Provides a means of accessing different Main Menu options within the TextUI
	*
	**/
	public void mainMenuNavigation()
	{
		Scanner capture = new Scanner(System.in);
		char letter = capture.nextLine().charAt().toUpperCase();
		
		while(!letter.equals("F"))
		{
			switch(letter)
			{
				case "A" : subMenu_A();
					break;	
				case "B": subMenu_B();			 	
					break; 
				case "C": subMenu_C();
					break;
				case "D": subMenu_D();
					break;
				case "E": subMenu_E();
					break;
				default:
					System.out.println("A - Create a contact\nB - Search\nC - View Contacts\nD - Delete a contact\nE - Save AddressBook to file" );
					letter = capture.nextLine();
		}   
		subMenu_F();
		System.exit();
		}
	}
	
	/*
	* Allows for a contact's Alias to be updated.
	*@param newAlias takes in the new Alias that the contact will now have
	*
	*
	public void changeAlias(String newAlias)
	{
		newC.getAlias() = newAlias;
	}
	*/

	/**
	* Allows for a contact's Alias to be updated.
	* @param oldAlias takes in the old Alias belonging to the contact to be modified
	* @param newAlias takes in the new Alias that the contact will now have
	*
	**/
	public void changeAlias(String oldAlias, String newAlias)
	{	

		for(int i = 0; i < contacts.size(); i++)
		{
			if(i.getAlias().equals(newAlias))
			{
				System.out.println("The Alias must be unique. This Alias already exist.")
			}
			else
			{
				if(i.getAlias.equals(oldAlias))
				{
					i.setAlias(newAlias);
					System.out.println("Alias has been updated");
				}
				else
				{
					System.out.println("No such user Exists with that Alias.")
				}
			}
		}
	}

	/*public void changeAddress(String newAdd)
	{
		newC.getAddress() = newC.setAddress(newAdd);
	}*/

	public void changeLastName(String firstname, String lastname, String newLastName)
	{
		for(int i = 0; i < contacts.size(); i++)
		{
			String[] name = i.getName().split(",");
			String last = name[1];
			String first = name[0];
			if(last.equals(current) && first.equals(firstname))
			{
				i.changeLastName(newLastName);
				System.out.println("Successfully updated Lastname for " + i.getName());
			}
			else
			{
				System.out.println("No such user Exists with that first and lastname.")
			}
		}
	}
	
	public void changeAddress(String identifier, String newAdd)
	{
		for(int i = 0; i < contacts.size(); i++)
		{
			if(identifier.equals(i.getAlias))
			{
				i.setAddress(newAdd);
				System.out.println("Successfully updated address for " + i.super.getName());
			}
			else
			{
				System.out.println("No such user Exists with that first and lastname.")
			}
		}
	}

	public String searchByEntry(int number)
	{
		for(Contact c: contacts)
		{
			if (c.getEntry().equals(number))
			{
				//To flatten out the Address which is a String[]
				for(String AddressLine: c.getAddress())
				{
					String flatAddress = String.join(" ", AddressLine);  
				}

				for(Phone each: c.getPhoneList())
				{
					String flatPhone = String.join(" , ", each.toString());
				}

				for(Contact email: c.getEmailList())
				{
					String flatEmail = String.join(" , ", email);
				}

				
				return c.getEntry() + ", " + c.getName()+ ", " + c.super.getGender() + ", " + c.getAlias()+ ", "+ flatAddress+ ", " + flatPhone + ", " + flatEmail;
			}
		}	
	}

	public String searchByEmail(String email)
	{
		
		for(Contact c: contacts)
		{
			String[] demail = c.getEmailList();
			for (String e: demail)
			{
				if (e.equals(email))
				{
					//To flatten out the Address which is a String[]
					for(String AddressLine: c.getAddress())
					{
						String flatAddress = String.join(";", AddressLine);  
					}

					for(Phone each: c.getPhoneList())
					{
						String flatPhone = String.join(", ", each.toString());
					}

					for(Contact email: c.getEmailList())
					{
						String flatEmail = String.join(", ", email);
					}
					
					return c.getEntry() + ", " + c.getName()+ ", " + c.super.getGender() + ", " + c.getAlias()+ ", "+ flatAddress + ", "+ flatPhone + ", " + flatEmail;
				}
				else
				{
					return "No such contact exists with that email!";
				}
			}
		}	
	}

	public ArrayList<Contact> sortAllByEntry()
	{
		return Collections.sort(contacts, new ComparebyEntryNum());
	}

	public ArrayList<Contact> sortAllByName()
	{
		return Collections.sort(contacts, new ComparebyName())
	}

	public void deletePhone(String first1, String last1, long phoneNum)
	{
		

		for(int i = 0; i < contacts.size(); i++)
		{
			String[] name = i.getName().split(",");
			String last = name[1];
			String first = name[0];
			if(last.equals(last1) && first.equals(first1))
			{
				i.deletePhone(phoneNum);
				System.out.println("Phone number has been deleted for " + i.getName());
			}
			else
			{
				System.out.println("No such user exists with that name.")
			}
		}

		
		/*String s= searchByEntry();
		String[] useful = s.split(,);
		int entryNum = useful[0];
		for (int c=0 ;c< contacts.length(); i++)
		{
			if(contact[c].getEntry().equals(entryNum))
			{
				c.deletePhone();
			}
		}*/
	}

	public void deleteEmail(String first2, String last2, String email)
	{
		for(int i = 0; i < contacts.size(); i++)
		{
			String[] name = i.getName().split(",");
			String last = name[1];
			String first = name[0];
			if(last.equals(last2) && first.equals(first2))
			{
				i.deleteEmail(phoneNum);
				System.out.println("The following email, " + email + " has been deleted for " + i.getName());
			}
			else
			{
				System.out.println("No such user exists with that name.")
			}
		}
		/*
		String s= searchByEntry();
		String[] useful = s.split(,);
		int entryNum = useful[0];
		for (int c=0 ;c< contacts.length(); i++)
		{
			if(contacts[c].getEntry().equals(entryNum))
			{
				c.deleteEmail();
			}
		}*/
	}
	
	public void deleteContactbyEntry()
	{
		Scanner dce = new Scanner(System.in);
		System.out.println("Enter entry number");
		int entryNum = dce.nextInt();
		Contact delCon;
		for(Contact c: contacts)
		{
			if (c.getEntry().equals(entryNum))
			{
				delCon = c;
			}
		}
		return contacts.remove(c);
	}

	public void deleteContactbyEmail()
	{
		Scanner dcem = new Scanner(System.in);
		System.out.println("Enter email address");
		String entryNum = dcem.nextLine();
		Contact delCon;
		for(Contact c: contacts)
		{
			emails = c.getEmailList();
			if (c.getEntry().equals(entryNum))
			{
				delCon = c;
			}
		}
		return contacts.remove(c);
	
	
	}
	public void saveToFile()
	{
		for(int i = 0; i<contact.size(); i++)
		{
			String entry = i.getEntry();
			String alias = i.getAlias();
			String name = i.getName();
			String gender = i.super.getGender().valueOf();
			//String 
		}
	}

 	public void subsubNavigationMenu()
 	{
    	Scanner optionEdit = new Scanner(System.in);
		char editChoice = optionEdit.charAt().toUpperCase();

		switch(editChoice)
		{
			case 'A':	
				Scanner subsubChangeLN = new Scanner(System.in);
			 	System.out.println("Please input the name of the contact whose last name you would like to change, firstname, lastname, then the new lastname");
			 	String currentFN = subsubChangeLN.nextLine();
			 	String currentLN = subsubChangeLN.nextLine();
			 	String newLastN = subsubChangeLN.nextLine();
			 
				
				updateName(currentFN, currentLN, newLastN);
				
		 		subsubChangeLN.close();
		 	break;
		 	
		 	case 'B':
			 	Scanner subsubAlias = new Scanner(System.in);
			 	System.out.println("Please input the old Alias of the contact you wpuld like to edit, then the new Alias");
			 	String oldalias = subsubAlias.nextLine();
			 	String newAlias = subsubAlias.nextLine();
			 	
			 	changeAlias(oldalias, newAlias);
			 	System.out.println("Successfully updated Alias");			 	
				subsubAlias.close();
			break;

			case 'C':
		 		Scanner subsubAddress = new Scanner(System.in);
			 	System.out.println("Please input the Alias for the contact whose address you wish to change");
			 	String contactalias = subsubAddress.nextLine();
			 	System.out.println("Please enter the new Address in one line, noting that each new line is indicated by a semicolon: ';'. ");
			 	String newAdd = subsubAddress.nextLine();
			 	changeAddress(contactalias, newAdd);
				subsubAddress.close();
			break;

			case 'D':
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
			break;

		 	case 'E';
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
			break;

		 	case 'F':
		 		Scanner subsubDeletePh = new Scanner(System.in);
		 		System.out.println("Please input the first and last name of the contact whos phone number you wish to delete");
			 	System.out.println("Firstname: ");
			 	String firstN = sc.nextLine();
			 	System.out.println("Lastname: "); 
			 	String lastN = sc.nextLine();
			 	System.out.println("Please input the phone number you would like removed for this Contact: ");
			 	Long phoneToDelete = Long.parseLong(subsubDeletePh.nextLine()); 
			 	
			 	deletePhone(firstN, lastN, phoneToDelete);
			 	
			 	subsubDeletePh.close();
			break;
		 	
		 	case 'G':
		 		Scanner subsubDeleteEmail = new Scanner(System.in);
			 	System.out.println("Please input the email you want to delete");
			 	String emailToDelete = subsubDeleteEmail.nextLine(); 
			 	
			 	newC.deletePhone(emailToDelete);
			 	System.out.println("Email  has been deleted.");
			 	subsubDeleteEmail.close(); 
			break;
			default: 
				System.out.println("A - Change lastname\nB - Change Alias\nC - Change Address\nD - Add Phone Number \nE - Add Email Address\nF - Delete Phone Number\n G - Delete Email Address\nH - Delete contact from AddressBook\nX - Return to Main Menu" );
				editChoice = optionEdit.nextLine().toUpperCase();

		}
	}
}
