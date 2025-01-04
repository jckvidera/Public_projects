import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class hashCheck extends JFrame {
   private static final String HASH_FILE = "Username&Hash.txt";
   private static final String USER_FILE = "userFile.txt"; 
   private String username;
   private String password;
   private String special;
   
   
   public hashCheck(String username, String password, String special) {
      this.username = username;
      this.password = password;
      this.special = special;
      
      setTitle("Verify Identity");
      setSize(400,300); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      JPanel panel = new JPanel(); 
      panel.setLayout(null); 
      add(panel); 
      
      placeCheck(panel); 
      setVisible(true);
      panel.setOpaque(true);
   }
   public void placeCheck(JPanel panel) {
      
      JLabel idCheck = new JLabel("Please enter you passphrase");
      idCheck.setBounds(45,20,200,30);
      panel.add(idCheck); 
      
      JTextField userIDCheck = new JTextField(20);
      userIDCheck.setBounds(45,50,200,25); 
      panel.add(userIDCheck); 
      
      JButton idCheckButton = new JButton("Enter"); 
      idCheckButton.setBounds(10,220,80,25);
      panel.add(idCheckButton); 
      
      idCheckButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            String enteredPassphrase = userIDCheck.getText();
            if (isPassphraseCorrect(enteredPassphrase)) {
               dispose();
               new finalLandingPage(username, password, special);
            }else{
               JOptionPane.showMessageDialog(null, "Passphrase is incorrect.");
               userIDCheck.setText(""); 
            }
         }   
      });   
   }
   private boolean isPassphraseCorrect(String enteredPassphrase) {
      String storedHash = readStoredHash();
      if (storedHash == null) {
         return false;
      }
      String enteredHash = hashPassphrase(enteredPassphrase);
      //Great place to check if they are correct
      return storedHash.equals(enteredHash);
   }
   private String readStoredHash() {
      try (BufferedReader reader = new BufferedReader(new FileReader(HASH_FILE))) {
         String line;
         while ((line = reader.readLine()) != null) {
            if (line.startsWith("User Unique Hash = ")) {
               return line.substring("User Unique Hash = ".length()).trim();
            }
         }
      }catch (IOException e) {
         e.printStackTrace();
      }
      return null; 
   }
private String hashPassphrase(String passphrase) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(passphrase.getBytes());
        return Base64.getEncoder().encodeToString(hash); // Convert hash bytes to Base64 string
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("Error hashing passphrase", e);
    }
}
}

