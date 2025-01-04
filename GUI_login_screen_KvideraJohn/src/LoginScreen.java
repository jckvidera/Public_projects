import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
   private JTextField userText;
   private JPasswordField passwordText; 
   
   public LoginScreen(){
      setTitle("Login Screen");
      setSize(400,300); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      //Panel to hold components 
      JPanel panel = new JPanel(); 
      panel.setLayout(null); 
      add(panel); 
      
      placeComponents(panel); 
      setVisible(true);
      panel.setOpaque(true);
      panel.setBackground(Color.LIGHT_GRAY); 
   }
   public void placeComponents(JPanel panel) {
      
      JLabel welcomeMessage = new JLabel("Welcome! Enter you User Name and Password:"); 
      welcomeMessage.setBounds(45,20,400,15);
      welcomeMessage.setFont(new Font("Ariel", Font.BOLD, 13));
      panel.add(welcomeMessage);
      
      //label for username
      JLabel userName = new JLabel("Enter your username: "); 
      userName.setBounds(10 ,70, 150, 25); 
      panel.add(userName); 
      
      
      //text field
      JTextField userText = new JTextField(20); 
      userText.setBounds(130,90,165,25); 
      panel.add(userText); 
      
      
      // creates the password 
      JLabel passwordLabel = new JLabel("Enter your password (4 to 12 characters):");
      passwordLabel.setBounds(10, 115, 300, 25);
      panel.add(passwordLabel);
      
      
      passwordText = new JPasswordField(20); 
      passwordText.setBounds(130,135,165, 25); 
      panel.add(passwordText); 
      
      JLabel passphrase = new JLabel("Enter you passphrase: "); 
      passphrase.setBounds(10,160,150,25); 
      panel.add(passphrase); 
      
      JTextField passphraseText = new JTextField(20); 
      passphraseText.setBounds(130,180,164,25);
      panel.add(passphraseText); 
      
      JButton loginButton = new JButton("Login"); 
      loginButton.setBounds(10,220,80,25);
      panel.add(loginButton); 
      
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String username = userText.getText(); 
            String password = new String(passwordText.getPassword()); 
            String special = passphraseText.getText(); 
            
            if(password.length() < 4 || password.length() > 12 || username==null ||
                  password == null|| special == null){
               dispose(); 
               
               new failedLogin();
            }else{
               try{
                  backendWork backend = new backendWork(username, password, special);
                  dispose(); 
                  new hashCheck(username, password, special);
                  
               }catch(IllegalArgumentException ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage());
                  dispose();
                  new failedLogin();
               }
         }
         }
      }); 
   }
   
}





