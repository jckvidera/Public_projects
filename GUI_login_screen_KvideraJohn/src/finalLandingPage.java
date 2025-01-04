import javax.swing.*; 
import java.awt.*; 

public class finalLandingPage extends JFrame {
   private String username; 
   private String password; 
   private String special; 
   
   public finalLandingPage(String username, String password, String special){
      this.username = username;
      this.password = password; 
      this.special = special; 
      
      
      
      setTitle("Landing page"); 
      setSize(400,300); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      JPanel panel = new JPanel();
      panel.setLayout(null);
      add(panel); 
      landingPage(panel);
      setVisible(true);
      panel.setOpaque(true);
      panel.setBackground(Color.LIGHT_GRAY);
   }
   public void landingPage(JPanel panel){
      JLabel welcomeMessage = new JLabel("Welcome! Here is your info!"); 
      welcomeMessage.setBounds(10,20,400,15);
      welcomeMessage.setFont(new Font("Ariel", Font.BOLD, 13));
      panel.add(welcomeMessage);
      
      JLabel userFullName = new JLabel(username + " Information"); 
      userFullName.setBounds(10,40,300,25);
      panel.add(userFullName); 
      
      
      JLabel usersName = new JLabel("Name: "+ username); 
      usersName.setBounds(10,60,300,25); 
      panel.add(usersName); 
      
      JLabel userPass = new JLabel("Password: " + password); 
      userPass.setBounds(10,80,300,25);
      panel.add(userPass); 
      
      JLabel userPassphrase = new JLabel("Passphrase: " + special); 
      userPassphrase.setBounds(10,100,300,25);
      panel.add(userPassphrase); 
      
      UserInfo userInfo = backendWork.otherInfo(username);
      
      JLabel ssnLabel = new JLabel("SSN: "+ userInfo.getSsn());
      ssnLabel.setBounds(10,120,300,25);
      panel.add(ssnLabel); 
      
      JLabel idCodeLabel = new JLabel("ID Code: "+ userInfo.getidCode());
      idCodeLabel.setBounds(10,140,300,25); 
      panel.add(idCodeLabel); 
      
      JLabel emailLabel = new JLabel("Email: " + userInfo.getEmail()); 
      emailLabel.setBounds(10,160,300,25); 
      panel.add(emailLabel); 
   }

}

