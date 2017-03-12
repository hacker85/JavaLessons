package generics;

import java.util.ArrayList;
import java.util.List;

public class GenBeginLesson {
    public static void main(String[] args) {
        List list = new ArrayList();
//        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add("bla");
        for (int i = 0; i < list.size(); i++) {
            int j = (int)list.get(i);
            System.out.println(j);
        }

        NonGenericCell nonGenericCell = new NonGenericCell();
        nonGenericCell.setItem(new Money());
        Money money = (Money)nonGenericCell.getItem();

        GenericCell<Money> cell = new GenericCell<>();
        cell.setItem(new Money());
        Money money2 = cell.getItem();
    }
}

class Money {}

class NonGenericCell {
    Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}

class GenericCell<T> {
    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}