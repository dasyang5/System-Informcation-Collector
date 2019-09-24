package pers.alex.system.collector.information.network;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * @author Alex
 * @date 2019/9/20 10:28
 */
public class EthernetCollector {

    private static Sigar sigar = new Sigar();

    public static JSONArray collect() throws SigarException {

        JSONArray result = new JSONArray();

        String[] ifaces = sigar.getNetInterfaceList();
        for (int i = 0; i < ifaces.length; i++) {
            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
            if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
                    || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
                continue;
            }
            if (cfg.getAddress().equals("0.0.0.0")) {
                continue;
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name" , cfg.getName());//
            jsonObject.put("address" , cfg.getAddress());// IP地址
            jsonObject.put("broadcast" , cfg.getBroadcast());// 网关广播地址
            jsonObject.put("hwaddr" , cfg.getHwaddr());// 网卡MAC地址
            jsonObject.put("netmask" , cfg.getNetmask());// 子网掩码
            jsonObject.put("description", cfg.getDescription());// 网卡描述信息
            jsonObject.put("type" , cfg.getType());//
            result.add(jsonObject);
        }

        return result;

    }

}
