

public class Authentication
{
	private String username;
	private String password;
	private ArrayList<String> addressBookusers = new ArrayList<String>();
	private String[] eachLine;

	public Authentication(String userName, String passWord)
	{
		this.username = userName;
		this.password = password;
	}

	public boolean check(String userN, String pWord)
	{
		
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

		Scanner sc = new Scanner(System.in);
		System.out.println("Username:");
		userN = sc.nextLine();
		System.out.println("Password:");
		passW = sc.nextLine();

	}


}
