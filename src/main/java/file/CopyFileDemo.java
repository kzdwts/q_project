package file;

import java.io.*;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 复制文件
 * @author: kangyong
 * @date: 2019/9/7 9:05
 * @version: v1.0
 */
public class CopyFileDemo {

    public static void main(String[] args) throws IOException {
        // 读取文件夹
        String srcPath = "E:/合肥市少儿书画大赛作品";
        String desPath = "E:/newFile";

        // 如果目标文件夹不存在，创建
        if (!new File(desPath).exists()) {
            new File(desPath).mkdir();
        }

        File file = new File(srcPath);
        File[] listFiles = file.listFiles();
        // 遍历所有文件
        for (int i = 0; i < listFiles.length; i++) {
            String oldFilePath = listFiles[i].getPath();
            String oldFileName = listFiles[i].getName();

            // 解析原文件名
            oldFileName = oldFileName.replace(" ", "");
            String[] oldFileNameSplit = oldFileName.split("号");
            String author = oldFileNameSplit[1].substring(0, oldFileNameSplit[1].lastIndexOf("."));
            String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));

            // 新文件重新命名（序号.后缀）
            // + UUID.randomUUID().toString().replaceAll("-", "")
            String newFileName = oldFileNameSplit[0] + suffix;

            // 打印图片信息(序号，作者名称，新图片名称)
            System.out.println(
//                    UUID.randomUUID().toString().replaceAll("-", "") + "\t\t"
                    oldFileNameSplit[0] + "\t\t"
                    + author + "\t\t"
                    + newFileName
            );

            // 复制
            copyFile1(oldFilePath, desPath + File.separator + newFileName);
        }

    }

    /**
     * 复制文件
     */
    public static void copyFile1(String oldPath, String newPath) {
        try {
            // 输入流
            FileInputStream fis = new FileInputStream(oldPath);
            // 输出流
            FileOutputStream fos = new FileOutputStream(newPath);

            // 缓存大小
            byte[] buffer = new byte[1024];
            int len = 0;
            // 读写
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
