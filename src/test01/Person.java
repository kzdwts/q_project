package test01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/5/16 16:46
 * @version: v1.0
 */
public abstract class Person {

    private String name;

    int age;

    protected int height;

    public int len;

    abstract void eat();

    public void speak() {
        System.out.println("Hello");
    }
}
