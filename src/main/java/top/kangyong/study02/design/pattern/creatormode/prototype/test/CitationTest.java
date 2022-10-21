package top.kangyong.study02.design.pattern.creatormode.prototype.test;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/10/18
 * @since 1.0.0
 */
public class CitationTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建原型对象
        Citation citation = new Citation();
        Student stu = new Student();
        stu.setName("王丽丽");
        citation.setStu(stu);

        // 克隆奖状对象
        Citation citation1 = citation.clone();
        citation1.getStu().setName("巨梦洁");

        citation.show();
        citation1.show();

        System.out.println(citation.getStu());
        System.out.println(citation1.getStu());

        System.out.println(citation);
        System.out.println(citation1);

    }
}
