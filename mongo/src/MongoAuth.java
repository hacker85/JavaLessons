import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
import java.util.List;

public class MongoAuth {
    public static void main( String args[] ){
        MongoCredential credential = MongoCredential.createPlainCredential("root", "test", "1".toCharArray());
        List<MongoCredential> mongoCredentials = Arrays.asList(credential);
        ServerAddress serverAddress = new ServerAddress("localhosst", 27017);
        MongoClient mongoClient = new MongoClient(serverAddress, mongoCredentials);
        MongoDatabase db = mongoClient.getDatabase("test");;
        System.out.println("Successfully connected to MongoDB");
    }
}
