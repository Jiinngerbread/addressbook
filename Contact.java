//package contact;

import java.util.*;
java.util.ArrayList class.
import java.time.LocalDate;
import java.time.Period;

/**
* This class manages the details of a contact.
* @author Jheanel Brown and Esther E
* @version 1.0
*/
public class Contact extends Person
{
	private Address resident;
	private ArrayList<Phone> phones = new ArrayList<Phone>();
	private static int entry = 0;
	private final int COUNTER = 1;
	private String altName;
	private ArrayList<String> emailList = new ArrayList<String>();

	/**
	* This accepts data for setting up a person's details, using first name, last name, gender and date of birth.
	* Also a unique identifyer for each contact is generated.
	* @param firstname Captures the first name for the contact being set up.
	* @param lastname Captures the last name for the contact being set up. 
	* @param gender Captures the gender for the contact being added.
	* @param dob Captures the date of birth for the contact being added, in the format yyyymmdd.
	*/
	public Contact(String firstname, String lastname, Gender gender, long dob)
	{
		super(firstname,lastname, gender, dob);
		this.entry += COUNTER;
	}

	/**
	* This returns the unique identifer assigned to this contact.
	* @return This contact's unique identifer or entry number.
	*/
	public int getEntry()
	{
		return entry;
	}

	/**
	* This returns the current age of this contact. 
	* @return This contact's current age.
	*
	*/
	public int getAge()
	{
		LocalDate todaysDate = LocalDate.now();

		String tempdob = String.valueOf(getDOB());
		String format_tempdob = tempdob.substring(0,4) + "-" + tempdob.substring(4, 6) + "-" + tempdob.substring(6);
		LocalDate birthday = LocalDate.parse(format_tempdob);

		Period calcAge = Period.between(birthday, todaysDate);
		int ageInYears = calcAge.getYears();
		
		return ageInYears;
	}

	/**
	* This gets the name of the contact that was added.
	* @return This contact's name, in the format firstname,lastname.
	*
	**/
	public String getName()
	{
		String[] nameList = super.getName().split(" ");
		String firstNAME = nameList[1];
		String lastNAME = nameList[0];

		return firstNAME + "," + lastNAME;
	}

	/**
	* This updates the last name of the contact in question.
	* @param name Captures the new last name that is going to replace the old last name.
	*
	*/
	public void updateName(String name)
	{
		super.changeLastName(name);
	}

	/**
	* This method assignes an Alias for the contact that was added.
	* @param alias Captures the alternate name for this contact.
	*
	**/
	public void setAlias(String alias)
	{
		this.altName= alias;	
	}

	/**
	* This method returns the Alias for the contact in question.
	* @return This contact's Alias. 
	*/
	public String getAlias()
	{
		return altName;
	}

	/**
	* This sets up address for the contact being added.
	* @param address Captures the address of the contact; 5 lines are allowed; Each new line is indicated on input by the user using ";".
	*/
	public void setAddress(String address)
	{
		resident = new Address(address);
	}

	/**
	* This returns the address for this contact.
	* @return This contact's address.
	*/
	public String[] getAddress()
	{
		return resident.getAddress();
	}

	/**
	* This allows for a new email address to be added for the contact in question.
	* @param email Captures the new email address to be added to a list of email addresses for that contact.
	*/
	public void addEmail(String email)
	{
		emailList.add(email);
	}

	/**
	* This allows for an email entry to be removed for this contact. 
	* @param email Captures the email to be removed and sorts though the list of emails to remove the specified email.
	*/
	public void deleteEmail(String email)
	{
		for(int i = 0; i < emailList.size(); i++)
		{
			if(emailList.get(i).compareTo(email)== 0)
			{
				emailList.remove(i);
			}
		}
	}

	/**
	* This returns all the email addresses for the contact in question.
	* @return All the email addresses for this contact. 
	*/
	public String[] getEmailList()
	{
		String[] tempEmailList = emailList.toArray(new String[emailList.size()]);
		return tempEmailList;
	}

	/**
	* The allows for the addition of a phone number (as well as the type of phone being added) for this contact. 
	* Up to 5 phone numbers can be saved. 
	* @param type Captures the type of phone being added, M for mobile, H for home, and W for work.
	* @param number Captures the phone number of the contact. This number is stored in an array list of phone numbers.
	*/
	public void addPhone(char type, long number)
	{
		if(phones.size() == 5)
		{
			System.out.println("Phone number was not added. NOTE: No more than 5 phone numbers per contact!");
		}
		else
		{
			Phone contactsPhone = new Phone(number, type);
			phones.add(contactsPhone);
		}
	}

	/**
	* This removes a specified phone number from the Array list where they are stored. 
	* @param number Captures the phone number that must be removed from the phone list for this contact.
	*/
	public void deletePhone(long number)
	{
		for(int numTodelete = 0; numTodelete < phones.size(); numTodelete++)
		{
			if((phones.get(numTodelete)).getNumber() == number)
			{
				phones.remove(numTodelete);
			}
		}
	}

	/**
	* This returns all the phone numbers for this contact.
	* @return This contact's phone number(s).
	*/
	public String[] getPhoneList()
	{
		ArrayList<String> phoneString = new ArrayList<String>();
		for(Phone each: phones)
		{
			phoneString.add(each.toString());

		}
		String[] tempPhoneList = phoneString.toArray(new String[phones.size()]);
		return tempPhoneList;
	}

	public String toString
	{
		return (getEntry() + ", " + getName()+ ", " + super.getGender() + ", " + getAlias()+ "," getEmailList());
	}
}
