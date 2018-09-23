package Azure_App;
import java.io.File;
import java.io.FileInputStream;

//Include the following imports to use table APIs
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;


public class PersonalObjectTable {
	
	public static final String storageConnectionString =
		    "DefaultEndpointsProtocol=http;" +
		    "AccountName=mynosqldatabase;" +
		    "AccountKey=yilddcyTncIv5EIf0GxAnDo68NBNxUNdY6OfkLQ02eWPUpCBzTjPFf4H5Mq/yoDy/gBEbWZ2x/lx62H2OWo9Lw==";
	
	public void createContainer(String name) {
		try
		{
		    CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
		    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
		    CloudBlobContainer container = blobClient.getContainerReference(name);
		    container.createIfNotExists();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
	}
	
	
	public void insertObject(String user, String object, String objectpath) {
		try
		{
		    CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
		    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
		    CloudBlobContainer container = blobClient.getContainerReference(user);
		    CloudBlockBlob blob = container.getBlockBlobReference(object);
		    File source = new File(objectpath);
		    blob.upload(new FileInputStream(source), source.length());
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
	}
	
	public  String[] getObjects(String userId) {
		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

		    // Create the blob client.
		    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

		    // Retrieve reference to a previously created container.
		    CloudBlobContainer container = blobClient.getContainerReference(userId);

		    // Loop over blobs within the container and output the URI to each of them.
		    if (container!=null) {
		    //	String objs = userId+" : ";
		    	int count = 0;	
		    	for (ListBlobItem blobItem : container.listBlobs()) {
			        count+=1;
			    }
		    	String objs[]=new String[count];
		    	int i=0;
		    	for (ListBlobItem blobItem : container.listBlobs()) {
			        objs[i]= blobItem.getUri().toString();
			        i++;
			    }
		    	return objs;
		    } else {
		    	String objs[]=new String[0];
		    		return objs;
		    }   
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		    String objs[]=new String[0];
    		return objs;
		}
	}
	

	
//	public static void main(String args[]) {
//		//insertObject("hello","obj");
//		//insertObject("hello","obj1");
//		//insertObject("hello","ney");
////		for (PersonalObjectEntity entity : getObject("hello")) {
////	        System.out.println(entity.getObject());
////	        }
////	createContainer("bip");
////		insertObject("bip","myimage","/Users/Udayin/Desktop/me.png");
////		getObjects("bip");
//	}
	
}
