import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
 
public class Password extends PasswordManager
{
	private byte[] encryptedPassword;
	private byte[] uniqueSalt;

    public Password(String pWord) throws NoSuchAlgorithmException
    {
        this.uniqueSalt = generateSalt();
    	this.encryptedPassword = getEncryptedPassword(pWord, uniqueSalt); 
    }

    public byte[] getPassword()
    {
    	return encryptedPassword;
    }

    public byte[] getUniqueSalt()
    {
    	return uniqueSalt;
    }
}