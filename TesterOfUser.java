import java.util.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class TesterOfUser
{
  public static void main(String [] args) throws NoSuchAlgorithmException
  {
  	User user1 = new User("Jheanel", "Brown", Gender.FEMALE, 19940312, "Jinn", "Pencil12Case");
  	System.out.println("This is the name of the user: " + user1.getName());
  	System.out.println("This is the first name of the user: " + user1.getUserFirstname());
  	System.out.println("This is the last name of the user: " + user1.getUserLastname());
  	System.out.println("This is the username of the user: " + user1.getUsername());
    System.out.println();
  	System.out.println("This is the password of the user in byte code: " + user1.getpassword());
    System.out.println("This is the salt for the user in byte code: " + user1.getSalt());
  	//String s = new String(user1.getpassword());
    /*String s = new String(String.valueOf(user1.getpassword()));
  	System.out.println("This is the password of the user from byte code to string: " + s);
    System.out.println();
    boolean result = user1.getpassword().authenticationCheck("Pencil12Case", user1.getpassword(), user1.getSalt());
  	System.out.println("This is the result when the password is the same : " + result);
    System.out.println();
    boolean result1 = user1.authenticationCheck("Pencil13Case", user1.getpassword(), user1.getSalt());
    System.out.println("This is the result when the password is different : " + result1);*/
    

  	/*User user2 = new User("Brandon", "Lumsden", Gender.MALE, 19900918, "BrandonBest", "123Passcode546");
  	System.out.println("This is the name of the user: " + user2.getName());
  	System.out.println("This is the first name of the user: " + user2.getUserFirstname());
  	System.out.println("This is the last name of the user: " + user2.getUserLastname());
  	System.out.println("This is the username of the user: " + user2.getUsername());
  	System.out.println("This is the password of the user in byte code: " + user2.getpassword());
  	//String ns = new String(user2.getpassword());
    String ns = new String(String.valueOf(user2.getpassword()));
  	System.out.println("This is the password of the user from byte code to string: " + ns);*/

  }
}
