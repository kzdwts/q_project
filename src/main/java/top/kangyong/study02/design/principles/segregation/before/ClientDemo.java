package top.kangyong.study02.design.principles.segregation.before;

/**
 * test
 * <p>
 * 接口隔离原则
 *
 * @author Kang Yong
 * @date 2022/7/19
 * @since 1.0.0
 */
public class ClientDemo {

    public static void main(String[] args) {
        HeimaSafetyDoor door = new HeimaSafetyDoor();
        door.antiTheft();
        door.fireProof();
        door.waterProof();

    }
}
