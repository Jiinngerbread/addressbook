import java.util.*;


public class TesterOfUser
{
  public static void main(String [] args)
  {
  	User user1 = new User("Jheanel", "Brown", "female", "19940312", "Jinn", "Pencil12Case");
  	System.out.println("This is the name of the user: " + user1.getName());
  	System.out.println("This is the first name of the user: " + user1.getUserFirstname());
  	System.out.println("This is the last name of the user: " + user1.getUserLastname());
  	System.out.println("This is the username of the user: " + user1.getUsername());
  	System.out.println("This is the password of the user in byte code: " + user1.getpassword());
  	String s = new String(user1.getpassword());
  	System.out.println("This is the password of the user from byte code to string: " + s);

  	
  	User user2 = new User("Brandon", "Lumsden", "male", "19900918", "BrandonBest", "123Passcode546");
  	System.out.println("This is the name of the user: " + user2.getName());
  	System.out.println("This is the first name of the user: " + user2.getUserFirstname());
  	System.out.println("This is the last name of the user: " + user2.getUserLastname());
  	System.out.println("This is the username of the user: " + user2.getUsername());
  	System.out.println("This is the password of the user in byte code: " + user2.getpassword());
  	String ns = new String(user2.getpassword());
  	System.out.println("This is the password of the user from byte code to string: " + ns);

  }
}
