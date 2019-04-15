//package contact;

import java.util.*;


/**
* This class manages the contacts.
* @author Jheanel Brown && Esther E
* @version 1.0
*/
public class AddressBook implements DataManager
{
	private ArrayList<Contact> contacts;
	private DataManager data;

	public AddressBook()
	{
		this.username = userN;
		data = new DataManager();
		this.contacts = DataManager.readFile(username);
	}
	

	public void add(String firstName, String lastName, Gender gender, long dob)
	{
		contacts.add(new Contact(firstName,lastName, gender, dob));
	}



	
}
