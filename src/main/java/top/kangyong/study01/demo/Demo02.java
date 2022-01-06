package top.kangyong.study01.demo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/7/3 11:14
 * @version: v1.0
 */
public class Demo02 {

    /**
     * 编写一个程序，
     * 这个程序把一个整数数组中的每个元素用逗号连接成一个字符串，
     * 例如，根据内容为{1，2，3}的数组形成内容为"1,2,3"的字符串。
     */
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());

        Math.random();
    }



}
