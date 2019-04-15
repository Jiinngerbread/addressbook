//package contact;

import java.util.*;


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
		Contact newContact = new Contact(firstName,lastName, gender, dob);
		newContact.setAddress= 
		contacts.add(newContact);

	}



	
}
