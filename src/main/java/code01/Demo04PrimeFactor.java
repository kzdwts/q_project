package code01;

/**
 * Created with IntelliJ IDEA.
 * Description: 分解质因数
 * User: kangyong
 * Date: 2018/12/20 19:43
 * 执行速度
 * StringBuilder → StringBuffer → String
 */
public class Demo04PrimeFactor {

    public static void main(String[] args) {
        /**
         * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
         */
        Demo04PrimeFactor d = new Demo04PrimeFactor();
        d.prime1((int) (Math.random() * 100));
        d.prime2((int) (Math.random() * 100));
    }

    /**
     * 分解质因数
     *
     * @param prime
     */
    public void prime1(Integer prime) {
        // 定义一个最小的质因数
        int k = 2;
        // 拼接字符串
        StringBuilder sb = new StringBuilder(prime + "=");
        //
        while (k <= prime) {
            if (k == prime) {
                sb.append(k);
                break;
            } else if (prime % k == 0) {
                sb.append(k + "*");
                prime = prime / k;
            } else {
                k++;
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * 分解质因数
     *
     * @param prime
     */
    public void prime2(Integer prime) {
        /*
        1、这个数是否是素数，能否被分解
        2、继续被当前除数分解
        3、分解到什么位置
         */
        // 拼接字符串
        StringBuilder sb = new StringBuilder(prime + "=");

        // 判断是否是素数
        if (Demo02Prime.isPrime(prime)) {
            // 是素数
            sb.append("1*" + prime);
        } else {
            // 当前不是素数
            for (int k = 2; k <= prime; ) {
                if (Demo02Prime.isPrime(prime)) {
                    // 不能分解
                    sb.append(prime);
                    break;
                } else if (prime % k == 0) {
                    // 能分解
                    sb.append(k + "*");
                    prime = prime / k;
                } else {
                    // 能分解，但是需要+1
                    k++;
                }
            }
        }
        // 输出
        System.out.println(sb.toString());
    }
}
