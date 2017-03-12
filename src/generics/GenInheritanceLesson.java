package generics;

public class GenInheritanceLesson {
    public static void main(String[] args) {
        Child child = new Child();
        GenericCellParrent<String> child2 = new Child();
        child.setItem("hello");
        Object o = child.getItem();
        System.out.println(o);

        Child6 child6 = new Child6();
        GenericCellParrent<Integer> child62 = new GenericCellParrent<Integer>();
        child6.setItem(5);
        int i = (Integer) child6.getItem();
        System.out.println(i);
    }
}

class Parent {

}

class GenericCellParrent<T> extends Parent {
    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

class Child extends GenericCellParrent {}

class Child2<T> extends GenericCellParrent<T> {}
//class Child3<X> extends GenericCellParrent<T> {}
class Child3<X, T> extends GenericCellParrent<T> {}
class Child4<T, X> extends GenericCellParrent<T> {}
class Child5<T, X> extends GenericCellParrent {}
class Child6<T> extends GenericCellParrent<String> {}

class GenParent<T,E> {}
class GenChild extends GenParent {}
class GenChild2<T> extends GenParent<T,String> {}



interface GenericInterface<T> {
    T getT();
}
class MyGenericIn implements GenericInterface {
    @Override
    public Object getT() {
        return null;
    }
}
class MyGenericIn2 implements GenericInterface<String> {
    @Override
    public String getT() {
        return null;
    }
}
class MyGenericIn3<T> implements GenericInterface<T> {
    @Override
    public T getT() {
        return null;
    }
}