package bestpractice;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//don't run alien methods on sync blocks, it can cause exceptions, deadlocks, or data corruption
//you should do as little work as possible inside synchronized regions
public class AvoidExcessiveSync {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<Integer>(new HashSet<Integer>());
        set.addObserver(new SetObserver<Integer>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 20) {
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    final SetObserver<Integer> observer = this;
                    try {
                        executor.submit(new Runnable() {
                            public void run() {
                                s.removeObserver(observer);
                            }
                        }).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex.getCause());
                    } finally {
                        executor.shutdown();
                    }
                }
            }
        });
        for (int i = 0; i < 100; i++)
            set.add(i);
    }
}
class ObservableSet<E> extends HashSet<E> {
    public ObservableSet(Set<E> set) { super(set); }
    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();
    public synchronized void addObserver(SetObserver<E> observer) {
        observers.add(observer);
    }
    public synchronized boolean removeObserver(SetObserver<E> observer) {
        return observers.remove(observer);
    }
    private void notifyElementAdded(E element) {
        for (SetObserver<E> observer : observers)
            observer.added(this, element);
    }
    @Override public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }
    @Override public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element);
        return result;
    }
}
interface SetObserver<E> {
    void added(ObservableSet<E> set, E element);
}

//                if (e == 20) s.removeObserver(this);
//                if (e == 20) {
//                    ExecutorService executor = Executors.newSingleThreadExecutor();
//                    final SetObserver<Integer> observer = this;
//                    try {
//                        executor.submit(new Runnable() {
//                            public void run() {
//                                s.removeObserver(observer);
//                            }
//                        }).get();
//                    } catch (ExecutionException | InterruptedException ex) {
//                        throw new AssertionError(ex.getCause());
//                    } finally {
//                        executor.shutdown();
//                    }
//                }

//    List<SetObserver<E>> snapshot = null;
//synchronized(observers) {
//        snapshot = new ArrayList<>(observers);
//        }
//        for (SetObserver<E> observer : snapshot)
//        observer.added(this, element);