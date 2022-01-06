package top.kangyong.study01.test01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2019/5/10 9:57
 * @version: v1.0
 */
public class Demo01 {

    public static void main(String[] args) {
        byte b = 1;
        Byte bb = new Byte(b);
        b = bb;

        short s = 1;
        Short ss = new Short(s);
        s = ss;

        int i = 100;
        Integer ii = new Integer(i);
        i = ii;

        long l = 9;
        Long ll = new Long(l);
        l = ll;

        float f = 23.55f;
        Float ff = new Float(f);
        f = ff;

        double d = 12.88;
        Double dd = new Double(d);
        d = dd;

        boolean bo = true;
        Boolean boo = new Boolean(bo);
        bo = boo;

        char ch = '1';
        Character cha = new Character(ch);
        ch = cha;

        String numStr = "23";
        int i1 = Integer.parseInt(numStr);
        String str = String.valueOf(i1);
//        Demo02 demo02 = new Demo02();

//        Person p = new Child();
    }

}
