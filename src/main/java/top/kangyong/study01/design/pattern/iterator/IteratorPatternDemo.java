package top.kangyong.study01.design.pattern.iterator;

/**
 * 迭代器模式
 *
 * @author Kang Yong
 * @date 2022/10/2
 * @since 1.0.0
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.println("Name: " + name);
        }
    }

}
