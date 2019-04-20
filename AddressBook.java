package contact;

import org.jetbrains.annotations.Contract;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

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
	private Contact newC;

	/**
	* Allows for the reading of a specific Users contact file
	* @param userName captures the contacts UserName which is used to get their contact.AddressBook; Contacts are retrieved and stored into a list.
	*
	*/
	public AddressBook(String userName)
	{
		this.username = userName;
		this.data = new DataManager();
		this.contacts = data.readContactFile(username);

	}

	@Contract(pure = true)
	public AddressBook()
	{

	}


	/**
	* Allows for a contact to be created and added to the list of contacts
	* Only the default parameters are captured.
	* @param firstName Holds the first name of a given contact.
	* @param lastName Holds the last name of a given contact.
	* @param gender Captures the gender of the contact.
	* @param dob Captures the date of birth of the contact.
	*
	**/
	public void add(String firstName, String lastName, Gender gender, long dob)
	{
		this.newC = new Contact(firstName, lastName, gender, dob);
		contacts.add(newC);
	}

	public DataManager getDataManagerInstance()
	{
		return this.data;
	}

	public ArrayList<Contact> getContactList()
	{
		return this.contacts;
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

		System.out.println("contact.Gender (MALE or FEMALE): ");
		String getGend = add.nextLine().toUpperCase();
		Gender gender = Gender.valueOf(getGend);

		this.newC = new Contact(first, last, gender, dob);
		//contact.AddressBook.add(String firstName, String lastName, contact.Gender gender, long dob)

		System.out.println("Alias");
		String altName = add.nextLine();
		newC.setAlias(altName);

		System.out.println("Addres (street;street2;street3;city;country): ");
		String address = add.nextLine();
		newC.setAddress(address);

		System.out.println("_____________________________________________________________________________________________________");
		System.out.println("Would you like to add a phone number? 'Y' for yes, 'N' for no.");
		String response = add.nextLine();
		while(response.toUpperCase().compareTo("Y")== 0)
		{
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Phone type, ie M - Mobile, W - Work, H- Home");
			String getchar =  sc1.nextLine().toUpperCase();
			Character type = getchar.charAt(0);

			System.out.println("10 digit number: ");
			long number = Long.parseLong(sc1.nextLine());

			newC.addPhone(type, number);
			System.out.println("Would you like to add a phone number? 'Y' for yes, 'N' for no.");
			response = add.nextLine();
		}
		System.out.println("_____________________________________________________________________________________________________");

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
				newC.addEmail(addEmail2);

				System.out.println("Would you like to add another email? 'Y' for yes, 'N' for no. ");
				response3 = sc2.nextLine();
			}
			while(response3.toUpperCase().compareTo("Y")== 0);
		}

		contacts.add(newC);
		System.out.println("Contact Added!");
	}

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
			if((contacts.get(i).getAlias()).equals(newAlias))
			{
				System.out.println("The Alias must be unique. This Alias already exist.");
			}
			else
			{
				if(contacts.get(i).getAlias().equals(oldAlias))
				{
					contacts.get(i).setAlias(newAlias);
					System.out.println("Alias has been updated");
				}
				else
				{
					System.out.println("No such user Exists with that Alias.");
				}
			}
		}
	}


	public void changeLastName(String firstname, String lastname, String newLastName)
	{
		for(int i = 0; i < contacts.size(); i++)
		{
			String[] name = contacts.get(i).getName().split(",");
			String last = name[1];
			String first = name[0];
			if(last.equals(first) && first.equals(firstname))
			{
				contacts.get(i).updateName(newLastName);
				System.out.println("Successfully updated Lastname for " + contacts.get(i).getName());
			}
			else
			{
				System.out.println("No such user Exists with that first and lastname.");
			}
		}
	}

	public void changeAddress(String identifier, String newAdd)
	{
		for(int i = 0; i < contacts.size(); i++)
		{
			if(identifier.equals(contacts.get(i).getAlias()))
			{
				contacts.get(i).setAddress(newAdd);
				System.out.println("Successfully updated address for " + contacts.get(i).getName());
			}
			else
			{
				System.out.println("No such user Exists with that first and lastname.");
			}
		}
	}

	public String searchByEntry(int number)
	{
		for(Contact c: contacts)
		{
			if (c.getEntry() ==  number)
			{
				String flatAddress="";
				String flatPhone="";
				String flatEmail="";
				//To flatten out the contact.Address which is a String[]
				for(String AddressLine: c.getAddress())
				{
					flatAddress = String.join(" ", AddressLine);
				}

				for(String each: c.getPhoneList())
				{
					flatPhone = String.join(" , ", each.toString());
				}

				for(String email: c.getEmailList())
				{
					flatEmail = String.join(" , ", email);
				}
				return c.getEntry() + ", " + c.getName()+ ", " + c.getGender() + ", " + c.getAlias()+ ", "+ flatAddress+ ", " + flatPhone + ", " + flatEmail;
			}
		}
		return "No contact with that entry number.";
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
					String flatAddress="";
					String flatPhone="";
					String flatEmail="";
					//To flatten out the contact.Address which is a String[]
					for(String AddressLine: c.getAddress())
					{
						flatAddress = String.join(";", AddressLine);
					}

					for(String each: c.getPhoneList())
					{
						flatPhone = String.join(", ", each.toString());
					}

					for (String email1: c.getEmailList())
					{
						flatEmail = String.join(", ", email1);
					}

					return c.getEntry() + ", " + c.getName()+ ", " + c.getGender() + ", " + c.getAlias()+ ", "+ flatAddress + ", "+ flatPhone + ", " + flatEmail;
				}
			}
		}
		String s = "No such contact exists with that email!";
		return s;
	}

	public void sortAllByEntry()
	{
		contacts.sort(new ComparebyEntryNum());
	}

	public void sortAllByName()
	{
		Collections.sort(contacts);
	}

	public void deletePhone(String first1, String last1, long phoneNum)
	{
		for(int i = 0; i < contacts.size(); i++)
		{
			String[] name = contacts.get(i).getName().split(",");
			String last = name[1];
			String first = name[0];
			if(last.equals(last1) && first.equals(first1))
			{
				contacts.get(i).deletePhone(phoneNum);
				System.out.println("Phone number has been deleted for " + contacts.get(i).getName());
			}
			else
			{
				System.out.println("No such user exists with that name.");
			}
		}
	}

	public void deleteEmail(String first2, String last2, String email)
	{
		for(int i = 0; i < contacts.size(); i++)
		{
			String[] name = contacts.get(i).getName().split(",");
			String last = name[1];
			String first = name[0];
			if(last.equals(last2) && first.equals(first2))
			{
				contacts.get(i).deleteEmail(email);
				System.out.println("The following email, " + email + " has been deleted for " + contacts.get(i).getName());
			}
			else
			{
				System.out.println("No such user exists with that name.");
			}
		}
	}

	public void deleteContactbyEntry(int entry)
	{
		Collections.sort(contacts, new ComparebyEntryNum());
		for(Contact c: contacts)
		{
			if (c.getEntry() == (entry))
			{
				contacts.remove(c.getEntry());
			}
		}
	}

	public void deleteContactbyEmail(String emailToDelete)
	{
		for(int c = 0; c<contacts.size(); c++)
		{
			for(String emails: contacts.get(c).getEmailList())
				if (emails.equals(emailToDelete))
				{
					contacts.remove(c);
				}
		}
	}
	public void saveToFile()
	{
		for(int i = 0; i<contacts.size(); i++)
		{
			//String entry = i.getEntry();
			String alias = contacts.get(i).getAlias();
			String name = contacts.get(i).getName();
			String gender =  String.valueOf(contacts.get(i).getGender());
			String dateOB = String.valueOf(contacts.get(i).getDOB());
			
			String flatAddress="";
			String flatPhone="";
			String flatEmail="";

			for(String AddressLine: contacts.get(i).getAddress())
			{
				flatAddress = String.join(";", AddressLine);
			}

			for(String each: contacts.get(i).getPhoneList())
			{
				flatPhone = String.join(",", each.toString());
			}

			for(String email: contacts.get(i).getEmailList())
			{
				flatEmail = String.join(",", email);
			}
			//contact.DataManager(this.username);
			String info = (alias+"%" + name + "," + gender + "," + dateOB + "%" + flatAddress + "%" + flatPhone + "%" + flatEmail);
			data.writeToFile(info, "C:\\Users\\lenovo\\Desktop\\contact\\datamanager\\Session\\" + username);
		}
	}
}
