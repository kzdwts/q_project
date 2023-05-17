package top.kangyong.study02.listener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 监听Bean属性变化
 *
 * @author Kang Yong
 * @date 2023/5/17
 * @since 1.0.0
 */
public class BeanPropertyChangeEventListener {

    public static void main(String[] args) {
        Bean bean = new Bean();
        bean.addPropertyChangeListener(new MyPropertyChangeListener());

        bean.setProperty1("wanglili");
        bean.setProperty2(1);

        bean.setProperty1("lizimu");
        bean.setProperty2(2);
    }


    public static class MyPropertyChangeListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println("evt.getPropertyName() = " + evt.getPropertyName());

            System.out.println("evt.getOldValue() = " + evt.getOldValue());

            System.out.println("evt.getNewValue() = " + evt.getNewValue());

            System.out.println("*******************************************");
        }

    }

    public static class Bean {
        private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

        private String property1;
        private int property2;

        public String getProperty1() {
            return property1;
        }

        public void setProperty1(String property1) {
            pcs.firePropertyChange("property1", this.property1, property1);
            this.property1 = property1;
        }

        public int getProperty2() {
            return property2;
        }

        public void setProperty2(int property2) {
            pcs.firePropertyChange("property2", this.property2, property2);
            this.property2 = property2;
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            pcs.addPropertyChangeListener(listener);
        }

    }
}
