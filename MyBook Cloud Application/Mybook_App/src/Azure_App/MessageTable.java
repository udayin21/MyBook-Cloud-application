package Azure_App;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;
import com.microsoft.azure.storage.table.TableQuery;
import com.microsoft.azure.storage.table.TableQuery.QueryComparisons;

public class MessageTable {
	public static final String storageConnectionString =
		    "DefaultEndpointsProtocol=http;" +
		    "AccountName=mynosqldatabase;" +
		    "AccountKey=yilddcyTncIv5EIf0GxAnDo68NBNxUNdY6OfkLQ02eWPUpCBzTjPFf4H5Mq/yoDy/gBEbWZ2x/lx62H2OWo9Lw==";
	
	public void insertMessage(String name,String message) {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		        CloudStorageAccount.parse(storageConnectionString);

		    // Create the table client.
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();

		    // Create a cloud table object for the table.
		    CloudTable cloudTable = tableClient.getTableReference("messages");

		    // Create a new customer entity.
		    MessageEntity customer1 = new MessageEntity(name,message);
		    customer1.setMessage(message);
		    
	
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
	
	public String[] getMessages(String userId) {
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
			    CloudTable cloudTable = tableClient.getTableReference("messages");

			    // Create a filter condition where the partition key is "Smith".
			    String partitionFilter = TableQuery.generateFilterCondition(
			        PARTITION_KEY,
			        QueryComparisons.EQUAL,
			        userId);

			    // Specify a partition query, using "Smith" as the partition key filter.
			    TableQuery<MessageEntity> partitionQuery =
			        TableQuery.from(MessageEntity.class)
			        .where(partitionFilter);
			    
			    Iterable<MessageEntity> specificEntities =
				        cloudTable.execute(partitionQuery);
			    
			    int count= 0;
			    for (MessageEntity entity : specificEntities) {
//			        System.out.println(entity.getObject());
			    	count+=1;
			        }
			    String message[]=new String[count];
			    int i=0;
			    for (MessageEntity entity : specificEntities) {
			    	    message[i]=entity.getMessage();
			    	    i++;
			        }
			    return message;

			}
			catch (Exception e)
			{
			    // Output the stack trace.
			    e.printStackTrace();
			    String[] mt= new String[0];
			    return mt;
			}
	}
	
}
