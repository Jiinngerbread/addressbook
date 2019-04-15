import java.util.*;
import java.io.Serializable;

/**
* This class manages the details of an Addressbook User.
* @author Jheanel Brown && Esther E
* @version 1.0
*/
public class User //implements Serializable
{
	private  String password;
	private String username;
	private static final long serialVersionUID = 1L;

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