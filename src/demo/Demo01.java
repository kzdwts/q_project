package demo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: StringBuffer和StringBuild比较
 * @author: kangyong
 * @date: 2019/6/21 10:57
 * @version: v1.0
 */
public class Demo01 {

    public static void main(String[] args) {

        String s1 = "";
        long startTime = System.currentTimeMillis();
        // 执行字符串拼接 String
        for (int i = 0; i < 100000; i++) {
//            s1 += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String字符串拼接所用时间：" + (endTime - startTime));
        System.out.println(s1);


        StringBuffer s2 = new StringBuffer();
        s1 = "";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s1 = "" + i;
            s2 = new StringBuffer(s1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("运行时间为：" + (endTime - startTime));

        StringBuilder sb = new StringBuilder();

    }

}
