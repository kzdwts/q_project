package top.kangyong.study02.design.principles.segregation.after;

/**
 * 传智安全门
 *
 * @author Kang Yong
 * @date 2022/7/22
 * @since 1.0.0
 */
public class ItCastSafetyDoor implements AntiTheft, FireProof {

    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireProof() {
        System.out.println("防火");
    }
}
