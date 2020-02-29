package test01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/11/7 17:42
 * @version: v1.0
 */
public class Animal implements Cloneable {

    public Cat cat;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


