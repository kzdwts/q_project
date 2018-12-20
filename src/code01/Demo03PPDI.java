package code01;

/**
 * Created with IntelliJ IDEA.
 * Description: 水仙花数
 * User: kangyong
 * Date: 2018/12/18 21:01
 */
public class Demo03PPDI extends Object{

    public static void main(String[] args) {
        /*
        打印出所有的 "水仙花数 "，
        所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
        例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方
         */
        new Demo03PPDI().test1();
    }

    /**
     * 打印水仙花数
     */
    public void test1() {
        int count = 0;
        // 在区间范围遍历
        for (int i = 100; i < 999; i++) {
            // 位数
            int gw = i % 10;
            int sw = i / 10 % 10;
            int bw = i / 100;
            // 判断是否符合条件
            if (i == (Math.pow(gw, 3) + Math.pow(sw, 3) + Math.pow(bw, 3))){
                count++;
                System.out.println(i);
            }
        }
        System.out.println("共有水仙花数：" + count);
    }
}
