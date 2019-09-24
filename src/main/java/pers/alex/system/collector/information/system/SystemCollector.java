package pers.alex.system.collector.information.system;

import com.alibaba.fastjson.JSONObject;
import org.hyperic.sigar.OperatingSystem;

/**
 * @author Alex
 * @date 2019/9/19 17:16
 */
public class SystemCollector {

    public static JSONObject collect(){

        JSONObject result = new JSONObject();

        // 取当前操作系统的信息
        OperatingSystem OS = OperatingSystem.getInstance();
        // 操作系统内核类型如： 386、486、586等x86
        result.put("arch" , OS.getArch());//操作系统
        result.put("cpuEndian" , OS.getCpuEndian());//操作系统CpuEndian
        result.put("dataModel" , OS.getDataModel());//操作系统DataModel
        // 系统描述
        result.put("description" , OS.getDescription());//操作系统的描述
        // 操作系统类型
        result.put("name" , OS.getName());
        result.put("patchLevel" , OS.getPatchLevel());
        // 操作系统的卖主
        result.put("vendor" , OS.getVendor());//操作系统的卖主
        // 卖主名称
        result.put("vendorCodeName" , OS.getVendorCodeName());//操作系统的卖主名
        // 操作系统名称
        result.put("vendorName" , OS.getVendorName());//操作系统名称
        // 操作系统卖主类型
        result.put("vendorVersion" , OS.getVendorVersion());//操作系统卖主类型
        // 操作系统的版本号
        result.put("version" , OS.getVersion());//操作系统的版本号

        return result;

    }

}
