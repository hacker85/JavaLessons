package patterns.behavioral;

import java.io.File;
import java.nio.file.NoSuchFileException;

public class NullObjectPatter {
    public static void main(String[] args) {
        Animal animal = getAnimal();
        animal.eat();
    }

    static Animal getAnimal() {
        try {
            if(!new File("/hello/noSuchFile.txt").exists()) {
                throw new NoSuchFileException("no file");
            } else {
                return new Lion();
            }
        } finally {
            return new NoAnimal();
        }
    }
}

interface Animal {
    void eat();
}
class Lion implements Animal {
    public void eat() {
        System.out.println("lion ear");
    }
}
class NoAnimal implements Animal {
    public void eat() {}
}
