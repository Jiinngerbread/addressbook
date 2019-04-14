
import java.util.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
* This class manages the details of an Addressbook User.
* @author Jheanel Brown && Esther E
* @version 1.0
*/
public class User extends Person 
{
	private  Password passWord;
	private String username;

	public User (String firstname, String lastname, Gender gender, long dob, String userName, String pWord) throws NoSuchAlgorithmException
	{
		super(firstname,lastname, gender, dob);
		this.passWord = new Password(pWord);
		this.username = userName;

	}

	/*public User(String user, String passcode)
	{
		this.passWord = new Password(passcode);
		this.username = user;	
	}*/

	public String getUsername()
	{
		return this.username;
	}

	public String getName()
	{
		String[] nameList = super.getName().split(" ");
		String firstNAME = nameList[1];
		String lastNAME = nameList[0];

		return firstNAME + "_" + lastNAME;
	}


	public String getUserFirstname()
	{
		String[] nameList = super.getName().split(" ");
		String firstN_user = nameList[1];
		return firstN_user;
	}

	public String getUserLastname()
	{
		String[] nameList = super.getName().split(" ");
		String lastN_user = nameList[1];
		return lastN_user;
	}

	public Password getpassword()
	{
		return passWord;
	}
}
