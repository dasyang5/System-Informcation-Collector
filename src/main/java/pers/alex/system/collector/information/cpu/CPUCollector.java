package pers.alex.system.collector.information.cpu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * @author Alex
 * @date 2019/9/19 15:44
 */
public class CPUCollector {

    private static Sigar sigar = new Sigar();

    public static JSONArray collect() throws SigarException {

        CpuInfo[] cpuInfos = sigar.getCpuInfoList();

        CpuPerc[] cpuPercs = sigar.getCpuPercList();

        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < cpuInfos.length; i++) {
            JSONObject cpu = new JSONObject();
            cpu.put("mhz", cpuInfos[i].getMhz());// CPU的总量MHz
            cpu.put("vendor", cpuInfos[i].getVendor());// 获得CPU的卖主，如：Intel
            cpu.put("model", cpuInfos[i].getModel());// 获得CPU的类别，如：Celeron
            cpu.put("cacheSize", cpuInfos[i].getCacheSize());// 缓冲存储器数量
            cpu.put("user" , CpuPerc.format(cpuPercs[i].getUser()));// 用户使用率
            cpu.put("sys" , CpuPerc.format(cpuPercs[i].getSys()));// 系统使用率
            cpu.put("wait" , CpuPerc.format(cpuPercs[i].getWait()));// 当前等待率
            cpu.put("nice" , CpuPerc.format(cpuPercs[i].getNice()));//当前错误率
            cpu.put("idle" , CpuPerc.format(cpuPercs[i].getIdle()));// 当前空闲率
            cpu.put("combined" , CpuPerc.format(cpuPercs[i].getCombined()));// 总的使用率
            jsonArray.add(cpu);
        }

        return jsonArray;
    }

    public static void main(String[] args) {
        try {
            System.out.println(CPUCollector.collect().toString());
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }

}
