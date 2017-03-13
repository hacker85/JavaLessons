package generics;

public class GenNonGenCodeLesson {
    static void add(Cell cell) {
        cell.setT(new Integer(5));
    }
    public static void main(String[] args) {
        Cell<House> houseCell = new Cell<>();
        add(houseCell);
        House house = houseCell.getT();
    }
}

class House {}

class Cell<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}