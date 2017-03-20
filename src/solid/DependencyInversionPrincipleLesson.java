package solid;

public class DependencyInversionPrincipleLesson {
    public static void main(String[] args) {

    }
}

//High-level modules should not depend on low-level modules. Both should depend on abstractions.
//Abstractions should not depend on details. Details should depend on abstractions.

class Worker2 {
    public void work() {
        // ....working
    }
}
class Manager2 {
    Worker2 worker;
    public void setWorker(Worker2 w) {
        worker = w;
    }
    public void manage() {
        worker.work();
    }
}
class SuperWorker2 {
    public void work() {
        //.... working much more
    }
}





interface IWorker3 {
    public void work();
}
class Worker3 implements IWorker3{
    public void work() {
        // ....working
    }
}
class SuperWorker3  implements IWorker3 {
    public void work() {
        //.... working much more
    }
}
class Manager3 {
    IWorker3 worker;
    public void setWorker(IWorker3 w) {
        worker = w;
    }
    public void manage() {
        worker.work();
    }
}