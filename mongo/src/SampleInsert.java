import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class SampleInsert {
    public static void main( String args[] ){
        try{
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("test");
            MongoCollection<Document> coll = db.getCollection("users");
            Document doc = new Document("name", "Max").append("age", 25) .append("phone", "321-654-987");
            coll.insertOne(doc);
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
