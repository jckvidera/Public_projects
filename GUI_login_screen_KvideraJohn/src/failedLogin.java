import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class failedLogin extends JFrame {
   private JTextField userText;
   private JPasswordField passwordText; 
   
   public int retryCount = 0; 
   public int MAX_RETRIES = 3; 
   
   public failedLogin() {
      setTitle("Failed Login");
      setSize(400,300); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      JPanel panel = new JPanel();
      panel.setLayout(null); 
      add(panel); 
      placeParts(panel); 
      setVisible(true);
      panel.setOpaque(true);
      //color
}
   public void placeParts(JPanel panel){
      
      JLabel welcomeMessage = new JLabel("WARNING! FAILED LOGIN:"); 
      welcomeMessage.setBounds(10,20, 300,15);
      welcomeMessage.setFont(new Font("Ariel",Font.BOLD, 13));
      welcomeMessage.setForeground(Color.RED); 
      panel.add(welcomeMessage); 
      
      JLabel userName = new JLabel("Enter your username: "); 
      userName.setBounds(10 ,70, 150, 25); 
      panel.add(userName);
      
      JTextField userText = new JTextField(20); 
      userText.setBounds(130,90,165,25); 
      panel.add(userText);
      
      JLabel passwordLabel = new JLabel("Enter your password: ");
      passwordLabel.setBounds(10, 115, 150, 25);
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
      
      loginButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            String special = passphraseText.getText(); 
     
            if(password.length()< 4 || password.length() >12 || username == null 
                  || password == null || special == null){
            retryCount++; 
            if(retryCount >= MAX_RETRIES) {
               JOptionPane.showMessageDialog(null, "Login failed 3 times. ERROR!"); 
               dispose(); 
               new LoginScreen(); 
            }else{
               String warning ="WARNING! FAILED LOGIN: "+ (MAX_RETRIES - retryCount) 
                     +" attempts left"; 
            welcomeMessage.setText(warning); 
            
            userText.setText("");
            passwordText.setText("");
            passphraseText.setText(""); 
            }
            }else {
               dispose(); 
               backendWork backend = new backendWork(username, password, special);
               new hashCheck(username, password, special);
            }
         }
      });
   }
}
