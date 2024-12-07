import java.util.*;
import java.io.*;
import java.security.*;

public class Program10 {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        // Writing keys to file
        try (FileWriter writer = new FileWriter("P10Keys.txt")) {
            writer.write(Base64.getEncoder().encodeToString(publicKey.getEncoded()));
            writer.write("\n");
            writer.write(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        Scanner ReadIN = new Scanner(System.in);
        int UP = 3;
        String username;
        String password;
        UserLogin[] UPpairs = new UserLogin[UP];
        ArrayList<UserLogin> userList = new ArrayList<>();
        System.out.println("First enter 3 username and password pairs");

        // Collecting initial user data
        for (int i = 0; i < UP; i++) {
            username = ReadIN.nextLine();
            password = ReadIN.nextLine();

            UPpairs[i] = new UserLogin();
            UPpairs[i].setUsername(username);
            UPpairs[i].setPassword(UPpairs[i].CryptPassword(password, 1));
            userList.add(UPpairs[i]);

            // Save user data into file
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("username.ser"))) {
                out.writeObject(userList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Check if the username.ser file exists and load user data
        File userFile = new File("username.ser");

        System.out.println("Hello user! What is your Username?");
        username = ReadIN.nextLine();
        UserLogin existingUser = null;

        // Load existing users from the serialized file
        if (userFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userFile))) {
                userList = (ArrayList<UserLogin>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Verify if username exists
        for (UserLogin user : userList) {
            if (user.getUsername().equals(username)) {
                existingUser = user;
                break;
            }
        }

        if (existingUser != null) {
            // User exists, verify password
            System.out.print("Enter password: ");
            password = ReadIN.nextLine();
            boolean validPassword = false;
        
            for (UserLogin user : userList) {
                if (username.equals(user.getUsername())) {
                    try {
                        // Decrypt the stored password
                        String decryptedStoredPassword = user.CryptPassword(user.getPassword(), 0); // Decrypt stored password
        
                        // Compare the decrypted password with the entered password
                        if (decryptedStoredPassword.equals(password)) {
                            System.out.println("Successful login");
                            validPassword = true;
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        
            if (!validPassword) {
                System.out.println("Incorrect password");
            }
        
        } else {
            // User doesn't exist, create a new account
            System.out.println("User not found. Please create a new account.");
            System.out.print("Enter new password: ");
            String newPassword = ReadIN.nextLine();
            try {
                UserLogin newUser = new UserLogin();
                String encryptedPassword = newUser.CryptPassword(newPassword, 1);
                newUser.setPassword(encryptedPassword);
                newUser.setUsername(username);
                userList.add(newUser);

                // Save the new list to the username.ser file
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(userFile))) {
                    out.writeObject(userList);
                }

                System.out.println("Welcome to CS1050");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.print("Enter 'LIST' to view all users: ");
        String command = ReadIN.nextLine();
        if ("LIST".equals(command)) {
            try {
                for (UserLogin user : userList) {
                    String decryptedPassword = user.CryptPassword(user.getPassword(), 0); // Decrypt password to display
                    System.out.println(user.getUsername() + "   " + decryptedPassword);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ReadIN.close();
    }
}
