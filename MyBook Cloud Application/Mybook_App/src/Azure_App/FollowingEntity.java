package Azure_App;

import com.microsoft.azure.storage.table.TableServiceEntity;


public class FollowingEntity extends TableServiceEntity {
	 String userid;
	 String followings;

    public FollowingEntity(String userId,String following) {
        this.partitionKey = userId;
        this.rowKey = following;
    }

    public FollowingEntity() { }

   
    public String getFollower() {
        return followings;
    }

    public void setFollower(String follower) {
        followings = follower;
    }
    
   
}