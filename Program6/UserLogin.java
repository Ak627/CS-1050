import java.io.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import javax.crypto.Cipher;

public class UserLogin implements Serializable {
    private String username;
    private String password;

    // Default constructor
    public UserLogin() {
        username = "";
        password = "";
    }

    // Setters and Getters
    public void setUsername(String u) {
        username = u;
    }

    public void setPassword(String p) {
        password = p;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Method to encrypt or decrypt password using RSA
    public String CryptPassword(String s, int x) throws Exception {
        // Load RSA keys from the file
        File keyFile = new File("P10Keys.txt");
        Scanner scanner = new Scanner(keyFile);
    
        String publicKeyString = scanner.nextLine();
        String privateKeyString = scanner.nextLine();
    
        // Decode the Base64-encoded keys
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
    
        // Reconstruct the public and private keys
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
    
        scanner.close();
    
        // Initialize cipher with RSA/ECB/PKCS1Padding
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    
        if (x == 1) { // Encrypt
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
    
            // Encrypt the data
            byte[] dataToEncrypt = s.getBytes();
            if (dataToEncrypt.length > 245) { // RSA encryption limit for 2048-bit key
                throw new IllegalArgumentException("Data too large for RSA encryption.");
            }
    
            byte[] encryptedBytes = cipher.doFinal(dataToEncrypt);
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } else if (x == 0) { // Decrypt
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
    
            // Decode the Base64-encoded encrypted data
            byte[] encryptedData = Base64.getDecoder().decode(s);
    
            // Ensure the encrypted data size is valid for RSA decryption
            if (encryptedData.length > 256) {
                throw new IllegalArgumentException("Encrypted data is too large for RSA decryption.");
            }
    
            byte[] decryptedBytes = cipher.doFinal(encryptedData);
            return new String(decryptedBytes);  // Return as plaintext password (decrypted)
        }
    
        return null;
    }
    
}
