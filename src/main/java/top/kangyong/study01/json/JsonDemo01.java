package top.kangyong.study01.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: kangyong
 * @date: 2020/10/20 18:20
 * @version: v1.0
 */
public class JsonDemo01 {

    @Test
    public void test01() {
        String res = "{\"flag\":true,\"Data\":\"{\\\"Data\\\":[{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":0,\\\"normalNumber\\\":0,\\\"roomCode\\\":\\\"RMHF87001\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"包河-滨湖临滨苑校区网络教室1\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":68,\\\"normalNumber\\\":40,\\\"roomCode\\\":\\\"RMHF16100\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑201\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":48,\\\"normalNumber\\\":40,\\\"roomCode\\\":\\\"RMHF16101\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑202\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":40,\\\"normalNumber\\\":35,\\\"roomCode\\\":\\\"RMHF16102\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑204\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":36,\\\"normalNumber\\\":36,\\\"roomCode\\\":\\\"RMHF16103\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑205\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":68,\\\"normalNumber\\\":40,\\\"roomCode\\\":\\\"RMHF16104\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑206\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":68,\\\"normalNumber\\\":40,\\\"roomCode\\\":\\\"RMHF16105\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑207\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":48,\\\"normalNumber\\\":40,\\\"roomCode\\\":\\\"RMHF16106\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑208\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":48,\\\"normalNumber\\\":40,\\\"roomCode\\\":\\\"RMHF16107\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑213\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":68,\\\"normalNumber\\\":40,\\\"roomCode\\\":\\\"RMHF16108\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑214\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":36,\\\"normalNumber\\\":24,\\\"roomCode\\\":\\\"RMHF16109\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑215\\\"},{\\\"areaCode\\\":\\\"ARHF87\\\",\\\"areaName\\\":\\\"包河-滨湖临滨苑校区\\\",\\\"maxNumber\\\":32,\\\"normalNumber\\\":24,\\\"roomCode\\\":\\\"RMHF16110\\\",\\\"roomDeptCodes\\\":[\\\"DPHF016\\\"],\\\"roomDeptNames\\\":[\\\"中学项目部\\\"],\\\"roomName\\\":\\\"临滨苑216\\\"}],\\\"state\\\":1,\\\"ErrMessage\\\":\\\"\\\"}\"}";
        JSONObject jsonObject = JSON.parseObject(res);
        Object flag = jsonObject.get("flag");
        if ("true".equals(jsonObject.get("flag"))) {
            System.out.println(flag);
            JSONObject data1 = jsonObject.getJSONObject("Data");
            JSONArray data = data1.getJSONArray("Data");
            System.out.println(data.size());
        }
    }

    @Test
    public void test02() {
        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

}
