package patterns.web;

public class CompositeEntityLesson {
    public static void main(String[] args) {
        CompositeEntity compositeEntity = new CompositeEntity();
        String[] data = compositeEntity.getData();
        for (String s : data) {
            System.out.println(s);
        }
    }
}

class DependentObject1 {
    public String getData() {
        return "one";
    }
}
class DependentObject2 {
    public String getData() {
        return "two";
    }
}
class CoarseGainedObject {
    DependentObject1 dependentObject1 = new DependentObject1();
    DependentObject2 dependentObject2 = new DependentObject2();

    String[] getData() {
        return new String[]{dependentObject1.getData(), dependentObject2.getData()};
    }
}

class CompositeEntity {
    CoarseGainedObject coarseGainedObject = new CoarseGainedObject();

    String[] getData() {
        return coarseGainedObject.getData();
    }
}
