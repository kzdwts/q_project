package top.kangyong.study02.imgdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片工具测试
 *
 * @author Kang Yong
 * @date 2022/2/11
 * @since 1.0.0
 */
public class PicUtilTest {

    @Test
    public void testPic1() {
        // 图片地址
        List<String> picList = new ArrayList<>();
        picList.add("http://img1.gtimg.com/13/1310/131008/13100832_980x1200_0.jpg");
//        picList.add("https://dev-jiaofu.yuanzhiyijiantong.com/resources/2022-02-09/4266db3f-dc38-4bd5-93da-434bc6161446/head.png");
//        picList.add("https://dev-jiaofu.yuanzhiyijiantong.com/resources/2022-02-09/4266db3f-dc38-4bd5-93da-434bc6161446/head.png");

        // 合成图片
        PicUtil picUtil = new PicUtil();
        String fullPath = picUtil.getCombinationOfhead(picList, "D:\\LenovoSoftstore\\");
        System.out.println(fullPath);
    }
}
