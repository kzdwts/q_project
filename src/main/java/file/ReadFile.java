package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 读取文件
 * @author: kangyong
 * @date: 2019/10/18 11:29
 * @version: v1.0
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
        // 源文件目录
        String srcPath = "C:/Users/pc/Desktop/需求2/饭店门楼照片";
        // 新文件目录
        String desPath = "C:/Users/pc/Desktop/需求2/newPic";

        // 如果目标文件不存在，创建
        if (!(new File(desPath)).exists()) {
            new File(desPath).mkdir();
        }

        // 读取原文件夹
        File srcFile = new File(srcPath);
        File[] listFiles = srcFile.listFiles();
        int seq = 1001;
        // 遍历
        for (int i = 0; i < listFiles.length; i++) {
            String oldFilePath = listFiles[i].getPath();
            String oldFileName = listFiles[i].getName();
            String oldFileOnlyName = oldFileName.substring(0, oldFileName.lastIndexOf("."));
            String newFileName = seq + i + ".jpg";

            // 输出文件信息
            System.out.println((seq + i) + "\t\t" + newFileName + "\t\t" + oldFileOnlyName);

            // 复制文件
            FileUtils.copyFile(new File(oldFilePath), new File(desPath + File.separator + newFileName));
        }
    }

}
