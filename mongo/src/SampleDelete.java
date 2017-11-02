import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class SampleDelete {
    public static void main( String args[] ){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> users = db.getCollection("users");
        users.deleteOne(eq("name", "max"));
        DeleteResult deleteResult = users.deleteMany(eq("name", "max"));
        System.out.println(deleteResult.getDeletedCount());
        users.drop();
    }
}
