//package contact;

import java.util.*;
import java.time.LocalDate;
import java.time.Period;

/**
* This class manages the contacts.
* @author Jheanel Brown
* @version 1.0
*/
public class AddressBook
{
	private ArrayList<Contact> addressBook = new ArrayList<Contact>();
	
	

	public void add(String firstName, String lastName)
	{
		this.firstN_user = firstName;
		this.lastN_user = lastName;

	}



	public static void main(String[] args)
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
