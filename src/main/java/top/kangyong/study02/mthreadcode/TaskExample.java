package top.kangyong.study02.mthreadcode;

/**
 * 任务
 *
 * @author Kang Yong
 * @date 2023/3/30
 * @since 1.0.0
 */
public class TaskExample implements Runnable {

    private String name;

    public TaskExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is running in " + Thread.currentThread().getName());
    }
}
