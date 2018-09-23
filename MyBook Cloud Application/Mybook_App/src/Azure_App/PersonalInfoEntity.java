package Azure_App;
import com.microsoft.azure.storage.table.*;


public class PersonalInfoEntity extends TableServiceEntity {
	 String userid;
	 String email;
	 String mobile;

    public PersonalInfoEntity(String userId) {
        this.partitionKey = userId;
        this.rowKey = userId;
    }

    public PersonalInfoEntity() { }

   
    public String getEmailId() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
    
    public void setEmailId(String emailId) {
        email = emailId;
    }
    
    public void setMobile(String mobiles) {
        mobile = mobiles;
    }
}