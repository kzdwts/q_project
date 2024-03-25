package top.kangyong.study02.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jackie
 * Copyright (c) 2015,blk All Rights Reserved.
 * @Project:WeChat
 * @File: NumberUtils[数值工具类]
 * @Package:com.blk.wechat.util
 * @Date: 2015-01-20
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {
    private static final Logger logger = LoggerFactory.getLogger(NumberUtils.class);
    private static Long latestTimeMiles = System.currentTimeMillis();

    private NumberUtils() {
    }

    public synchronized static String generateOrderNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        Date now = new Date();
        String tsf = sdf.format(now);
        StringBuffer orderNo = new StringBuffer();
        orderNo.append(tsf).append(RandomStringUtils.randomNumeric(6));
        return orderNo.toString();
    }

    public static String generateRefundOrderNumber() {
        return generateOrderNumber();
    }

    /**
     * 判断y是否在xx中存在
     *
     * @param y
     * @param xx
     * @return
     */
    public static boolean isExist(final int y, final int xx[]) {
        for (int i = 0; i < xx.length; i++) {
            if (xx[i] == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * 得到double的整数部分
     *
     * @param d
     * @return
     */
    public static int getIntPartOfDouble(final double d) {
        String str = String.valueOf(d);
        if (str.indexOf(".") == -1) {
            return Integer.parseInt(str);
        }
        return Integer.parseInt(str.substring(0, str.indexOf(".")));
    }

    /**
     * 得到double的整数部分值
     *
     * @param d
     * @return
     */
    public static int getIntPartOfDouble(final Double d) {
        double d1 = d == null ? 0 : d.doubleValue();
        return getIntPartOfDouble(d1);
    }

    /**
     * 得到一个小数
     *
     * @param str
     * @param defaultValue
     * @return
     */
    public static double parseDouble(String str, double defaultValue) {
        if (str == null || str.length() == 0) {
            return defaultValue;
        }
        return Double.parseDouble(str);
    }

    /**
     * 字符串转数值型
     *
     * @param str          要转换的字符串数字
     * @param defaultValue 默认值
     * @return int
     */
    public static int parseInt(String str, int defaultValue) {
        try {
            if (str == null || str.length() == 0) {
                return defaultValue;
            }
            return Integer.parseInt(str);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return defaultValue;
        }
    }

    /**
     * 字符串数字转大写
     *
     * @param intStr
     * @return
     */
    public static String translateIntString2(String intStr) {
        if (!isDigits(intStr)) {
            return intStr;
        }
        String returnStr = "";
        int len = intStr.length();
        for (int i = 0; i < len; i++) {
            String numStr = intStr.substring(i, i + 1);
            int num = parseInt(numStr, 0);
            returnStr += translateNum(num);
        }
        return returnStr;
    }

    /**
     * 数字转大写
     *
     * @param value
     * @return
     */
    public static String translateNum(int value) {
        String returnStr = "";
        switch (value) {
            case 0: {
                returnStr = "零";
                break;
            }
            case 1: {
                returnStr = "一";
                break;
            }
            case 2: {
                returnStr = "二";
                break;
            }
            case 3: {
                returnStr = "三";
                break;
            }
            case 4: {
                returnStr = "四";
                break;
            }
            case 5: {
                returnStr = "五";
                break;
            }
            case 6: {
                returnStr = "六";
                break;
            }
            case 7: {
                returnStr = "七";
                break;
            }
            case 8: {
                returnStr = "八";
                break;
            }
            case 9: {
                returnStr = "九";
                break;
            }
        }
        return returnStr;
    }

    /**
     * 得到double的小数部分
     *
     * @param d
     * @return
     */
    public static int getDecPartOfDouble(final double d) {
        String str = String.valueOf(d);
        String part = str.substring(str.indexOf(".") + 1);
        int despart = part.length() > 3 ? Integer.parseInt(part.substring(0, 3)) : Integer.parseInt(part);
        if (despart > 100) {
            if ((despart % 10) > 4) {
                despart += 10;
            }
            despart = despart / 10;
        }
        return despart;
    }

    /**
     * 获得double的小数部分数字
     *
     * @param d
     * @return
     */
    public static int getDecPartOfDouble(final Double d) {
        double d1 = d == null ? 0 : d.doubleValue();
        return getDecPartOfDouble(d1);
    }

    /**
     * 得到一个整数的相反的数
     *
     * @param i
     * @return
     */
    public static int getReverseInt(final int i) {
        String str = String.valueOf(i);
        if (i == 0) {
            return i;
        } else if (i > 0) {
            return parseInt("-" + str, 0);
        } else {
            return parseInt(str.substring(1), 0);
        }
    }

    /**
     * 得到一个Double的value
     *
     * @param d
     * @param defaultValue
     * @return
     */
    public static double doubleValue(final Double d, final double defaultValue) {
        if (d == null) {
            return defaultValue;
        } else {
            return d.doubleValue();
        }
    }

    /**
     * 得到一个BigDecimal的value
     *
     * @param d
     * @param defaultValue
     * @return
     */
    public static double doubleValue(final BigDecimal d, final double defaultValue) {
        if (d == null) {
            return defaultValue;
        } else {
            return d.doubleValue();
        }
    }

    /**
     * 得到一个String的double value
     *
     * @param d
     * @param defaultValue 默认值
     * @return
     */
    public static double doubleValue(final String d, final double defaultValue) {
        try {
            return Double.parseDouble(d);
        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            return defaultValue;
        }
    }

    /**
     * 得到Integer的数intValue值
     *
     * @param i
     * @param defaultValue 默认值
     * @return
     */
    public static int intValue(final Integer i, final int defaultValue) {
        if (i == null) {
            return defaultValue;
        } else {
            return i.intValue();
        }
    }

    /**
     * 得到BigInteger的intValue值
     *
     * @param i
     * @param defaultValue 默认值
     * @return
     */
    public static int intValue(final BigInteger i, final int defaultValue) {
        if (i == null) {
            return defaultValue;
        } else {
            return i.intValue();
        }
    }

    /**
     * 得到string的 int value
     *
     * @param i
     * @param defaultValue
     * @return
     */
    public static int intValue(final String i, final int defaultValue) {
        try {
            return Integer.parseInt(i);
        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            return defaultValue;
        }
    }

    public static double doubleValueWithFormat(final double doubleValue) {
        int intpart = getIntPartOfDouble(doubleValue);
        int despart = getDecPartOfDouble(doubleValue);
        double desdouble = new Integer(despart).doubleValue();
        if (despart >= 100) {
            return intpart;
        } else if (despart >= 10) {
            if (doubleValue >= 0) {
                return intpart + desdouble / 100;
            } else {
                return intpart - desdouble / 100;
            }
        } else {
            if (doubleValue >= 0) {
                return intpart + desdouble / 10;
            } else {
                return intpart - desdouble / 10;
            }
        }
    }

    public static String generateUniqueNumber() {
        synchronized (NumberUtils.latestTimeMiles) {
            while (NumberUtils.latestTimeMiles != null && NumberUtils.latestTimeMiles.doubleValue() == System.currentTimeMillis()) {
                try {
                    Thread.sleep(50);
                    //NumberUtils.latestTimeMiles.wait(50);
                    return generateUniqueNumber();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            NumberUtils.latestTimeMiles = System.currentTimeMillis();
            return String.valueOf(NumberUtils.latestTimeMiles);
        }
    }

    /**
     * @param i
     * @return
     * @功能: 产生i位随机数
     */
    public static String generateCodes(int i) {
        String codes = "";
        for (int j = 0; j < i; j++) {
            int temp = (int) (Math.random() * 9);
            String code = String.valueOf(temp);
            codes += code;
        }
        return codes;
    }

    public static Double divide(Long divisor, Long dividend, int scale) {
        if (divisor != null && dividend != null && dividend != 0) {
            BigDecimal result = new BigDecimal(divisor).divide(new BigDecimal(dividend), scale, RoundingMode.HALF_UP);
            return result.doubleValue();
        }
        return 0.00D;
    }

    public static String divide2String(Long divisor, Long dividend, int scale) {
        if (divisor != null && dividend != null && dividend != 0) {
            BigDecimal result = new BigDecimal(divisor).divide(new BigDecimal(dividend), scale, RoundingMode.HALF_UP);
            return String.format("%.2f", result.doubleValue());
        }
        return "0.00";
    }

    public static String divide2String(BigDecimal divisor, Long dividend, int scale) {
        if (divisor != null && dividend != null && dividend != 0) {
            BigDecimal result = divisor.divide(new BigDecimal(dividend), scale, RoundingMode.HALF_UP);
            return String.format("%.2f", result.doubleValue());
        }
        return "0.00";
    }

    /**
     * 订单号生成 https://blog.csdn.net/weixin_38405253/article/details/108353743
     **/
    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");
    private static final AtomicInteger SEQ = new AtomicInteger(1000);
    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmss");

    public static String generateOrderNo() {
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if (SEQ.intValue() > 9990) {
            SEQ.getAndSet(1000);
        }
        return dataTime.format(DF_FMT_PREFIX) + getLocalIpSuffix() + SEQ.getAndIncrement();
    }

    private volatile static String IP_SUFFIX = null;

    private static String getLocalIpSuffix() {
        if (null != IP_SUFFIX) {
            return IP_SUFFIX;
        }
        try {
            synchronized (NumberUtils.class) {
                if (null != IP_SUFFIX) {
                    return IP_SUFFIX;
                }
                InetAddress addr = InetAddress.getLocalHost();
                String hostAddress = addr.getHostAddress();
                if (null != hostAddress && hostAddress.length() > 4) {
                    String ipSuffix = hostAddress.trim().split("\\.")[3];
                    if (ipSuffix.length() == 2) {
                        IP_SUFFIX = ipSuffix;
                        return IP_SUFFIX;
                    }
                    ipSuffix = "0" + ipSuffix;
                    IP_SUFFIX = ipSuffix.substring(ipSuffix.length() - 2);
                    return IP_SUFFIX;
                }
                IP_SUFFIX = RandomStringUtils.randomNumeric(2) + "";
                return IP_SUFFIX;
            }
        } catch (Exception e) {
            System.out.println("获取IP失败:" + e.getMessage());
            IP_SUFFIX = RandomStringUtils.randomNumeric(2) + "";
            return IP_SUFFIX;
        }
    }

    public static void main(String[] args) {
        List<String> orderNos = Collections.synchronizedList(new ArrayList<String>());
        IntStream.range(0, 8000).parallel().forEach(i -> {
            orderNos.add(generateOrderNo());
        });
        List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());
        System.out.println("订单样例：" + orderNos.get(22));
        System.out.println("生成订单数：" + orderNos.size());
        System.out.println("过滤重复后订单数：" + filterOrderNos.size());
        System.out.println("重复订单数：" + (orderNos.size() - filterOrderNos.size()));

        System.out.println("===========华丽的分割线=============");
        // 报修、报事、投诉的工单号生成：
        //generateOrderNumber()
        for (int i = 1; i < 1134; i++) {
            String s1 = generateOrderNumber();
//            System.out.println(i + " = " + s1);
            System.out.println(s1);
        }

        System.out.println("==============咨询============");
//
        // 咨询建议的工单号生成：generateUniqueNumber()
//        for (int i = 1; i < 482; i++) {
//            String s2 = generateUniqueNumber();
//            System.out.println(s2);
//        }

    }

}