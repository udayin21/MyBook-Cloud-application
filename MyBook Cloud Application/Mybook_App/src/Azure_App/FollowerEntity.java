package Azure_App;

import com.microsoft.azure.storage.table.TableServiceEntity;


public class FollowerEntity extends TableServiceEntity {
	 String userid;
	 String followers;

    public FollowerEntity(String userId,String follower) {
        this.partitionKey = userId;
        this.rowKey = follower;
    }

    public FollowerEntity() { }

   
    public String getFollower() {
        return followers;
    }

    public void setFollower(String follower) {
        followers = follower;
    }
    
   
}