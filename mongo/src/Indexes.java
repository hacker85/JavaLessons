import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class Indexes {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> users = db.getCollection("users");
        users.createIndex(new BasicDBObject("name",1).append("age", 1));
        users.createIndex(new BasicDBObject("name", "text"));
        DBObject search = new BasicDBObject("$search", "mytext");
        users.find(eq("$text", search));
    }
}
