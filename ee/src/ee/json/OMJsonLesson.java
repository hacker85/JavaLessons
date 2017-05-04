package ee.json;

import javax.json.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class OMJsonLesson {
    public static void main(String[] args) throws IOException {
        JsonObject jsonObject = new OMJsonLesson().getJson();
        JsonWriter writer = Json.createWriter(new FileWriter("Student.json"));
        writer.writeObject(jsonObject);
        writer.close();

        JsonReader jsonFromString = Json.createReader(new StringReader("{}"));

        JsonReader jsonReader = Json.createReader(new FileReader("Student.json"));
        JsonObject jsonObject1 = jsonReader.readObject();
        JsonObject student = jsonObject1.getJsonObject("Student");
        System.out.println(student.getString("name"));
        System.out.println(student.getInt("age"));
        JsonArray exams = student.getJsonArray("exams");
        List<JsonValue> valuesAs = exams.getValuesAs(JsonValue.class);
        for (JsonValue jsonValue : valuesAs) {
            System.out.println(jsonValue.toString());
        }
        System.out.println(student.getJsonObject("university").getString("name"));
    }

    private JsonObject getJson() {
        return Json.createObjectBuilder().add("Student", Json.createObjectBuilder()
                .add("name", "Max")
                .add("age", 22)
                .add("exams", Json.createArrayBuilder().add("math").add("english").add("chemistry"))
                .add("university", Json.createObjectBuilder().add("name", "Stanford"))
        ).build();
    }
}
