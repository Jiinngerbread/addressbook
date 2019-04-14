public class Authentication extends User implements Comparable<User>{
	private String username;
	private String password;
	private ArrayList<String> addressBookusers = new ArrayList<String>();
	private String[] eachLine;

	public Authentication(String userName, String passWord){
		
		this.username = userName;
		this.password = password;
		Authentication scam =new User(userN, pWord);	
	}

	public int  check(Authentication scam)
	{
		int result;
		for(User u: addressBookusers){
			if(u.compareTo(scam) == 0){
			result=  0;
			
			} else {
				result = 1;
			}
		}
		return result;
		
	}

	public PasswordFileManager(String filename)
	{
		try 
		{	
			FileReader fr = new FileReader("password.txt");
			BufferedReader br = new BufferedReader(fr);
			String oneLine = "";
			while ((oneLine = br.readLine()) != null)
				{
					//slit the line into tokens
					eachLine = oneLine.split(";");

					//convert where necessary
					String user = eachLine[0];
					String password = eachLine[1];
					User record_of_current_users = new User(user, password)
					addressBookusers.add(record_of_current_users)
					
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
		
			Authentication try = new Authentication(userN, passW);
		
			if(try.check() == 0)
			{
				numtries = 0;
				//Launch addressbook app
				
			} else
			{
				System.out.println("Username or password is incorrect, you have two more tries");
				numtries--1;
			}
	
		}
		System.out.println("You have exceeded your number of tries, Goodbye");
		System.exit(0);

	}


}
