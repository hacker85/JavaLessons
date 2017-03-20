package patterns.web;

import java.util.Scanner;

public class FrontControllerLesson {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                new Thread() {
                    @Override
                    public void run() {
                        new DispatcherServlet().process(nextLine);
                    }
                }.start();
            }
        }
    }
}

class DispatcherServlet {
    void process(String path) {
        switch (path) {
            case "home" : new HomeController().show(); break;
            case "user" : new UserController().show(); break;
            default: new DefaultController().show();
        }
    }
}
class HomeController {
    void show() {
        System.out.println("home");
    }
}
class UserController {
    void show() {
        System.out.println("user");
    }
}
class DefaultController {
    void show() {
        System.out.println("error");
    }
}