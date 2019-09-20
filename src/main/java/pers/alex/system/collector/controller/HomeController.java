package pers.alex.system.collector.controller;

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
import pers.alex.system.collector.information.system.JVMSystemCollector;
import pers.alex.system.collector.information.system.SystemCollector;

/**
 * @author Alex
 * @date 2019/9/19 15:26
 */
@Controller
@RequestMapping("/")
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
}
