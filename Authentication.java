import java.lang.*;
import java.util.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Authentication extends User implements Comparable<User>{
	private String checkUser;
	private ArrayList<String> addressBookusers = new ArrayList<String>();
	private String[] eachLine;

	
	public Authentication(String userName, String pWord)
	{
		super(userName, pWord);
		Authentication(this.checkUser) =new User(userName, pWord);
	}

	public void getPasswordFromFile()
	{
		try 
		{	
			//String filename = super.getUsername() + "_password.txt";
			//FileReader fr = new FileReader(filename);
			FileReader fr = new FileReader("Password.txt");
			BufferedReader br = new BufferedReader(fr);
			String oneLine = "";
			while ((oneLine = br.readLine()) != null)
			{
				//slit the line into tokens
				eachLine = oneLine.split(";");

				//convert where necessary
				String user = eachLine[0];
				String password = eachLine[1];
				User record_of_current_users = new User(user, password);
				addressBookusers.add(record_of_current_users);
			}
		}
		catch(IOException error)
		{
			System.out.println("An error has occured.");
		}

		catch(NumberFormatException hasTobeNumError)
		{
			System.out.println("NOTE: the input has to be a number.");
		}
	}


	public int  compareTo(User checkUser)
	{
		int result;
		for(User u: addressBookusers){
			if(u == checkUser)
			{
				result =  0;
			
			} else {
				result =  1;
			}
		}
		return result;
	}

	public boolean securityCheck(User checkUser)
	{
		for(User u: addressBookusers)
		{
			if(u.compareTo(checkUser)== 0)
			{
				return true;
			}
			else
			{
				System.out.println("Incorrect username and password combination");
				return false;
			}
		}
	}



	public static void main(String[] args)
	{
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("|                                        Welcome!                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                        Please input your Username then Password                                     |");
		System.out.println("|                             NOTE: Both are case sensitive!                                          |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("|                                                                                                     |");
		System.out.println("_____________________________________________________________________________________________________");
		
		int numtries=3;
		while(numtries!=0) 
		{
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Username:");
			userN = sc.nextLine();
			System.out.println("Password:");
			passW = sc.nextLine();
		
			Authentication test = new User(userN, passW);
			test.getPasswordFromFile();
		
			if(securityCheck(test) == true)
			{
				numtries = 0;
				System.out.println("Awesome, lets go to your Addressbook!");
				//Launch addressbook app
				
			} else
			{
				System.out.println("Username or password is incorrect, you have two more tries");
				System.out.println("You have " + numtries + " left.");
				numtries-=1;
			}
	
		}
		System.out.println("You have exceeded your number of tries, Goodbye");
		System.exit(0);

	}


}
