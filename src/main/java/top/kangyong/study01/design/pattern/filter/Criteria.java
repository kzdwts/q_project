package top.kangyong.study01.design.pattern.filter;

import java.util.List;

/**
 * 过滤器模式
 *
 * @author Kang Yong
 * @date 2022/7/26
 * @since 1.0.0
 */
public interface Criteria {

    List<Person> meetCriteria(List<Person> persons);
}
