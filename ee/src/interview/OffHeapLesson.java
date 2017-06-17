package interview;

import sun.misc.Unsafe;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class OffHeapLesson {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.get(new byte[]{1,2,3});
        System.out.println(buffer.array());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.remaining());
        System.out.println(buffer.capacity());
        buffer.flip();
        System.out.println(buffer.array());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.remaining());
        System.out.println(buffer.capacity());
        buffer.clear();
        System.out.println("-------------");
        System.out.println(buffer.array());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.remaining());
        System.out.println(buffer.capacity());

        FileInputStream fis = new FileInputStream( "/home/max/temp.txt" );
        FileChannel fileChannel = fis.getChannel();
        int bytesRead = fileChannel.read(buffer);

//        Unsafe unsafe = Unsafe.getUnsafe();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        long startIndex = unsafe.allocateMemory(1024);
        System.out.println(startIndex);
        unsafe.putInt(startIndex , 5);
        unsafe.putInt(startIndex + 4, 10);
        System.out.println(unsafe.getInt(startIndex));
        System.out.println(unsafe.getByte(startIndex + 4));
//        Student student = (Student)unsafe.allocateInstance(Student.class);
//        student.name = "Max";
//        System.out.println(student.name);
//        System.out.println(student.age);
        unsafe.freeMemory(startIndex);
    }
    static class Student {
        String name;
        int age;

        public Student() {
            this.name = "Max";
            this.age = 22;
        }
    }
}
