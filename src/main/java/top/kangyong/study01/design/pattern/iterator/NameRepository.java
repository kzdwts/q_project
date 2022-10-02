package top.kangyong.study01.design.pattern.iterator;

/**
 * @author Kang Yong
 * @date 2022/10/1
 * @since 1.0.0
 */
public class NameRepository implements Container {

    private String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
