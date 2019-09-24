package pers.alex.system.collector.information.User;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Who;

/**
 * @author Alex
 * @date 2019/9/20 8:48
 */
public class UserCollector {

    private static Sigar sigar = new Sigar();

    public static JSONArray collect() throws SigarException {

        JSONArray result = new JSONArray();
        Who[] whoList = sigar.getWhoList();
        for (Who o : whoList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("user", o.getUser());
            jsonObject.put("host", o.getHost());
            jsonObject.put("device", o.getDevice());
            jsonObject.put("time", o.getTime());
            result.add(jsonObject);
        }

        return result;
    }

}
