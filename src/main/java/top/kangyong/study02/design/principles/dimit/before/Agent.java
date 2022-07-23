package top.kangyong.study02.design.principles.dimit.before;

/**
 * 经济人类
 * <p>
 * 迪米特法则
 *
 * @author Kang Yong
 * @date 2022/7/23
 * @since 1.0.0
 */
public class Agent {

    private Star star;
    private Fans fans;
    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * 和粉丝见面
     *
     * @author Kang Yong
     * @date 2022/7/23
     */
    public void metting() {
        System.out.println(star.getName() + "和粉丝" + fans.getName() + "见面");
    }

    /**
     * 谈商务
     *
     * @author Kang Yong
     * @date 2022/7/23
     */
    public void business() {
        System.out.println(star.getName() + "和" + company.getName() + "谈合作");
    }

}
