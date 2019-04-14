import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
 
public class PasswordManager
{
    public byte[] generateSalt() 
    {
        //try
        //{
            SecureRandom realRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[8];
            realRandom.nextBytes(salt);
        
            return salt;     
        //} 

        /*catch(NoSuchAlgorithmException nsaEx) 
        {
            System.err.println("Exception occured in getEncryptedPassword()");
            return null;
        }*/
    }

    public byte[] getEncryptedPassword(String passWord, byte[] salt) //throws NoSuchAlgorithmException, InvalidKeySpecException 
    {
            
        String algorithm = "PBKDF2WithHmacSHA1";
        int derivedKeyLength = 160;
        int iterations = 20000;
        
        KeySpec spec = new PBEKeySpec(passWord.toCharArray(), salt, iterations, derivedKeyLength);
        
        //try 
        //{
            SecretKeyFactory secretKey = SecretKeyFactory.getInstance(algorithm);
            return secretKey.generateSecret(spec).getEncoded();
        //}

        /*catch(NoSuchAlgorithmException  nSAex) 
        {
            System.err.println("Exception occured in getEncryptedPassword()");
            return null;
        }

        catch(InvalidKeySpecException iKex) 
        {
            System.err.println("Exception occured in getEncryptedPassword()");
            return null;
        }*/
    }

    public boolean authenticationCheck(String attemptedPassword, byte[] encryptedPassword, byte[] salt) //throws NoSuchAlgorithmException, InvalidKeySpecException 
    {
        //try 
        //{
            byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
            return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);   
        //}

        /*catch(NoSuchAlgorithmException e) 
        {
            System.err.println("Exception occured in authenticationCheck()");
            return false;
        }

        catch(InvalidKeySpecException ikeyEx) 
        {
            System.err.println("Exception occured in getEncryptedPassword()");
            return false;
        }*/
    }
}