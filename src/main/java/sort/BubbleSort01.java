package sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 冒泡排序
 * @author: kangyong
 * @date: 2019/4/8 10:51
 * @version: v1.0
 */
public class BubbleSort01 {

    public static void main(String[] args) {
        int nums[] = {4, 2, 6, 8, 0, 1, 9, 7, 5, 3};

        // 排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换位置
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        // 输出
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
