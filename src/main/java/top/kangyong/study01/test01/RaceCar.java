package top.kangyong.study01.test01;

/**
 * 交通工具
 */
abstract class Vehicle {

    public int speed() {
        return 0;
    }
}

class Car extends Vehicle{

    @Override
    public int speed() {
        return 60;
    }
}

/**
 * 跑车
 */
public class RaceCar extends Car{

    @Override
    public int speed() {
        return 150;
    }

    public static void main(String[] args) {
        System.out.println(new RaceCar().speed());
    }

}
