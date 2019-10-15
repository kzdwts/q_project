package code01;

/**
 * Created with IntelliJ IDEA.
 * Description: 小球落地
 * User: kangyong
 * Date: 2018/12/29 17:54
 */
public class Demo10Falling {

    public static void main(String[] args) {
        /*
        一球从100米高度自由落下，每次落地后反跳回原高度的一半；
        再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
         */

        // 高度
        double height = 100;
        // 路程
        double totalS = 0;

        for (int i = 1; i <= 10; i++) {
            totalS += height;
            height = height / 2;
        }

        System.out.println("共经过 " + totalS + " m");
        System.out.println("第10次反弹 " + height + "m");
    }
}
