package interview;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class ReferencesLesson {
    public static void main(String[] args) throws InterruptedException {
        MyObject o = new MyObject();
        SoftReference<MyObject> softReference = new SoftReference<>(o);
        WeakReference<MyObject> weakReference = new WeakReference<>(o);
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference = new PhantomReference<>(o, referenceQueue);
        WeakHashMap weakHashMap = new WeakHashMap();
        o = null;
        System.out.println(softReference.get());
        System.out.println(weakReference.get());
        System.out.println(phantomReference.get());
        System.gc();
        System.out.println("-------------");
        System.out.println(softReference.get());
        System.out.println(weakReference.get());
        System.out.println(phantomReference.get());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        System.gc();
        System.out.println("-------------");
        System.out.println(softReference.get());
        System.out.println(weakReference.get());
        System.out.println(phantomReference.get());

//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    referenceQueue.remove();
//                    System.out.println("reference was removed");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//        System.out.println("start gc");
//        System.gc();
//        System.out.println("gc was started");
    }
    static class MyObject {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Object was finalized");
        }
    }
}
