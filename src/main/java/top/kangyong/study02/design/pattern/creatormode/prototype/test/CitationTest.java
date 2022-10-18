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

        // 克隆奖状对象
        Citation citation1 = citation.clone();

        citation.setName("张三");
        citation1.setName("李子木");
        citation.show();
        citation1.show();

        System.out.println(citation);
        System.out.println(citation1);

    }
}
