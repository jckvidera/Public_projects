
/**
 *
 * @author johnkvidera
 */
public class UserInfo {
   private String ssn; 
   private String IDCode; 
   private String email; 
   
   public UserInfo(String ssn, String IDCode, String email) {
      this.ssn = ssn; 
      this.IDCode = IDCode; 
      this.email = email; 
   }
   public String getSsn(){
      return ssn; 
   }
   public String getidCode() {
      return IDCode; 
   }
   public String getEmail() {
      return email; 
   }
   public String toString() {
      return ssn + IDCode + email; 
   }
}
