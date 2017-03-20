package patterns.structural;

import java.util.ArrayList;
import java.util.List;

public class FilterLesson {
    public static void main(String[] args) {
        CarF carF = new CarF(150, "green", 2);
        CarF carF2 = new CarF(200, "red", 2);
        CarF carF3 = new CarF(250, "black", 4);
        List<CarF> cars = new ArrayList<>();
        cars.add(carF);
        cars.add(carF2);
        cars.add(carF3);
//        cars = new SpeedFilter().filter(cars);
//        cars = new DorsFilter().filter(cars);
        OrFilter andFilter = new OrFilter(new SpeedFilter(), new DorsFilter());
        cars = andFilter.filter(cars);
        for (CarF car : cars) {
            System.out.println(car.getMaxSpeed());
        }

    }
}

interface CarFilter {
    List<CarF> filter(List<CarF> cars);
}

class SpeedFilter implements CarFilter {
    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();
        for(CarF car : cars) {
            if(car.getMaxSpeed() > 180) {
                list.add(car);
            }
        }
        return list;
    }
}
class DorsFilter implements CarFilter {
    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();
        for(CarF car : cars) {
            if(car.getDors() > 2) {
                list.add(car);
            }
        }
        return list;
    }
}

class AndFilter implements CarFilter {
    CarFilter filterOne;
    CarFilter filterTwo;

    public AndFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = filterOne.filter(cars);
        return filterTwo.filter(list);
    }
}

class OrFilter implements CarFilter {
    CarFilter filterOne;
    CarFilter filterTwo;

    public OrFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = filterOne.filter(cars);
        List<CarF> list2 = filterTwo.filter(cars);
        for (CarF car : list2) {
            if(!list.contains(car)){
                list.add(car);
            }
        }
        return list;
    }
}


class CarF {
    public CarF(int maxSpeed, String color, int dors) {
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.dors = dors;
    }

    private int maxSpeed;
    private String color;
    private int dors;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDors() {
        return dors;
    }

    public void setDors(int dors) {
        this.dors = dors;
    }
}