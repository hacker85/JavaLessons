package patterns.behavioral;

public class VisotorLesson {
    public static void main(String[] args) {
        IAnimal animal = new Dog();
        animal.doJob(new ConcreteVisitor());
        new Cat().doJob(new ConcreteVisitor());
    }
}
interface IAnimal {
    void doJob(Visitor visitor);
}

class Dog implements IAnimal {
    @Override
    public void doJob(Visitor visitor) {
        visitor.JobForDog();
    }
}

class Cat implements IAnimal {
    @Override
    public void doJob(Visitor visitor) {
        visitor.JobForCat();
    }
}

interface Visitor {
    void JobForDog();
    void JobForCat();
}

class ConcreteVisitor implements Visitor {
    @Override
    public void JobForDog() {
        System.out.println("dog");
    }

    @Override
    public void JobForCat() {
        System.out.println("cat");
    }
}