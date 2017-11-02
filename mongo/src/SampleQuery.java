import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class SampleQuery {
    public static void main( String args[] ){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> coll = db.getCollection("users");
        System.out.println(coll.count());

        MongoCursor<Document> cursor = coll.find().iterator();
//        MongoCursor<Document> cursor1 = coll.find().skip(100).limit(5).iterator();
//        MongoCursor<Document> cursor2 = coll.find(eq("name", "john")).iterator();
//        MongoCursor<Document> cursor3 = coll.find(and(gt("age", 20), lte("age", 40))).iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            System.out.println(doc.toJson());
        }
    }
}
