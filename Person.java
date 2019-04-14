//package contact;

/**
* This class manages the details of a person.
* @author Jheanel Brown && Esther E
* @version 1.0
*/
public class Person
{
	private Name name; 
	private Gender gender;
	private long dateOfBirth;

	/**
	* This constructor creates a Person with a name, gender, and date of birth.
	* @param firstName Captures the person's first name.
	* @param lastName Captures the person's last name.
	* @param sex Captures the gender of the person.
	* @param dob Captures the date of birth of the person in the format yyyymmdd.
	*/
	public Person(String firstName, String lastName, Gender sex, long dob)
	{
		this.name = new Name(firstName, lastName);
		this.gender = sex;
		this.dateOfBirth = dob;
	}

	/**
	* This returns this person's first and last name.
	* @return The first then last name separated by space.
	*/
	public String getName()
	{
		return name.getFirstName() + " " + name.getLastName();
	}

	/**
	* This updates the last name for this Person.
	* @param newLName Captures the new last name that is to replace the current last name.
	*/
	public void changeLastName(String newLName)
	{
		name.changeLastName(newLName);
	}

	/**
	* This returns the gender for this Person.
	* @return The gender of this Person
	*/
	public Gender getGender()
	{
		return gender;
	}

	/**
	* This returns this Person's date of birth.
	* @return The date of birth in the format yyyymmdd. 
	*/
	public long getDOB()
	{
		return dateOfBirth;
	}
}
