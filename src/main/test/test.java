import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class test {
    @Test
    public void getDate() throws ParseException {
      String str="{\"entry\":[{\"factqty\":0,\"fbillid\":36,\"fentryid\":1,\"fgoodseat\":\"AP01G001L01K01\",\"fqty\":10,\"fsrc_billid\":42,\"fsrc_entryid\":1,\"fsrc_number\":\"SHTZ201805220002\",\"fstate\":\"未上架\",\"fstock\":\"新区标准件库\",\"mamodel\":\"M50*2-RC1/2（作废）     \",\"maname\":\"直角接头 M50*2-RC1/2（作废）\",\"manum\":\"900080759\",\"maunit\":\"只\"},{\"factqty\":0,\"fbillid\":36,\"fentryid\":2,\"fgoodseat\":\"AP01G001L01K01\",\"fqty\":5,\"fsrc_billid\":42,\"fsrc_entryid\":2,\"fsrc_number\":\"SHTZ201805220002\",\"fstate\":\"未上架\",\"fstock\":\"新区标准件库\",\"mamodel\":\"绞车控制阀箱 华北90D后台机组    \",\"maname\":\"绞车配件 绞车控制阀箱 华北90D后台机组\",\"manum\":\"115010395\",\"maunit\":\"只\"},{\"factqty\":0,\"fbillid\":36,\"fentryid\":3,\"fgoodseat\":\"AP01G001L01K01\",\"fqty\":8,\"fsrc_billid\":42,\"fsrc_entryid\":3,\"fsrc_number\":\"SHTZ201805220002\",\"fstate\":\"未上架\",\"fstock\":\"新区标准件库\",\"mamodel\":\"M16*1.5-RC1/2（作废）     \",\"maname\":\"直角接头 M16*1.5-RC1/2（作废）\",\"manum\":\"900080760\",\"maunit\":\"只\"}],\"fboxno\":\"CGDD201805220002-1\",\"fdate\":\"2018-05-22\",\"fid\":36,\"fisqt\":1,\"fnumber\":\"RK201805220003\",\"fsupplier\":\"测试供应商\",\"fuser\":\"admin\"}";
        Map map= JSON.parseObject(str,Map.class);
        JSONArray array=JSON.parseArray(map.get("entry").toString());
        map.remove("entry");
        for(int i=0;i<array.size();i++)
        {
            Map m= JSON.parseObject(array.get(i).toString(),Map.class);
            map.putAll(m);
            System.out.println(m);
            System.out.println(map);
        }

    }
}
