package json;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import test01.Person;
import test01.Pxinyan;
import test01.SchoolArea;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: Kang Yong
 * @date: 2021/3/26 11:44
 * @version: v1.0
 */
public class JsonDemo02 {

    @Test
    public void demoTest01() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(new HashMap<String, Object>() {
            {
                put("name", "李zimu");
                put("age", 21);
            }
        });
        mapList.add(new HashMap<String, Object>() {
            {
                put("name", "九黎小康");
                put("age", 25);
            }
        });

//        String jsonString = JSONArray.toJSONString(mapList);
//        List<Pxinyan> pxinyanList = JSONArray.parseArray(jsonString, Pxinyan.class);
//        pxinyanList.forEach(System.out::println);

        List<Pxinyan> userList = mapList.stream().map(m -> new Pxinyan(m.getOrDefault("name", "").toString(), Integer.parseInt(m.getOrDefault("age", "").toString()))).collect(Collectors.toList());
        userList.forEach(System.out::println);

    }

    @Test
    public void demoTest02() {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", "李子木");
        hashMap.put("name", "陆智航");
        hashMap.put("age", 18);
        hashMap.put("age", 20);
        hashMap.forEach((k, v) -> System.out.println(k + " v:" + v));

    }

    @Test
    public void demoTest03() {
        List<SchoolArea> areaList = new ArrayList<>();
//        areaList.add(new SchoolArea("王丽丽大学", 28, 1000));
//        areaList.add(new SchoolArea("储小姣大学", 22, 1999));
//        areaList.add(new SchoolArea("李子木大学", 21, 1022));
        areaList.add(new SchoolArea("王丽丽大学", 28));
        areaList.add(new SchoolArea("储小姣大学", 22));
        areaList.add(new SchoolArea("李子木大学", 21));

        Integer sumAge = areaList.stream().mapToInt(SchoolArea::getAge).sum();
        Integer sumRenci = areaList.stream().mapToInt(SchoolArea::getRenci).sum();
        System.out.println("年龄：" + sumAge);
        System.out.println("人数：" + sumRenci);

    }

    @Test
    public void demoTest04() {
        List<String> nameList = new ArrayList<>();
        List<String> friendNameList = new ArrayList<>();
        List<String> grilNameList = new ArrayList<>();
        friendNameList.add("王丽丽");
        friendNameList.add("储小姣");
        friendNameList.add("李子木");
        friendNameList.add("钱梦婷");
        grilNameList.add("暴风");
        grilNameList.add("杨瑞环");
        grilNameList.add("李子木");
        grilNameList.add("储小姣");
        grilNameList.add("张新艳");

        nameList.addAll(friendNameList);
        nameList.addAll(grilNameList);

        nameList.forEach(System.out::println);

        System.out.println("===========");
        String d = nameList.stream().distinct().collect(Collectors.joining(","));
        System.out.println(d);
    }

    @Test
    public void testCompare() {
        String startTime = "2020-09-19 08:00:00";
        String endTime = "2021-01-02 10:00:00";

        int i = endTime.compareTo(startTime);
        System.out.println(i);

    }

    @Test
    public void strTest01() {
        String name = "wanglili,chuxiaojiao,qianmengting,lizimu";
        String str = name.substring(1);
        System.out.println(str);
    }

    /**
     * 获取当前时间到凌晨 相差的秒数
     */
    @Test
    public void testGetSeconds() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now();
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);
        long seconds = TimeUnit.NANOSECONDS.toSeconds(Duration.between(LocalDateTime.now(), tomorrowMidnight).toNanos());


        System.out.println(midnight);
        System.out.println(today);
        System.out.println(todayMidnight);
        System.out.println(tomorrowMidnight);
        System.out.println(seconds);
    }

    /**
     * 获取当前时间到凌晨 相差的秒数
     */
    @Test
    public void testGetSeconds2() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.MILLISECOND,0);
        Long timeOut = (calendar.getTimeInMillis()-System.currentTimeMillis())/1000 ;//当前时间到次日0点差多少秒
        System.out.println(timeOut);
    }





}
