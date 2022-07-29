package top.kangyong.study01.design.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式
 *
 * @author Kang Yong
 * @date 2022/7/29
 * @since 1.0.0
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singleList = new ArrayList<>();
        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("single")) {
                singleList.add(person);
            }
        }
        return singleList;
    }

}
