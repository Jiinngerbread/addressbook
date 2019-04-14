package contact;

import java.util.*;

/**
* This class manages the details of an address.
* @author Jheanel Brown and Esther E
* @version 1.0
*/
public class Address
{ 
	private String[] address;
	private int lengthOfArray;

	/**
	* This creates an address from a string input, with different parts separated by semicolons.
	* @param fullAddress The full address.
	*/
	public Address(String fullAddress)
	{
		String[] tempAddress = fullAddress.split(";");
		ArrayList<String> newaddress= new ArrayList<String>();

		for(String each: tempAddress)
		{
			if(each.length() != 0)
			{
				newaddress.add(each);
			}	
		}

		this.address = newaddress.toArray(new String[newaddress.size()]);
	}
		
	/**
	* This returns an array of lines in an address. 
	* @return The full address not including blank lines. 
	*/
	public String[] getAddress()
	{
		return address;
	}

	/**
	* This returns the country of residence for a contact.
	* @return The name of the country.
	*/
	public String getCountry()
	{
		this.lengthOfArray = address.length;
		return address[lengthOfArray-1];
	}
	
	/**
	* This returns this contacts address formatted 
	* @return The address formatted to supress blank lines,  as well a to separate different parts by a new line.
	*/
	public String toString()
	{
		String addressLine = "";

		for(String eachline: address)
		{
			addressLine += "\n"+ eachline ;
		}
		return addressLine;
	}
}
