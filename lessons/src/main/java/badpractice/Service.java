package badpractice;

import javax.swing.text.Document;

public class Service {
    //reduce dependencies
    User user;
    int age;

    //simple constructor
    Service(User user, int age) {
        this.user = user;
        this.age = age;
    }

    //least knowladge
    void LogIn(User user) {
        this.user = user;
    }

    //global state & singleton
    void execute() {
        Singleton singleton = Singleton.get();
        user.exec();
    }

    //don't use static methods
    static String getInfo() {
        return User.getInfo();
    }

    //use polimorphism over big test cases
    public void printDocument(Document document) {
//        switch (document.getDocumentType()) {
//            case Documents.WORD_DOCUMENT: printWORDDocument(); break;
//            case Documents.PDF_DOCUMENT: printPDFDocument(); break;
//            case Documents.TEXT_DOCUMENT: printTextDocument(); break;
//        }
    }
}
