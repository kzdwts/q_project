package top.kangyong.study02.design.principles.segregation.after;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/7/22
 * @since 1.0.0
 */
public class ClientDemo {

    public static void main(String[] args) {
        HeiMaSafetyDoor door = new HeiMaSafetyDoor();
        door.antiTheft();
        door.fireProof();
        door.waterProof();

        System.out.println("=========");

        ItCastSafetyDoor door1 = new ItCastSafetyDoor();
        door1.antiTheft();
        door1.fireProof();

    }
}
