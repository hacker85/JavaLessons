package solid;

public class InterfaceSegregationPrincipleLesson {
    public static void main(String[] args) {
    }
}
//Clients should not be forced to depend upon interfaces that they don't use.
interface IWorker {
    public void work();
    public void eat();
}
class Worker implements IWorker{
    public void work() {
        // ....working
    }
    public void eat() {
        // ...... eating in launch break
    }
}
class SuperWorker implements IWorker{
    public void work() {
        //.... working much more
    }
    public void eat() {
        //.... eating in launch break
    }
}
class Manager {
    IWorker worker;
    public void setWorker(IWorker w) {
        worker=w;
    }
    public void manage() {
        worker.work();
    }
}


//interface IWorker extends Feedable, Workable {}
//interface IWorkable {
//    public void work();
//}
//interface IFeedable{
//    public void eat();
//}
//class Worker implements IWorkable, IFeedable{
//    public void work() {
//        // ....working
//    }
//    public void eat() {
//        //.... eating in launch break
//    }
//}
//class Robot implements IWorkable{
//    public void work() {
//        // ....working
//    }
//}
//class SuperWorker implements IWorkable, IFeedable{
//    public void work() {
//        //.... working much more
//    }
//    public void eat() {
//        //.... eating in launch break
//    }
//}
//class Manager {
//    Workable worker;
//    public void setWorker(Workable w) {
//        worker=w;
//    }
//    public void manage() {
//        worker.work();
//    }
//}
