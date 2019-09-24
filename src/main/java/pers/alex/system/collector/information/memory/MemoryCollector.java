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
        result.put("total" , mem.getTotal() / (1024L*1024L));
        // 当前内存使用量
        result.put("user" , mem.getUsed() / (1024L*1024L));
        // 当前内存剩余量
        result.put("free" , mem.getFree() / (1024L*1024L));

        // 交换区总量
        result.put("swapTotal" ,swap.getTotal() / (1024L*1024L));
        // 当前交换区使用量
        result.put("swapUsed" ,swap.getUsed() / (1024L*1024L));
        // 当前交换区剩余量
        result.put("swapFree" ,swap.getFree() / (1024L*1024L));

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
