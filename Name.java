package contact;

/**
* This class manages the details of a name.
* @author Jheanel Brown and Esther E
* @version 1.0
*/
public class Name
{
	private String firstname;
	private String lastname;

	/**
	* This constructs a Name using the first and last name.
	* @param firstName Captures the first name.
	* @param lastName Captures the last name.
	*/
	public Name(String firstName, String lastName)
	{
		this.firstname = firstName;
		this.lastname =lastName;
	}

	/**
	* This returns the first name.
	* @return The first name.
	*/
	public String getFirstName()
	{
		return this.firstname;
	}
	
	/**
	*This returns the last name.
	* @return The last name.
	*/
	public String getLastName()
	{
		return this.lastname;
	}

	/**
	* This updates the last name to the specfied name.
	* @param newName Captures the new last name.
	*/
	public void changeLastName(String newName)
	{
		this.lastname = newName;
	}
}
