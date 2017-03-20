package patterns.web;

public class MVCLesson {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.execute();
    }
}

class Controller {
    DBLayer dbLayer = new DBLayerImpl();
    View view = new ViewImpl();
    void execute() {
        Student model = dbLayer.getModel();
        view.print(model);
    }
}
interface View {
    void print(Student model);
}
class ViewImpl implements View {
    public void print(Student model) {
        System.out.println("name: " + model.getName() + " age: " + model.getAge());
    }
}
interface DBLayer {
    Student getModel();
}
class DBLayerImpl implements DBLayer {
    public Student getModel() {
        return new Student();
    }
}

class Student {
    String name = "Max";
    int age = 20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
