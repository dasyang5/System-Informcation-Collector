package pers.alex.system.collector.information.memory;

import com.alibaba.fastjson.JSONObject;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

/**
 * @author Alex
 * @date 2019/9/19 16:57
 */
public class MemoryCollector {

    private static Sigar sigar = new Sigar();

    public static JSONObject collect() throws SigarException {

        JSONObject result = new JSONObject();

        //系统内存信息
        Mem mem = sigar.getMem();
        //系统页面文件交换区信息
        Swap swap = sigar.getSwap();

        // 内存总量
        result.put("Total" , mem.getTotal() / (1024L*1024L) + "MB");
        // 当前内存使用量
        result.put("User" , mem.getUsed() / (1024L*1024L) + "MB");
        // 当前内存剩余量
        result.put("Free" , mem.getFree() / (1024L*1024L) + "MB");

        // 交换区总量
        result.put("SwapTotal" ,swap.getTotal() / (1024L*1024L) + "MB");
        // 当前交换区使用量
        result.put("SwapUsed" ,swap.getUsed() / (1024L*1024L) + "MB");
        // 当前交换区剩余量
        result.put("SwapFree" ,swap.getFree() / (1024L*1024L) + "MB");

        return result;
    }

    public static void main(String[] args) {
        try {
            MemoryCollector.collect();
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }

}
