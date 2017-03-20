package patterns.behavioral;

public class IteratorLesson {
    public static void main(String[] args) {
        ArrayContainer arrayContainer = new ArrayContainer();
        Iterator iterator = arrayContainer.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator iterator();
}

class ArrayContainer implements Container {
    String[] array = {"Max", "Jhon", "Mikhale"};

    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return (index < array.length) ? true : false;
        }

        @Override
        public Object next() {
            if(hasNext()) {
                return array[index++];
            }
            return null;
        }
    }
}