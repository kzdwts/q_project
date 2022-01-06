package top.kangyong.study01.code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 猴子吃桃问题
 * @author: kangyong
 * @date: 2019/10/23 15:42
 * @version: v1.0
 */
public class Demo17MonkeyEatPeach {

    public static void main(String[] args) {
        /*
        猴子吃桃问题：
            猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
            第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
            以后每天早上都吃了前一天剩下的一半零一个。
            到第10天早上想再吃时，见只剩下一个桃子了。
            求第一天共摘了多少。
         */

        int totalNum = 0;
        int lastNum = 1;

        for (int i = 10; i >= 1; i--) {
            System.out.println("第" + i + "天，剩" + lastNum + "个桃子");
            totalNum += lastNum;
            lastNum = (lastNum + 1) * 2;
        }

        System.out.println("共有桃子" + totalNum);
    }
}
