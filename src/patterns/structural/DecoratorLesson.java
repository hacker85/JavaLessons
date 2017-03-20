package patterns.structural;

public class DecoratorLesson {
    public static void main(String[] args) {
        FileStream fileStream = new FileBufferedReader(new FileStreamReader());
        fileStream.read();
    }
}

interface FileStream {
    void read();
}
class FileStreamReader implements FileStream {
    @Override
    public void read() {
        System.out.println("read file");
    }
}

abstract class FileDecorator implements FileStream {
    FileStream fileDecorator;

    public FileDecorator(FileStream fileDecorator) {
        this.fileDecorator = fileDecorator;
    }

    public abstract void read();
}

class FileBufferedReader extends FileDecorator {
    public FileBufferedReader(FileStream fileDecorator) {
        super(fileDecorator);
    }

    @Override
    public void read() {
        fileDecorator.read();
        System.out.println("buffered read");
    }
}