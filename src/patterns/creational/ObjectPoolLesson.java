package patterns.creational;

import java.util.ArrayList;
import java.util.List;

public class ObjectPoolLesson {
    public static void main(String[] args) {
        ObjectPool objectPool = new ObjectPool();
        PooledObject pooledObject = objectPool.getObject();
        objectPool.releaseObject(pooledObject);
    }
}

class PooledObject {}

class ObjectPool {
    List<PooledObject> free = new ArrayList<>();
    List<PooledObject> used = new ArrayList<>();

    public PooledObject getObject() {
        if(free.isEmpty()) {
            PooledObject pooledObject = new PooledObject();
            free.add(pooledObject);
            return pooledObject;
        } else {
            PooledObject pooledObject = free.get(0);
            used.add(pooledObject);
            free.remove(pooledObject);
            return pooledObject;
        }
    }
    public void releaseObject(PooledObject pooledObject) {
        used.remove(pooledObject);
        free.add(pooledObject);
    }

}
