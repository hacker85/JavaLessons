import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class HelloMongo {
    public static void main( String args[] ){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        db.createCollection("myCollection");
        MongoIterable<String> strings = db.listCollectionNames();
        for (String name : strings) {
            System.out.println(name);
        }
    }
}
