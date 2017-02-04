package network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WebDataLesson {
    public static void main(String[] args) throws IOException {
        URLConnection connection =  new URL("http://www.google.com/").openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\Z");
        System.out.println(scanner.next());

        Map<String,List<String>> headerFields = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

//        connection.setDoOutput(true);
//        try(PrintWriter out = new PrintWriter(connection.getOutputStream())) {
//            out.print("q" + "=" + URLEncoder.encode("test", "UTF-8"));
//        }


//        for (int i = 0; i < 100; i++) {
//            String value = connection.getHeaderField(i);
//            if(value == null) {
//                break;
//            } else {
//                System.out.println(value);
//            }
//        }

//        Map<String,List<String>> headerFields = connection.getHeaderFields();
//        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//            System.out.println(entry.getKey() + "/" + entry.getValue());
//        }

//        URLConnection connection = url.openConnection();
//        connection.setDoOutput(true);
//        connection.connect();
//        System.out.println(connection.getContentEncoding());
//        System.out.println(connection.getContentLength());
//        System.out.println(connection.getContentType());
//        System.out.println(connection.getContent());
//        System.out.println(connection.getDate());
//        System.out.println(connection.getExpiration());
//        System.out.println(connection.getLastModified());
//        Scanner scanner = new Scanner(connection.getInputStream());
//        if(scanner.hasNextLine()) {
//            System.out.println(scanner.nextLine());
//        }

    }
}
