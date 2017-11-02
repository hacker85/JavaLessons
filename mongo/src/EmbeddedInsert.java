import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class EmbeddedInsert {
    public static void main( String args[] ){
        try{
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("test");
            MongoCollection<Document> coll = db.getCollection("users");
            Document doc = new Document("name", "louis").append("age", 29).append("info",
                    new Document("email", "louis@mail.com").append("phone", "876-134-667"));
            coll.insertOne(doc);
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
