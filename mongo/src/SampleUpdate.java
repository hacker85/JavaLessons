import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class SampleUpdate {
    public static void main( String args[] ){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> coll = db.getCollection("users");
        coll.updateOne(eq("name", "max"), new Document("$set", new Document("age", 50)));
        UpdateResult updateResult = coll.updateMany(eq("name", "john"), new Document("$set", new Document("age", 50)));
        System.out.println(updateResult.getModifiedCount());
    }
}
