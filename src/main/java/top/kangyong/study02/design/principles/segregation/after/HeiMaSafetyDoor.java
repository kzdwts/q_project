package top.kangyong.study02.design.principles.segregation.after;

/**
 * 黑马安全门
 *
 * @author Kang Yong
 * @date 2022/7/22
 * @since 1.0.0
 */
public class HeiMaSafetyDoor implements AntiTheft, FireProof, WaterProof {

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
