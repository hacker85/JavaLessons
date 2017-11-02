import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArrayInsert {
    public static void main(String args[]) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("test");
            MongoCollection<Document> coll = db.getCollection("users");
            List<Document> documents = new ArrayList<Document>();
            for (int i = 0; i < 10; i++) {
                documents.add(new Document("key", UUID.randomUUID().toString()));
            }
            coll.insertMany(documents);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " +
                    e.getMessage());
        }
    }
}
