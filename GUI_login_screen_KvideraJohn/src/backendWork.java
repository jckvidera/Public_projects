import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.Base64;

public class backendWork {
   private String username; 
   private String password; 
   private String special; 
   private static final String FIRST_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy";
   private static final String SECOND_CHARACTERS = "z0123456789!@#$%^&*"; 
   private static final String CHARACTERS = FIRST_CHARACTERS + SECOND_CHARACTERS; 
   private static final SecureRandom RANDOM=  new SecureRandom();
   private static final String HASH_FILE = "Username&Hash.txt";
   private static final String USER_FILE ="userFile.txt"; 
   
   public backendWork(String username, String password, String special) {
      this.username = username; 
      if(password.length() >=4 && password.length() <=12){
         this.password = generateRandomPassword(password.length());
      }else {
         throw new IllegalArgumentException("Invalid password length."); 
      }
      this.special = hashPassphrase(special); 
   }
   
   private void storeUserInfo() {
      String outputFile = "userFile.txt";  
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
         writer.write("User Name = " + username + " ."); 
         writer.newLine(); 
         writer.write("User Unique Hash = ["+ special + " ]"); 
         writer.newLine();
         writer.write("UserPassword" + password + " .");
         writer.newLine();
      }catch(IOException e){
         e.printStackTrace();
      }
   }
   public String getPassword(){
      return password; 
   }
   public String getSpecial(){
      return special; 
   }
   public static String generateRandomPassword(int length){
      StringBuilder password = new StringBuilder(length); 
      for (int i = 0; i< length; i++){
         password.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
      }
      return password.toString();
   }
   private String hashPassphrase(String passphrase){
      try {
         MessageDigest md = MessageDigest.getInstance("SHA-256"); 
         byte[] hash = md.digest(passphrase.getBytes());
         return Base64.getEncoder().encodeToString(hash); 
      }catch (NoSuchAlgorithmException e) {
         throw new RuntimeException("Error hashing passphrase", e); 
      }
   }
   private void storeHash() {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(HASH_FILE, true))) {
         writer.write("User Name = " + username);
         writer.newLine();
         writer.write("User Unique Hash = " + special);
         writer.newLine();
      }catch (IOException e) {
         e.printStackTrace();
      }
      
   }
   public static UserInfo otherInfo(String username){
      String userNameWithoutSpace = username.replace(" ", ""); 
      String ssn = generateRandomDigits(7); 
      String IDCode = generateRandomDigits(8); 
      String email = userNameWithoutSpace.toLowerCase() + "@gmail.com"; 
      
      return new UserInfo(ssn,IDCode,email); 
   }
   private static String generateRandomDigits(int length) {
      StringBuilder digits = new StringBuilder(length); 
      for(int i = 0; i< length; i++){
         digits.append(RANDOM.nextInt(10)); 
      }
      return digits.toString(); 
   }
}

