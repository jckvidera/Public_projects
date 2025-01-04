/**
 * @author John Carlos Kvidera CSC204X40
 * For my final project I made a password / passphrase catcher. it works by first creating a GUI for
 * the user to input their login information. After it's gathered the login information the program
 * decides if the password is too short, or too long, to then activate the class called failed login. 
 * Failed logins GUI looks very similar to the initial login page, but this GUI will time out after three 
 * tries, with the user failing to input the correct inputs. After three incorrect logins the GUI will go 
 * back to the login screens GUI, prompting the user to enter the correct credentials. If the user 
 * accidentally entered the wrong credentials and is prompted to the failed login GUI, they still 
 * have a chance to log in correctly, without restarting the program. If the user enters all credentials
 * correctly, they will move on to the final Landing GUI. Back in the login GUI,  if the user entered
 * all credentials correctly, then  hash check, and back end work,  will be activated. Back and does
 * a lot of the heavy lifting because it randomizes the password into a random set of  numbers and
 * characters, and it's where the user's hash is stored and saved to be checked against the original
 * hash. Hash check  comes next, and this is where the user's hash is checked against the store 
 * hash. Saved in the back end class, the user's name and unique hash gets saved, so when the 
 * user gets to the hash check stage, the program will remember if they logged in before or not. It 
 * is saved in a txt file, but could be expanded on to fit any business. if the user correctly enters 
 * their passphrase, and it aligns up with their hash, then they will move on to the final Landing 
 * screen. if not it will have an infant amount of tries to guess their passphrase. Since the
 * passphrase is a uniquely generated hash, it is very unlikely that someone would be able to
 * guess another person's special passphrase. Once the user gets to the final Landing screen, the
 * class called user info will generate a fake SSN, a fake ID code, and a fake email.  These will
 * also be displayed on the final Landing screen with the rest of the user's info. This program can
 * be adapted for employee logins on a much bigger scale than what I made. 
 */

import javax.swing.SwingUtilities;

public class passwordCatcher {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
         SwingUtilities.invokeLater(() -> new LoginScreen());
         }
      });
   }
}
