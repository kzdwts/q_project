package top.kangyong.study01.design.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式
 *
 * @author Kang Yong
 * @date 2022/7/28
 * @since 1.0.0
 */
public class CriteriaMale implements Criteria {


    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> maleList = new ArrayList<>();
        for (Person person : maleList) {
            if (person.getGender().equalsIgnoreCase("male")) {
                maleList.add(person);
            }
        }
        return maleList;
    }
}
