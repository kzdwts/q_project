package top.kangyong.study01.code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 乒乓球比赛
 * @author: kangyong
 * @date: 2019/11/1 16:51
 * @version: v1.0
 */
public class Demo18PingPongGame {

    public static void main(String[] args) {
        /*
        两个乒乓球队进行比赛，各出三人。
            甲队为a,b,c三人，
            乙队为x,y,z三人。
        已抽签决定比赛名单。有人向队员打听比赛的名单。
            a说他不和x比，
            c说他不和x,z比，
        请编程序找出三队赛手的名单。
         */

        char[] first = {'a', 'b', 'c',};
        char[] second = {'x', 'y', 'z'};

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if ((first[i] == 'a' && second[j] == 'x') || (first[i] == 'a' && second[j] == 'y')) {
                    // 退出本轮循环
                    continue;
                }
                if (first[i] == 'c' && (second[j] == 'x' || second[j] == 'z')) {
                    continue;
                }

                System.out.println(first[i] + "-->" + second[j]);
                break;
            }
        }


    }
}
