
import java.util.*;

/**
* This class manages the details of an Addressbook User.
* @author Jheanel Brown
* @version 1.0
*/
public class User
{
	private String firstN_user;
	private String lastN_user;
	private String passWord;
	private String addBookUsername;

	public User (String fName, String lName, String aBookUser, String pWord)
	{
		this.firstN_user = fName;
		this.lastN_user = lName;
		this.passWord = pWord;
		this.addBookUsername = aBookUser;
	}

	public User(String aBookUser, String pWord)
	{
		this.passWord = pWord;
		this.addBookUsername = aBookUser;	
	}

	public String toString()
	{
		return addBookUsername+";"+passWord ;
	}

	public String getUserFirstname()
	{
		return firstN_user;
	}

	public String getUserLastname()
	{
		return lastN_user.toUpperCase();
	}
}
