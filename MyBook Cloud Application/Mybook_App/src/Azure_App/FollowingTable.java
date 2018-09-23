package Azure_App;
//Include the following imports to use table APIs
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;
import com.microsoft.azure.storage.table.TableQuery.QueryComparisons;


public class FollowingTable {
	
	public static final String storageConnectionString =
		    "DefaultEndpointsProtocol=http;" +
		    "AccountName=mynosqldatabase;" +
		    "AccountKey=yilddcyTncIv5EIf0GxAnDo68NBNxUNdY6OfkLQ02eWPUpCBzTjPFf4H5Mq/yoDy/gBEbWZ2x/lx62H2OWo9Lw==";
	
	public static void insertFollowing(String name,String following) {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		        CloudStorageAccount.parse(storageConnectionString);

		    // Create the table client.
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();

		    // Create a cloud table object for the table.
		    CloudTable cloudTable = tableClient.getTableReference("following");

		    // Create a new customer entity.
		    FollowerEntity customer1 = new FollowerEntity(name,following);
		    customer1.setFollower(following);
		    
	
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
	
	public static Iterable<FollowingEntity> getFollowings(String userId) {
			try
			{
			    // Define constants for filters.
			    final String PARTITION_KEY = "PartitionKey";

			    // Retrieve storage account from connection-string.
			    CloudStorageAccount storageAccount =
			        CloudStorageAccount.parse(storageConnectionString);

			    // Create the table client.
			    CloudTableClient tableClient = storageAccount.createCloudTableClient();

			    // Create a cloud table object for the table.
			    CloudTable cloudTable = tableClient.getTableReference("following");

			    // Create a filter condition where the partition key is "Smith".
			    String partitionFilter = TableQuery.generateFilterCondition(
			        PARTITION_KEY,
			        QueryComparisons.EQUAL,
			        userId);

			    // Specify a partition query, using "Smith" as the partition key filter.
			    TableQuery<FollowingEntity> partitionQuery =
			        TableQuery.from(FollowingEntity.class)
			        .where(partitionFilter);
			    
			    Iterable<FollowingEntity> specificEntities =
				        cloudTable.execute(partitionQuery);
			    return specificEntities;

			}
			catch (Exception e)
			{
			    // Output the stack trace.
			    e.printStackTrace();
			    Iterable<FollowingEntity> f=null ;
			    return f;
			}
	}
	

	
//	public static void main(String args[]) {
//		//insertObject("hello","obj");
//		//insertObject("hello","obj1");
//		//insertObject("hello","ney");
//		for (PersonalObjectEntity entity : getObject("hello")) {
//	        System.out.println(entity.getObject());
//	        }
//	}
	
}
