package Azure_App;
//Include the following imports to use table APIs
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;


public class PersonalInfoTable {
	
	public static final String storageConnectionString =
		    "DefaultEndpointsProtocol=http;" +
		    "AccountName=mynosqldatabase;" +
		    "AccountKey=yilddcyTncIv5EIf0GxAnDo68NBNxUNdY6OfkLQ02eWPUpCBzTjPFf4H5Mq/yoDy/gBEbWZ2x/lx62H2OWo9Lw==";
	
	public  void insertInfo(String name,String email,String mobile) {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		        CloudStorageAccount.parse(storageConnectionString);

		    // Create the table client.
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();

		    // Create a cloud table object for the table.
		    CloudTable cloudTable = tableClient.getTableReference("personalinfo");

		    // Create a new customer entity.
		    PersonalInfoEntity customer1 = new PersonalInfoEntity(name);
		    customer1.setEmailId(email);
		    customer1.setMobile(mobile);
	
		    // Create an operation to add the new customer to the people table.
		    TableOperation insertCustomer1 = TableOperation.insertOrReplace(customer1);

		    // Submit the operation to the table service.
		    cloudTable.execute(insertCustomer1);
		    
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		}
	}
	
	public  String getEmail(String userId) {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		        CloudStorageAccount.parse(storageConnectionString);

		    // Create the table client.
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();

		    // Create a cloud table object for the table.
		    CloudTable cloudTable = tableClient.getTableReference("personalinfo");

		    // Retrieve the entity with partition key of "Smith" and row key of "Jeff"
		    TableOperation retrieval =
		        TableOperation.retrieve(userId,userId, PersonalInfoEntity.class);

		    // Submit the operation to the table service and get the specific entity.
		    PersonalInfoEntity specificEntity =
		        cloudTable.execute(retrieval).getResultAsType();

		    // Output the entity.
		    if (specificEntity != null)
		    {
		        return specificEntity.getEmailId() ;  
		    }
		    else {
		    	    return "";
		    }
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		    return "";
		}
		
	}
	
	public String getMobile(String userId) {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		        CloudStorageAccount.parse(storageConnectionString);

		    // Create the table client.
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();

		    // Create a cloud table object for the table.
		    CloudTable cloudTable = tableClient.getTableReference("personalinfo");

		    // Retrieve the entity with partition key of "Smith" and row key of "Jeff"
		    TableOperation retrieval =
		        TableOperation.retrieve(userId,userId, PersonalInfoEntity.class);

		    // Submit the operation to the table service and get the specific entity.
		    PersonalInfoEntity specificEntity =
		        cloudTable.execute(retrieval).getResultAsType();

		    // Output the entity.
		    if (specificEntity != null)
		    {
		        return specificEntity.getMobile(); 
		    }
		    else {
		    	    return "";
		    }
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		    return "";
		}
		
	}
	
	
}
