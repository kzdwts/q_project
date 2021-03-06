package demo;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/8/1 10:32
 * @version: v1.0
 */
public class Demo06 {

    @Test
    public void test01() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

    }

    @Test
    public void test02() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        Date date = calendar.getTime();
        System.out.println(date);
    }

    @Test
    public void test03() {
        Integer num = 1000000;
        if (num == 1000000) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        Integer b = 1000000;
        System.out.println(num == b);
    }

    @Test
    public void test04() {
        System.out.println(0 / 1);
        System.out.println(1 / 0);
    }

    @Test
    public void test05() {
        String dd = "98.3%";
        // String dStr = dd.substring(0, dd.length() - 1);
        String dStr = dd.replace("%", "");
        System.out.println(dStr);
    }

    @Test
    public void test06() {
        int num = 59 + 62 + 0 + 50 + 15 + 8 + 12 + 45 + 22 + 51 + 14 + 80 + 42 + 15 + 41 + 62 + 19 + 38 + 68 + 0 + 10 + 68 + 30 + 20 + 30 + 11 + 34 + 40 + 27 + 35 + 12 + 39 + 22 + 57 + 7 + 143 + 47 + 0 + 107 + 75 + 66 + 23 + 18 + 3 + 27 + 13 + 13 + 70 + 11 + 60 + 37 + 0 + 27 + 20 + 55 + 54 + 25 + 88 + 37 + 115;
        System.out.println(num);
    }

    @Test
    public void test07() {
        Long num1 = 1L;
        Integer num2 = 2;

    }

    @Test
    public void test08() {
    }

    /**
     * 处理校区数据
     */
    @Test
    public void test09() {
        List<Area> areaList = getAreaList();

        areaList.forEach(System.out::println);
        System.out.println("areaList.size()=" + areaList.size());

        Map<String, String> areaDataMap = getAreaDataMap();
//        areaDataMap.forEach((k,v) -> System.out.println("k=" + k + ",  v=" + v));
//        System.out.println("areaDataMap.size()=" + areaDataMap.size());

        List<Area> resultList = new ArrayList<>();
        for (Area area : areaList) {
            if (areaDataMap.containsKey(area.getAreaCode())) {
                area.setActiveTime(areaDataMap.get(area.getAreaCode()));
                resultList.add(area);
            }
        }

//        resultList.forEach(System.out::println);
//        System.out.println("resultList.size()=" + resultList.size());

        for (Area area : resultList) {
            System.out.println("UPDATE report_area SET active_time='"+area.getActiveTime()+"' WHERE id=" + area.getId() + ";   标识：" + area.getAreaNameDetail());
        }

    }

    public Map<String, String> getAreaDataMap() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("ARHF83", "2020/7/13 0:00");
        resultMap.put("ARHF53", "2018/12/23 0:00");
        resultMap.put("ARHF85", "2020/7/1 0:00");
        resultMap.put("ARHF56", "2019/1/12 0:00");
        resultMap.put("ARHF55", "2019/5/10 0:00");
        resultMap.put("ARHF70", "2020/1/17 0:00");
        resultMap.put("ARHF74", "2020/1/17 0:00");
        resultMap.put("ARHF32", "2016/1/13 0:00");
        resultMap.put("ARHF97", "2015/12/26 0:00");
        resultMap.put("ARHF25", "2017/7/13 0:00");
        resultMap.put("ARHF50", "2018/9/9 0:00");
        resultMap.put("ARHF40", "2017/6/17 0:00");
        resultMap.put("ARHF01", "2006/7/20 0:00");
        resultMap.put("ARHF41", "2017/7/1 0:00");
        resultMap.put("ARHF64", "2019/5/8 0:00");
        resultMap.put("ARHF42", "2017/6/28 0:00");
        resultMap.put("ARHF48", "2018/6/29 0:00");
        resultMap.put("ARHF79", "2020/7/1 0:00");
        resultMap.put("ARHF87", "2018/6/2 0:00");
        resultMap.put("ARHF43", "2018/1/19 0:00");
        resultMap.put("ARHF37", "2016/12/12 0:00");
        resultMap.put("ARHF28", "2014/9/13 0:00");
        resultMap.put("ARHF30", "2015/7/18 0:00");
        resultMap.put("ARHF45", "2018/7/1 0:00");
        resultMap.put("ARHF46", "2018/6/28 0:00");
        resultMap.put("ARHF82", "2020/6/27 0:00");
        resultMap.put("ARHF26", "2014/7/3 0:00");
        resultMap.put("ARHF62", "2019/6/11 0:00");
        resultMap.put("ARHF22", "2012/6/1 0:00");
        resultMap.put("ARHF47", "2018/7/1 0:00");
        resultMap.put("ARHF16", "2011/12/9 0:00");
        resultMap.put("ARHF33", "2016/7/1 0:00");
        resultMap.put("ARHF80", "2020/7/1 0:00");
        resultMap.put("ARHF19", "2012/6/10 0:00");
        resultMap.put("ARHF49", "2019/1/17 0:00");
        resultMap.put("ARHF54", "2019/3/1 0:00");
        resultMap.put("ARHF14", "2010/7/5 0:00");
        resultMap.put("ARHF08", "2008/1/28 0:00");
        resultMap.put("ARHF65", "2019/9/1 0:00");
        resultMap.put("ARHF75", "2020/1/30 0:00");
        resultMap.put("ARHF96", "2020/5/1 0:00");
        resultMap.put("ARHF34", "2016/6/28 0:00");
        resultMap.put("ARHF18", "2012/1/9 0:00");
        resultMap.put("ARHF52", "2019/1/12 0:00");
        resultMap.put("ARHF78", "2020/1/30 0:00");
        resultMap.put("ARHF66", "2019/6/10 0:00");
        resultMap.put("ARHF91", "2020/7/6 0:00");
        resultMap.put("ARHF76", "2020/1/4 0:00");
        resultMap.put("ARHF84", "2012/10/17 0:00");
        resultMap.put("ARHF24", "2012/9/16 0:00");
        resultMap.put("ARHF71", "2019/9/22 0:00");
        resultMap.put("ARHF77", "2020/1/17 0:00");
        resultMap.put("ARHF69", "2019/9/7 0:00");
        resultMap.put("ARHF68", "2020/1/4 0:00");
        resultMap.put("ARHF67", "2019/11/23 0:00");
        resultMap.put("ARHF59", "2019/6/20 0:00");
        resultMap.put("ARHF51", "2019/1/12 0:00");
        resultMap.put("ARHF36", "2016/9/10 0:00");
        resultMap.put("ARHF44", "2018/1/30 0:00");
        resultMap.put("ARHF38", "2017/6/26 0:00");
        resultMap.put("ARHF31", "2015/12/12 0:00");
        resultMap.put("ARHF23", "2012/9/11 0:00");
        resultMap.put("ARHF39", "2017/7/10 0:00");
        resultMap.put("ARHF57", "2019/5/10 0:00");
        resultMap.put("ARHF63", "2019/5/18 0:00");
        resultMap.put("ARHF86", "2020/6/27 0:00");
        resultMap.put("ARHF35", "2016/6/30 0:00");
        resultMap.put("ARHF27", "2014/7/16 0:00");
        resultMap.put("ARHF29", "2015/2/8 0:00");

        return resultMap;
    }


    public List<Area> getAreaList() {
        List<Area> areaList = new ArrayList<>();

        areaList.add(new Area(10, "汇金", "ARHF32", "汇金校区"));
        areaList.add(new Area(11, "汇鑫", "ARHF55", "汇鑫校区"));
        areaList.add(new Area(12, "美屯", "ARHF14", "富广校区"));
        areaList.add(new Area(12, "美屯", "ARHF08", "包河-美屯校区"));
        areaList.add(new Area(12, "美屯", "ARHF97", "包河-富广校区4楼"));
        areaList.add(new Area(13, "丝绸", "ARHF01", "包河-丝绸校区"));
        areaList.add(new Area(14, "保利拉菲西", "ARHF76", "包河-滨湖保利拉菲西校区"));
        areaList.add(new Area(15, "滨湖保利拉菲", "ARHF44", "包河-滨湖保利拉菲校区"));
        areaList.add(new Area(16, "滨湖利港银河", "ARHF48", "包河-滨湖利港银河幸福广场校区"));
        areaList.add(new Area(17, "佳源广场", "ARHF75", "包河-滨湖佳源广场校区"));
        areaList.add(new Area(18, "临滨苑", "ARHF16", "滨湖世纪金源校区"));
        areaList.add(new Area(18, "临滨苑", "ARHF87", "包河-滨湖临滨苑校区"));
        areaList.add(new Area(19, "日角大厦", "ARHF62", "包河-日角大厦校区"));
        areaList.add(new Area(21, "红星路", "ARHF51", "红星路"));
        areaList.add(new Area(22, "环城南路", "ARHF63", "庐阳-环城南路校区"));
        areaList.add(new Area(23, "栢景湾", "ARHF34", "庐阳-栢景湾校区"));
        areaList.add(new Area(24, "国文", "ARHF56", "庐阳-国文校区"));
        areaList.add(new Area(25, "蓝筹", "ARHF28", "庐阳-蓝筹校区"));
        areaList.add(new Area(26, "橡树湾", "ARHF59", "庐阳-橡树湾校区"));
        areaList.add(new Area(27, "贵潜", "ARHF18", "贵潜"));
        areaList.add(new Area(28, "汉嘉", "ARHF46", "汉嘉"));
        areaList.add(new Area(29, "拓基", "ARHF41", "拓基"));
        areaList.add(new Area(30, "学府星座", "ARHF65", "学府星座"));
        areaList.add(new Area(31, "学府银座", "ARHF40", "学府银座"));
        areaList.add(new Area(32, "保利东郡", "ARHF52", "保利东郡南校区"));
        areaList.add(new Area(33, "凤台路", "ARHF45", "凤台路"));
        areaList.add(new Area(34, "和平路", "ARHF22", "和平路"));
        areaList.add(new Area(35, "花冲影城", "ARHF70", "花冲影城"));
        areaList.add(new Area(36, "隆岗", "ARHF68", "隆岗"));
        areaList.add(new Area(37, "温莎", "ARHF31", "温莎"));
        areaList.add(new Area(38, "龙图路", "ARHF78", "蜀山-政务龙图路校区"));
        areaList.add(new Area(39, "御龙湾", "ARHF50", "蜀山-御龙湾校区"));
        areaList.add(new Area(40, "政务置地", "ARHF33", "蜀山-政务置地校区"));
        areaList.add(new Area(41, "保利东郡", "ARHF69", "瑶海-兴漕新居校区"));
        areaList.add(new Area(43, "桐城路", "ARHF26", "桐城路校区"));
        areaList.add(new Area(44, "百花大厦", "ARHF77", "庐阳-百花大厦校区"));
        areaList.add(new Area(45, "紫荆广场", "ARHF82", "蜀山-紫荆广场校区"));
        areaList.add(new Area(46, "百花井", "ARHF24", "百花井校区"));
        areaList.add(new Area(46, "百花井", "ARHF84", "庐阳-百花井校区"));
        areaList.add(new Area(50, "滨湖品阁", "ARHF39", "包河-滨湖明珠校区"));
        areaList.add(new Area(50, "滨湖品阁", "ARHF91", "滨湖品阁校区"));
        areaList.add(new Area(51, "CBC拓基", "ARHF86", "蜀山-CBC拓基广场校区"));

        return areaList;
    }

}
