package Azure_App;

import com.microsoft.azure.storage.table.TableServiceEntity;

	public class MessageEntity extends TableServiceEntity {
		 String userid;
		 String followings;

	    public MessageEntity(String userId,String message) {
	        this.partitionKey = userId;
	        this.rowKey = message;
	    }

	    public MessageEntity() { }

	   
	    public String getMessage() {
	        return followings;
	    }

	    public void setMessage(String message) {
	        followings = message;
	    }
	    
	   
	}
