package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketLesson {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8189);
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream())) {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            //printWriter.println("bla");
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                System.out.println(str);
                printWriter.println("you've send: " + str);
                if(str.equals("exit")) {
                    break;
                }
            }
        }
    }
}
