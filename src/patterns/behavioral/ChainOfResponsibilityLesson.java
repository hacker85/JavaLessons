package patterns.behavioral;

public class ChainOfResponsibilityLesson {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();
        messagePrinter.setNexMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNexMessagePrinter(new DbMessagePrinter());
        messagePrinter.print("hello");
    }
}

abstract class MessagePrinter {
    MessagePrinter nexMessagePrinter;
    void setNexMessagePrinter(MessagePrinter messagePrinter) {
        nexMessagePrinter = messagePrinter;
    }
    void print(String message) {
        printMessage(message);
        if(nexMessagePrinter != null) {
            nexMessagePrinter.print(message);
        }
    }
    abstract void printMessage(String message);
}

class ConsoleMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("print to console: " + message);
    }
}

class FileMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("print to file: " + message);
    }
}

class DbMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("print to db: " + message);
    }
}