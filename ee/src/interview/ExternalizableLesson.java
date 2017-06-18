package interview;

import java.io.*;

public class ExternalizableLesson {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("temp.txt")));
        house.writeExternal(objectOutputStream);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("temp.txt")));
        House house2 = new House();
        house2.readExternal(objectInputStream);
        System.out.println(house2.rooms);
    }
    static class House implements Externalizable {
        int rooms = 5;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(rooms);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.rooms = in.readInt();
        }
    }
}