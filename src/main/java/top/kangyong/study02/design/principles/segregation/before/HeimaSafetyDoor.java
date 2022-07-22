package top.kangyong.study02.design.principles.segregation.before;

/**
 * 黑马安全门
 * <p>
 * 接口隔离原则
 *
 * @author Kang Yong
 * @date 2022/7/19
 * @since 1.0.0
 */
public class HeimaSafetyDoor implements SafetyDoor {

    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireProof() {
        System.out.println("防火");
    }

    @Override
    public void waterProof() {
        System.out.println("防水");
    }

}
