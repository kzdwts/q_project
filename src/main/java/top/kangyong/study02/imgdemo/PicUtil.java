package top.kangyong.study02.imgdemo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 图片工具类
 */
public class PicUtil {

    /**
     * 图片宽度
     */
    private final Integer PIC_WIDTH = 422;
    /**
     * 图片高度
     */
    private final Integer PIC_HEIGHT = 422;
    /**
     * 空白宽度
     */
    private final Integer PIC_SPACE = 14;

    /**
     * 小图片宽度
     */
    private Double LUMP_WIDTH = null;
    /**
     * 小图片起始点横坐标
     */
    private Double LUMP_POINT_X = null;
    /**
     * 小图片起始点纵坐标
     */
    private Double LUMP_POINT_Y = null;

    private static final String FONT_PATH = "/font/SimSun.ttf";

    /***  思考笔记  可以跳过
     *  2 和 4 的区别  向下偏移量          0.5 LUMP_WIDTH+  0.5 PIC_SPACE
     *  3 和 4 的区别 第一张图向右偏移量   0.5 LUMP_WIDTH + 0.5 PIC_SPACE
     *  5 和 6 的区别 第一张图向右偏移量   0.5 LUMP_WIDTH+ 0.5 PIC_SPACE
     *  6 和 9 的区别 向下偏移量          0.5 LUMP_WIDTH+ 0.5 PIC_SPACE
     *  7 和 9 的区别 第一张图向右偏移量  LUMP_WIDTH+PIC_SPACE
     *  8 和 9 的区别 第一张图向右偏移量  0.5 LUMP_WIDTH+ 0.5 PIC_SPACE
     */

    // 围边使用的灰色
    private final int[] COLOR_GREY_BGR = new int[]{230, 230, 230};

    //校对数组使用下标
    private int flg = 0;

