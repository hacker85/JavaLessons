package patterns.structural;

public class BridgeLesson {
    public static void main(String[] args) {
        ICar car = new ToyotaCar(new CarBridge());
        car.drive();

        ICar track = new ToyotaTrack(new TrackBridge());
        track.drive();
    }
}

abstract class ICar {
    IBridge iBridge;

    public ICar(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract void drive();
}
abstract class ITrack {
    IBridge iBridge;

    public ITrack(IBridge iBridge) {
        this.iBridge = iBridge;
    }
    abstract void drive();
}

interface IBridge {
    void drive();
}

class CarBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("drive car");
    }
}
class TrackBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("drive track");
    }
}


class ToyotaCar extends ICar {
    public ToyotaCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive toyota");
    }
}

class AudiCar extends ICar {
    public AudiCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive audi");
    }
}

class ToyotaTrack extends ICar {
    public ToyotaTrack(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive toyota");
    }
}

class TrackCar extends ICar {
    public TrackCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive audi");
    }
}