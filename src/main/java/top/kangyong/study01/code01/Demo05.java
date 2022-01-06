package top.kangyong.study01.code01;

/**
 * Created with IntelliJ IDEA.
 * Description: 条件嵌套
 * User: kangyong
 * Date: 2018/12/20 20:51
 */
public class Demo05 {

    public static void main(String[] args) {
        /*
        利用条件运算符的嵌套来完成此题：
        学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
         */
        Demo05 demo05 = new Demo05();
        // demo05.test1((int) (Math.random() * 100));
        demo05.test2((int) (Math.random() * 100));
    }

    /**
     * if-else-if判断
     *
     * @param score
     */
    public void test1(float score) {
        System.out.println("分数：" + score);
        // 判断
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 60) {
            System.out.println("B");
        } else if (score < 60) {
            System.out.println("C");
        }
    }

    /**
     * 三目运算符
     *
     * @param score
     */
    public void test2(float score) {
        System.out.println("分数：" + score);
        char rank = score >= 90 ? 'A' : score >= 60 ? 'B' : 'C';
        System.out.println(rank);
    }
}
