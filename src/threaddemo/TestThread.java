package threaddemo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/5/7 10:41
 * @version: v1.0
 */
public class TestThread {

    public static void main(String[] args) {
//        RunnableDemo r1 = new RunnableDemo("Thread-11");
//        r1.start();
//
//        RunnableDemo r2 = new RunnableDemo("Thread-22");
//        r2.start();

        ThreadDemo t1 = new ThreadDemo("Thread-1");
        t1.start();

        ThreadDemo t2 = new ThreadDemo("Thread-2");
        t2.start();
    }

}
