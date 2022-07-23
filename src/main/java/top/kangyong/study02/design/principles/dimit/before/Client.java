package top.kangyong.study02.design.principles.dimit.before;

/**
 * test
 * <p>
 * 迪米特法则
 *
 * @author Kang Yong
 * @date 2022/7/24
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Agent agent = new Agent();

        Star star = new Star("林青霞");
        agent.setStar(star);

        Fans fans = new Fans("风清扬");
        agent.setFans(fans);

        Company company = new Company("黑马经济公司");
        agent.setCompany(company);

        agent.metting();
        agent.business();

    }
}
