package Azure_App;

import com.microsoft.azure.storage.table.TableServiceEntity;


public class PersonalObjectEntity extends TableServiceEntity {
	 String userid;
	 String object;

    public PersonalObjectEntity(String userId,String obj) {
        this.partitionKey = userId;
        this.rowKey = obj;
    }

    public PersonalObjectEntity() { }

   
    public String getObject() {
        return object;
    }

    public void setObject(String obj) {
        object = obj;
    }
    
   
}