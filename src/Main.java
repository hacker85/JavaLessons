public class Main {
    public static void main(String[] args) {
        Cell cell = new Cell();
    }
}

class Cell<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
