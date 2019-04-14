package contact;

/**
* This class manages the details of a phone.
* @author Jheanel Brown && Esther E
* @version 1.0
*/
public class Phone
{
	private long phoneNumber;
	private int areaCode;
	private char typeOfPhone;
	
	/**
	* This constructor creates a phone with a specified number and type.
	* @param tenDigitNumber Captures the phone number for this contact.
	* @param phoneType Captures the type of the phone number added- M for mobile, H for home, W for work.
	*/
	public Phone(long tenDigitNumber, char phoneType)
	{
		this.phoneNumber = tenDigitNumber;
		this.typeOfPhone = phoneType; 
	}

	/**
	* This returns only the area code from this contacts phone number. 
	* @return The 3 digit area code from the phone number.
	*/
	public int getAreaCode()
	{
		return Integer.parseInt(String.valueOf(phoneNumber).substring(0,3));
	}

	/**
	* This returns the phone number without the area code from this contact's phone number. 
	* @return The seven (7) digit phone number. 
	*/
	public long getNumber()
	{
		return phoneNumber;
	}

	/**
	* This returns the type of the phone that was added for this contact.
	* @return A character of either H for home, M for mobile or W for work.
	*/
	public char getType()
	{
		return typeOfPhone;
	}

	/**
	* This returns the phone number specially formatted.
	* @return The phone number of the contact formatter "(555) 555-5555".
	*/
	public String toString()
	{
		return "(" + getAreaCode() + ") " + String.valueOf(phoneNumber).substring(3, 6) + "-" + String.valueOf(phoneNumber).substring(6);
	}
}
