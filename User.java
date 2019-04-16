import java.util.*;

/**
* This class manages the details of an Addressbook User.
* @author Jheanel Brown && Esther E
* @version 1.0
*/
public class User 
{
	private  String password;
	private String username;
	
//This class should be able to write to a file
	public User (String userNAME, String passWORD) 
	{
		this.password = passWORD;
		this.username = userNAME;	

	}

	public String getUsername()
	{
		return this.username;
	}

	public String getpassword()
	{
		return this.password;
	}

	
	@Override
	public String toString()
	{
		return new StringBufferthis.username + ";" + this.password;
	}
}