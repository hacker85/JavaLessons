import com.mongodb.MongoClient;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class BulkInsert {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> users = db.getCollection("users");

        List<WriteModel<Document>> documents = new ArrayList<>();
        documents.add(new InsertOneModel<>(new Document("name", "Den").append("age", 33)));
        documents.add(new InsertOneModel<>(new Document("name", "Yen").append("age", 44)));

        BulkWriteResult bulkWriteResult = users.bulkWrite(documents);
        System.out.println(bulkWriteResult.getMatchedCount());
    }
}
