package test01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/5/17 16:27
 * @version: v1.0
 */
public class ReviewDemo {
    public static void main(String[] args) {
        Square s = new Square(5);
        s.show();// 25, 20

        Cirle c = new Cirle(4);
        c.show();//
    }
}

abstract class Method {
    abstract double mul();

    abstract double divid();

     void show() {
        System.out.println("面积是：" + mul());
        System.out.println("面积是：" + divid());
    }
}

class Square extends Method {

    double d;

    public Square(double d) {
        super();
        this.d = d;
    }

    @Override
    double mul() {
        return d * d;
    }

    @Override
    double divid() {
        return 4 * d;
    }

    @Override
    void show() {

    }
}

class Cirle extends Method {

    double r;

    public Cirle(double r) {
        super();
        this.r = r;
    }

    @Override
    double mul() {
        return 2 * 3.14 * r * r;
    }

    @Override
    double divid() {
        return 3.14 * r * r;
    }
}