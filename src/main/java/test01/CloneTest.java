package test01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/12/2 16:02
 * @version: v1.0
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Animal a = new Animal();
        a.cat = new Cat();
        Animal aa = (Animal) a.clone();
        System.out.println("Animal:" + (a == aa));
        System.out.println("cat:" + (a.cat == aa.cat));

    }

}
