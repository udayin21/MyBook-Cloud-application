package Azure_App;

import com.microsoft.azure.storage.table.*;


public class LoginEntity extends TableServiceEntity {
	 String userid;
	 String passcode;

    public LoginEntity(String userId, String password) {
        this.partitionKey = userId;
        this.rowKey = userId;
    }

    public LoginEntity() { }

   
    public String getUserId() {
        return userid;
    }

    public String getPassword() {
        return passcode;
    }
    
    public void setUserId(String userId) {
        userid = userId;
    }
    
    public void setPassword(String password) {
        passcode = password;
    }

}