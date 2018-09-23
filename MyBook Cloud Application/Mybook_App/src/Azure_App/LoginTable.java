package Azure_App;
//Include the following imports to use table APIs
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;


public class LoginTable {
	
	public static final String storageConnectionString =
		    "DefaultEndpointsProtocol=http;" +
		    "AccountName=mynosqldatabase;" +
		    "AccountKey=yilddcyTncIv5EIf0GxAnDo68NBNxUNdY6OfkLQ02eWPUpCBzTjPFf4H5Mq/yoDy/gBEbWZ2x/lx62H2OWo9Lw==";
	
	public void insertEntry(String name,String password) {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		        CloudStorageAccount.parse(storageConnectionString);

		    // Create the table client.
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();

		    // Create a cloud table object for the table.
		    CloudTable cloudTable = tableClient.getTableReference("login");

		    // Create a new customer entity.
		    LoginEntity customer1 = new LoginEntity(name, password);
		    customer1.setUserId(name);
		    customer1.setPassword(password);
	
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
	
	public  boolean validEntryUserId(String userId,String password) {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		        CloudStorageAccount.parse(storageConnectionString);

		    // Create the table client.
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();

		    // Create a cloud table object for the table.
		    CloudTable cloudTable = tableClient.getTableReference("login");

		    // Retrieve the entity with partition key of "Smith" and row key of "Jeff"
		    TableOperation retrieval =
		        TableOperation.retrieve(userId,userId, LoginEntity.class);

		    // Submit the operation to the table service and get the specific entity.
		    LoginEntity specificEntity =
		        cloudTable.execute(retrieval).getResultAsType();

		    // Output the entity.
		    if (specificEntity != null)
		    {
		        if (password.equals(specificEntity.getPassword())){
		        		return true;
		        } else {
		        		return false;
		        }
		    } else {
		    	  return false;
		    }
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		    return false;
		}
		
	}
	
	
}
