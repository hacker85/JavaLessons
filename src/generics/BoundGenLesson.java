package generics;

import java.io.Serializable;

public class BoundGenLesson {
    public static void main(String[] args) {
        Gen<Job> gen = new Gen<>();
        //Gen<Parent2> gen2 = new Gen<>();
        Gen<Chld> gen3 = new Gen<>();
//        Gen<Job> gen5 = new Gen<Child>();
//        Gen<Job, FileReader> gen = new Gen<>();
        gen.doJob(new Job());

        Parcel<Gift, String, Integer> parcel = new Parcel<>();
    }
}

class Parent2 {}
class Job extends Parent implements Serializable {
    void doit() {
        System.out.println("do job");
    }
}
class Chld extends Job {}

class Gen<T extends Job> {
//class Gen<T extends Job, X> {
//class Gen<T extends Job, Serializable extends Reader> {
//class Gen<T extends Job & Serializable> {
//class Gen<T extends Serializable> {
    void doJob(T t) {
        t.doit();
    }
}


interface Wrappable{}
interface Exchangeable{}
class Gift{}
class Parcel <T extends Gift, Exchangeable, Wrappable>{}