package ee.json;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.io.*;
import java.util.Scanner;

public class StreamJsonLesson {
    public static void main(String[] args) throws IOException {
        StringWriter stringWriter = new StreamJsonLesson().getJsonWriter();
        FileWriter fileWriter = new FileWriter("StudentStream.json");
        fileWriter.write(stringWriter.toString());
        fileWriter.close();

        Scanner scanner = new Scanner(new FileReader("StudentStream.json"));
        StringBuffer stringBuffer = new StringBuffer();
        while (scanner.hasNext()) {
            stringBuffer.append(scanner.next());
        }

        StringReader stringReader = new StringReader(stringBuffer.toString());
//        StringReader stringReader = new StringReader("{" +
//                "  \"Student\": {" +
//                "    \"name\" : \"Max\"," +
//                "    \"age\" : 22," +
//                "    \"exams\" : [\"math\", \"english\", \"chemistry\"]," +
//                "    \"university\" : {" +
//                "      \"name\" : \"Stanford\"" +
//                "    }" +
//                "  }" +
//                "}");
//        JsonParser jsonParser = Json.createParser(stringReader);
        JsonParser jsonParser = Json.createParser(new FileReader("StudentStream.json"));
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
//            System.out.println(event.name());
            if(event.equals(JsonParser.Event.KEY_NAME) || event.equals(JsonParser.Event.VALUE_STRING) || event.equals(JsonParser.Event.VALUE_NUMBER)) {
                System.out.println(jsonParser.getString());
            }
        }


    }
    private StringWriter getJsonWriter() {
        StringWriter stringWriter = new StringWriter();
        JsonGenerator generator = Json.createGenerator(stringWriter);
        generator.writeStartObject()
                .writeStartObject("Student")
                .write("name", "Max")
                .write("age", 22)
                .writeStartArray("exams")
                    .write("math")
                    .write("english")
                    .write("chemistry")
                .writeEnd()
                .writeStartObject("university")
                    .write("name", "Stanford")
                .writeEnd()
                .writeEnd()
                .writeEnd()
                .close();
        return stringWriter;
    }
}
