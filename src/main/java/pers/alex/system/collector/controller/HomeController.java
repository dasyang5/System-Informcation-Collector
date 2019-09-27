package pers.alex.system.collector.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hyperic.sigar.SigarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.alex.system.collector.information.disk.FileSystemCollector;
import pers.alex.system.collector.information.User.UserCollector;
import pers.alex.system.collector.information.cpu.CPUCollector;
import pers.alex.system.collector.information.memory.MemoryCollector;
import pers.alex.system.collector.information.network.EthernetCollector;
import pers.alex.system.collector.information.network.NetCollector;
import pers.alex.system.collector.information.process.ProcessCollector;
import pers.alex.system.collector.information.system.JVMSystemCollector;
import pers.alex.system.collector.information.system.SystemCollector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author Alex
 * @date 2019/9/19 15:26
 */
@Controller
@RequestMapping("/information")
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/getCpuInfo")
    @ResponseBody
    public JSONObject getCpuInfo() {
        JSONObject result = new JSONObject();
        try {
            result.put("array", CPUCollector.collect());
            result.put("code", 0);
        } catch (SigarException e) {
            e.printStackTrace();
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getMemoryInfo")
    @ResponseBody
    public JSONObject getMemoryInfo() {

        JSONObject result;

        try {
            result = MemoryCollector.collect();
            result.put("code", 0);
        } catch (SigarException e) {
            e.printStackTrace();
            result = new JSONObject();
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }

        return result;
    }

    @RequestMapping("/getSystemInfo")
    @ResponseBody
    public JSONObject getSystemInfo() {

        JSONObject result;

        try {
            result = SystemCollector.collect();
            result.put("code", 0);
        } catch (Exception e) {
            e.printStackTrace();
            result = new JSONObject();
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }

        return result;
    }

    @RequestMapping("/getSystemInfoFromJava")
    @ResponseBody
    public JSONObject getSystemInfoFromJava() {

        JSONObject result;

        try {
            result = JVMSystemCollector.collect();
            result.put("code", 0);
        } catch (Exception e) {
            e.printStackTrace();
            result = new JSONObject();
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }

        return result;
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public JSONObject getUserInfo() {
        JSONObject result = new JSONObject();
        try {
            result.put("array", UserCollector.collect());
            result.put("code", 0);
        } catch (SigarException e) {
            e.printStackTrace();
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getFileSystemInfo")
    @ResponseBody
    public JSONObject getFileSystemInfo() {
        JSONObject result = new JSONObject();
        try {
            result.put("array", FileSystemCollector.collect());
            result.put("code", 0);
        } catch (SigarException e) {
            e.printStackTrace();
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getNetworkInfo")
    @ResponseBody
    public JSONObject getNetworkInfo() {
        JSONObject result = new JSONObject();
        try {
            result.put("array", NetCollector.collect());
            result.put("code", 0);
        } catch (SigarException e) {
            e.printStackTrace();
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getEthernetInfo")
    @ResponseBody
    public JSONObject getEthernetInfo() {
        JSONObject result = new JSONObject();
        try {
            result.put("array", EthernetCollector.collect());
            result.put("code", 0);
        } catch (SigarException e) {
            e.printStackTrace();
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getCpuHistoryData")
    @ResponseBody
    public JSONObject getCpuHistoryData(){
        JSONObject result = new JSONObject();

        try {
            JSONArray jsonArray = new JSONArray();

            for (int i = 30; i > 0; i--) {

                JSONObject obj = new JSONObject();
                obj.put("date", getBeforeDaysDateString(i));
                obj.put("peak", new Random().nextInt(20) + 30);
                obj.put("average", new Random().nextInt(30));
                jsonArray.add(obj);
            }
            result.put("array", jsonArray);
            result.put("code", 0);
        } catch (Exception e) {
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }

        return result;
    }

    @RequestMapping("/getNetworkHistoryData")
    @ResponseBody
    public JSONObject getNetworkHistoryData() {

        JSONObject result = new JSONObject();

        try {
            JSONArray jsonArray = new JSONArray();

            for (int i = 30; i > 0; i--) {

                JSONObject obj = new JSONObject();
                obj.put("date", getBeforeDaysDateString(i));
                obj.put("write", new Random().nextInt(20000) + 30000);
                obj.put("read", new Random().nextInt(30000));
                jsonArray.add(obj);
            }
            result.put("array", jsonArray);
            result.put("code", 0);
        } catch (Exception e) {
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }

        return result;
    }

    @RequestMapping("/getCpuUseList")
    @ResponseBody
    public JSONObject getCpuUseList() {
        JSONObject result = new JSONObject();

        try {
            JSONArray jsonArray = ProcessCollector.collect();
            result.put("array", jsonArray);
            result.put("code", 0);
        } catch (Exception e) {
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }

        return result;
    }

    @RequestMapping("/getDynamicData")
    @ResponseBody
    public JSONObject getDynamicData(){

        JSONObject result = new JSONObject();

        try {

            //硬盘信息
            JSONArray fileSystemArray = FileSystemCollector.collect();
            JSONArray fileSystemResult = new JSONArray();
            Long fileSystemRead = 0L;
            Long fileSystemWrite = 0L;
            double fileSystemAvailableSpace = 0d;
            double fileSystemTotalSpace = 0d;

            for (Object obj : fileSystemArray) {
                fileSystemRead += ((JSONObject) obj).getLong("diskReads");
                fileSystemWrite += ((JSONObject) obj).getLong("diskWrites");
                fileSystemAvailableSpace += ((JSONObject) obj).getDouble("avail");
                fileSystemTotalSpace += ((JSONObject) obj).getDouble("total");

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("devName", ((JSONObject) obj).getString("dirName"));
                jsonObject.put("avail", ((JSONObject) obj).getString("avail"));
                jsonObject.put("used", ((JSONObject) obj).getString("used"));
                fileSystemResult.add(jsonObject);
            }
            result.put("fileSystemRead", fileSystemRead);//文件系统读
            result.put("fileSystemWrite", fileSystemWrite);//文件系统写
            result.put("fileSystemAvailableSpace", fileSystemAvailableSpace);//文件系统可用空间 mb
            result.put("fileSystemUsePercent", ((fileSystemTotalSpace - fileSystemAvailableSpace) / fileSystemTotalSpace) + "%");//文件系统使用百分比
            result.put("fileSystemDetail", fileSystemResult);

            //任务列表
            result.put("processes", ProcessCollector.collect());//任务TOP10

            //jvm内存
            JSONObject systemInformationFromJava = JVMSystemCollector.collect();
            result.put("totalMemoryJVM", systemInformationFromJava.getString("totalMemory"));//jvm总内存   单位字节
            result.put("freeMemoryJVM", systemInformationFromJava.getString("freeMemory"));//jvm可用内存   单位字节

            //网络IO
            JSONArray networkArray = NetCollector.collect();
            Long sendBytes = 0L;
            Long receiveBytes = 0L;
            for (Object obj : networkArray) {
                sendBytes += ((JSONObject) obj).getLong("txBytes");
                receiveBytes += ((JSONObject) obj).getLong("rxBytes");
            }
            result.put("sendBytes", sendBytes);//接收总字节数
            result.put("receiveBytes", receiveBytes);//发送总字节数

            //CPU使用率
            JSONArray cpuArray = CPUCollector.collect();
            double cpuUsedPercent = 0d;
            for (Object obj : cpuArray) {
                String percent = ((JSONObject) obj).getString("combined");
                cpuUsedPercent += Double.parseDouble(percent.substring(0, percent.length() - 1));
            }
            result.put("cpuCombinedPercent", cpuUsedPercent / cpuArray.size() + "%");

            //内存
            JSONObject memoryJSONObject = MemoryCollector.collect();
            result.put("memoryTotal", memoryJSONObject.getString("total"));
            result.put("memoryUsed", memoryJSONObject.getString("user"));
            result.put("memoryFree", memoryJSONObject.getString("free"));

            result.put("code", 0);

        } catch (Exception e) {
            result = new JSONObject();
            result.put("code", 1);
            result.put("msg", e.getMessage());
        }

        return result;
    }


    private String getBeforeDaysDateString(int days) {
        return LocalDate.now().plusDays(-days).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


}
