package pers.alex.system.collector.information.network;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * @author Alex
 * @date 2019/9/20 10:15
 */
public class NetCollector {

    private static Sigar sigar = new Sigar();

    public static JSONArray collect() throws SigarException {

        JSONArray result = new JSONArray();

        String ifNames[] = sigar.getNetInterfaceList();
        for (int i = 0; i < ifNames.length; i++) {


            String name = ifNames[i];
            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
            if (ifconfig.getAddress().equals("0.0.0.0")) {
                continue;
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", name);// 网络设备名
            jsonObject.put("address", ifconfig.getAddress());// IP地址
            jsonObject.put("netmask", ifconfig.getNetmask());// 子网掩码
            if ((ifconfig.getFlags() & 1L) <= 0L) {
                continue;
            }
            NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
            jsonObject.put("rxPackets", ifstat.getRxPackets());// 接收的总包裹数
            jsonObject.put("txPackets", ifstat.getTxPackets());// 发送的总包裹数
            jsonObject.put("rxBytes", ifstat.getRxBytes());// 接收到的总字节数
            jsonObject.put("txBytes", ifstat.getTxBytes());// 发送的总字节数
            jsonObject.put("rxErrors", ifstat.getRxErrors());// 接收到的错误包数
            jsonObject.put("txErrors", ifstat.getTxErrors());// 发送数据包时的错误数
            jsonObject.put("rxDropped", ifstat.getRxDropped());// 接收时丢弃的包数
            jsonObject.put("txDropped", ifstat.getTxDropped());// 发送时丢弃的包数

            result.add(jsonObject);
        }

        return result;
    }

}
