package solid;

public class SingleResponsibilityLesson {
    public static void main(String[] args) {

    }
}

//Single responsibility
//A class should have only one reason to change
class Employee {
    void cook() {}
    void deliverFood() {}
    void cleanFloor() {}
}
class Chef {
    void cook(){}
}
class Waiter {
    void deliverFood() {}
}
class JanitorEmployee {
    void cleanFloor() {}
}
//-----------------------
class Employe {
    int getPay() {return 100;}
}
class ChefEmp extends Employe {
    void cook() {}
}
//------------
interface Emp {
    int getPay();
}
class WaiterEmp implements Emp {
    @Override
    public int getPay() {
        return 100;
    }
    void deliverFood() {
        System.out.println("deliver food");
    }
}
//--------------------------------
//facade
class ChefEmployee {
    void cook() {}
}
class WaiterEmployee {
    void deliverFood() {}
}
class Facade {
    ChefEmployee chefEmployee = new ChefEmployee();
    WaiterEmployee waiterEmployee = new WaiterEmployee();
    void cook() {
        chefEmployee.cook();
    }
    void deliverFood() {
        waiterEmployee.deliverFood();
    }
}