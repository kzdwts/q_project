package top.kangyong.study01.code01;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 利润问题计算
 * @author: kangyong
 * @date: 2019/10/15 17:17
 * @version: v1.0
 */
public class Demo12GetProfit {

    public static void main(String[] args) {
        /*
        企业发放的奖金根据利润提成。
            利润(I)低于或等于10万元时，奖金可提10%；
            利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；
            20万到40万之间时，高于20万元的部分，可提成5%；
            40万到60万之间时高于40万元的部分，可提成3%；
            60万到100万之间时，高于60万元的部分，可提成1.5%，
            高于100万元时，超过100万元的部分按1%提成，
            从键盘输入当月利润，求应发放奖金总数
         */

        // 当月利润
        double profit = 0;
        // 奖金
        double bouns = 0;
        System.out.println("请输入当月利润：");
        Scanner sc = new Scanner(System.in);
        profit = sc.nextInt();
        sc.close();

        bouns = getBouns1(profit);


        System.out.println("奖金总额为：" + bouns);

    }

    /**
     * 计算提成方法一（累计）
     *
     * @param profit
     * @return
     */
    private static double getBouns1(double profit) {
        double bouns;// 计算提成
        if (profit <= 10) {
            bouns = profit * 0.10;
        } else if (profit < 20) {
            bouns = 10 * 0.10 + (profit - 10) * 0.075;
        } else if (profit < 40) {
            bouns = 10 * 0.10 + 10 * 0.075 + (profit - 20) * 0.050;
        } else if (profit < 60) {
            bouns = 10 * 0.10 + 10 * 0.075 + 20 * 0.050 + (profit - 40) * 0.030;
        } else if (profit < 100) {
            bouns = 10 * 0.10 + 10 * 0.075 + 20 * 0.050 + 20 * 0.030 + (profit - 60) * 0.015;
        } else {
            bouns = 10 * 0.10 + 10 * 0.075 + 20 * 0.050 + 20 * 0.030 + 40 * 0.015 + (profit - 100) * 0.010;
        }
        return bouns;
    }


}