    public String getCombinationOfhead(List<String> pics, String path) {
        List<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();

        // BufferedImage.TYPE_INT_RGB可以自己定义可查看API
        BufferedImage outImage = new BufferedImage(PIC_WIDTH, PIC_HEIGHT, BufferedImage.TYPE_INT_RGB);

        Graphics2D gra = outImage.createGraphics();
        //设置背景为蓝灰色
        gra.setColor(toColor(COLOR_GREY_BGR));
        //填满图片
        gra.fillRect(0, 0, PIC_WIDTH, PIC_HEIGHT);

        // 开始拼凑 根据图片的数量判断该生成哪种样式组合头像

        Integer size = pics.size();//图片数量
        Integer sqrt = (int) Math.ceil(Math.sqrt(size));//宽度  一行几张图片
        //计算出 单张图片宽度
        LUMP_WIDTH = (PIC_WIDTH - ((sqrt + 1.0) * PIC_SPACE)) / sqrt;

        System.out.println(LUMP_WIDTH);

        // 压缩图片所有的图片生成尺寸同意的 为 125*125
        for (int i = 0; i < pics.size(); i++) {
            BufferedImage resize2 = resize2(pics.get(i), LUMP_WIDTH.intValue(), LUMP_WIDTH.intValue(), true);
            bufferedImages.add(resize2);
        }

        //缺几个满伍
        int lack = 0;
        //计算起始点坐标
        if (size < sqrt * (sqrt - 1)) {//少一行 不满伍
            //缺几个满伍
            lack = sqrt * (sqrt - 1) - size;
            //向右边偏移量
            LUMP_POINT_X = PIC_SPACE.doubleValue() + lack * (LUMP_WIDTH + PIC_SPACE) / 2;
            //向下偏移量
            LUMP_POINT_Y = PIC_SPACE.doubleValue() + LUMP_WIDTH / 2.;
        } else if (size == sqrt * (sqrt - 1)) {//满伍少一行
            //向右边偏移量
            LUMP_POINT_X = PIC_SPACE.doubleValue();
            //向下偏移量
            LUMP_POINT_Y = PIC_SPACE.doubleValue() + LUMP_WIDTH / 2.;
        } else if (size < sqrt * sqrt) {//不满伍
            //缺几个满伍
            lack = sqrt * sqrt - size;
            //向右边偏移量
            LUMP_POINT_X = PIC_SPACE.doubleValue() + lack * (LUMP_WIDTH + PIC_SPACE) / 2;
            LUMP_POINT_Y = PIC_SPACE.doubleValue();
        } else if (size == sqrt * sqrt) {//满伍
            LUMP_POINT_X = PIC_SPACE.doubleValue();
            LUMP_POINT_Y = PIC_SPACE.doubleValue();
        }

        int line = lack == 0 ? -1 : 0; //第几行图片
        int row = 0; //第几列图片
        for (int i = 0; i < bufferedImages.size(); i++) {
            if ((i + lack) % sqrt == 0) {
                line++;
                row = 0;
            }
            if (line == 0) {
                gra.drawImage(bufferedImages.get(i),
                        LUMP_POINT_X.intValue() + (row++ * (PIC_SPACE + LUMP_WIDTH.intValue()))
                        , LUMP_POINT_Y.intValue(), null);
            } else {
                gra.drawImage(bufferedImages.get(i), PIC_SPACE + (row++ * (PIC_SPACE + LUMP_WIDTH.intValue()))
                        , LUMP_POINT_Y.intValue() + (line * (PIC_SPACE + LUMP_WIDTH.intValue())), null);
            }
        }
//        log.info("九宫格图片地址, path is{}", path);
        File file = new File(path + ".png");
        //文件如果存在先删除，再创建
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                    if (!file.createNewFile()) {
//                        log.error("创建失败!!!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        log.info("====>>>file write successful ");
        //将图片写到文件
        try {
            ImageIO.write(outImage, "png", file);
        } catch (IOException e) {
            return "";
        }
//        log.info("====>>> pic is successful");
        //获取后缀名
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return suffix;
    }


    /**
     * 图片缩放
     *
     * @param picPath 本地或网络图片路径
     * @param height  缩放后高度
     * @param width   缩放后宽度
     * @param fill    是否填充灰色
     * @return BufferedImage
     */
    public BufferedImage resize2(String picPath, Integer height, Integer width, boolean fill) {
        try {
            BufferedImage imageBuff = null;
            if (picPath.indexOf("https://") == 0 || picPath.indexOf("http://") == 0) { //简单判断是网络图片还是本地图片
                imageBuff = ImageIO.read(new URL(picPath));
            } else {
                imageBuff = ImageIO.read(new File(picPath));
            }

            Image itemp = imageBuff.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            double ratio = 0; // 缩放比例
            // 计算比例
            if ((imageBuff.getHeight() > height) || (imageBuff.getWidth() > width)) {
                if (imageBuff.getHeight() > imageBuff.getWidth()) {
                    ratio = height.doubleValue() / imageBuff.getHeight();
                } else {
                    ratio = width.doubleValue() / imageBuff.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);

                itemp = op.filter(imageBuff, null);
            }

            if (fill) {
                BufferedImage image = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);

                Graphics2D g = image.createGraphics();

                g.setColor(toColor(COLOR_GREY_BGR));

                g.fillRect(0, 0, width, height);

                if (width == itemp.getWidth(null))
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                else
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                g.dispose();
                itemp = image;
            }
            return (BufferedImage) itemp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param colorRoot 颜色索引
     * @return 颜色
     * @toColor 颜色索引转为颜色
     */
    private Color toColor(int[] colorRoot) {
        if (colorRoot.length >= 3) {
            return new Color(colorRoot[0], colorRoot[1], colorRoot[2]);
        } else {
            return null;
        }
    }

    /**
     * 绘制字体头像
     * 如果是英文名，只显示首字母大写
     * 如果是中文名，只显示最后一个字
     *
     * @param name
     * @param outputName
     * @throws IOException
     */
    public String generateImg(String name, String outputName, String path)
            throws IOException {
        int width = 100;
        int height = 100;
        int nameLen = name.length();
        String nameWritten;

        //如果用户输入的姓名大于等于3个字符，截取后面一位  可根据需求改长度
        String first = name.substring(nameLen - 1);
        if (isChinese(first)) {
            //截取倒数两位汉字
            nameWritten = first;
        } else {
            //截取前面的两个英文字母
            nameWritten = name.substring(0, 2).toUpperCase();
        }


        File file = new File(path + ".png");
        //文件如果存在先删除，再创建
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                    if (!file.createNewFile()) {
//                        log.error("创建失败!!!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.setBackground(getRandomColor());

        g2.clearRect(0, 0, width, height);

        g2.setPaint(Color.WHITE);


        Font font = null;
        //两个字及以上
        if (nameWritten.length() >= 2) {
            font = new Font("宋体", Font.PLAIN, 30);
            g2.setFont(font);

            String firstWritten = nameWritten.substring(0, 1);
            String secondWritten = nameWritten.substring(1, 2);

            //两个中文 如 言曌
            if (isChinese(firstWritten) && isChinese(secondWritten)) {
                g2.drawString(nameWritten, 20, 60);
            }
            //首中次英 如 罗Q
            else if (isChinese(firstWritten) && !isChinese(secondWritten)) {
                g2.drawString(nameWritten, 27, 60);

                //首英,如 AB
            } else {
                nameWritten = nameWritten.substring(0, 1);
            }

        }
        //一个字
        if (nameWritten.length() == 1) {
            //中文
            if (isChinese(nameWritten)) {
                font = new Font("宋体", Font.PLAIN, 50);
                g2.setFont(font);
                g2.drawString(nameWritten, 25, 70);
            }
            //英文
            else {
                font = new Font("宋体", Font.PLAIN, 55);
                g2.setFont(font);
                g2.drawString(nameWritten.toUpperCase(), 33, 67);
            }

        }

        BufferedImage rounded = makeRoundedCorner(bi, 99);

        try {
            ImageIO.write(rounded, "png", file);
        } catch (IOException e) {
            return "";
        }
        //获取后缀名
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return suffix;
    }


    /**
     * 判断字符串是否为中文
     *
     * @param str
     * @return
     */
    public static boolean isChinese(String str) {
        String regEx = "[\\u4e00-\\u9fa5]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find())
            return true;
        else
            return false;
    }

    /**
     * 获得随机颜色
     *
     * @return
     */
    private static Color getRandomColor() {
        String[] beautifulColors =
                new String[]{"232,221,203", "205,179,128", "3,101,100", "3,54,73", "3,22,52",
                        "237,222,139", "251,178,23", "96,143,159", "1,77,103", "254,67,101", "252,157,154",
                        "249,205,173", "200,200,169", "131,175,155", "229,187,129", "161,23,21", "34,8,7",
                        "118,77,57", "17,63,61", "60,79,57", "95,92,51", "179,214,110", "248,147,29",
                        "227,160,93", "178,190,126", "114,111,238", "56,13,49", "89,61,67", "250,218,141",
                        "3,38,58", "179,168,150", "222,125,44", "20,68,106", "130,57,53", "137,190,178",
                        "201,186,131", "222,211,140", "222,156,83", "23,44,60", "39,72,98", "153,80,84",
                        "217,104,49", "230,179,61", "174,221,129", "107,194,53", "6,128,67", "38,157,128",
                        "178,200,187", "69,137,148", "117,121,71", "114,83,52", "87,105,60", "82,75,46",
                        "171,92,37", "100,107,48", "98,65,24", "54,37,17", "137,157,192", "250,227,113",
                        "29,131,8", "220,87,18", "29,191,151", "35,235,185", "213,26,33", "160,191,124",
                        "101,147,74", "64,116,52", "255,150,128", "255,94,72", "38,188,213", "167,220,224",
                        "1,165,175", "179,214,110", "248,147,29", "230,155,3", "209,73,78", "62,188,202",
                        "224,160,158", "161,47,47", "0,90,171", "107,194,53", "174,221,129", "6,128,67",
                        "38,157,128", "201,138,131", "220,162,151", "137,157,192", "175,215,237", "92,167,186",
                        "255,66,93", "147,224,255", "247,68,97", "185,227,217"};
        int len = beautifulColors.length;
        Random random = new Random();
        String[] color = beautifulColors[random.nextInt(len)].split(",");
        return new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]),
                Integer.parseInt(color[2]));
    }


    /**
     * 图片做圆角处理
     *
     * @param image
     * @param cornerRadius
     * @return
     */
    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return output;
    }
}
