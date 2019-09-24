package pers.alex.system.collector.information.process;

import com.alibaba.fastjson.JSONArray;
import org.apache.tomcat.jni.Proc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.Ps;
import pers.alex.system.collector.bean.Process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Alex
 * [0]进程ID
 * [1]进程所属用户名,取得不到的话返回的是???并不是乱码
 * [2]启动时间
 * [3]进程的虚拟内存
 * [4]进程的常驻内存
 * [5]进程的共享内存(如果这一块取不到的话只会返回一个？？？所以内存占用状态取不到数组长度会少2，所以要小心越界)
 * [6]进程状态（SLEEP = ‘S’;RUN = ‘R’;STOP = ‘T’;ZOMBIE = ‘Z’;IDLE = ‘D’;）
 * [7]总时长
 * [8]进程所属详细信息
 * ————————————————
 * @date 2019/9/24 11:57
 */
public class ProcessCollector {

    private static Sigar sigar = new Sigar();

    public static JSONArray collect() throws SigarException {

        JSONArray jsonArray = new JSONArray();

        List<Process> processes = new ArrayList<>();

        for (Long pid : sigar.getProcList()) {
            Ps ps = new Ps();
            List<String> list = ps.getInfo(sigar, pid);
            Process process = new Process(
                    list.get(0),
                    list.get(1),
                    list.get(2),
                    list.get(3),
                    list.get(4),
                    list.get(5),
                    list.get(6),
                    list.get(7),
                    list.get(8)
            );
            processes.add(process);
        }
        Collections.sort(processes);

        for (int i = 0; i < 10; i++) {
            jsonArray.add(processes.get(i).toJSONObject());
        }

        return jsonArray;
    }

}
