package top.kangyong.study02.design.pattern.structuralmode.bridge;

/**
 * rmvb视频文件（具体的实现化角色）
 *
 * @author Kang Yong
 * @date 2022/11/11
 * @since 1.0.0
 */
public class RmvbFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println("Rmvb视频文件：" + fileName);
    }

}
