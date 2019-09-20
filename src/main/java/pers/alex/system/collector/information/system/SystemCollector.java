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
        result.put("Arch" , OS.getArch());//操作系统
        result.put("CpuEndian" , OS.getCpuEndian());//操作系统CpuEndian
        result.put("DataModel" , OS.getDataModel());//操作系统DataModel
        // 系统描述
        result.put("Description" , OS.getDescription());//操作系统的描述
        // 操作系统类型
        result.put("Name" , OS.getName());
        result.put("PatchLevel" , OS.getPatchLevel());
        // 操作系统的卖主
        result.put("Vendor" , OS.getVendor());//操作系统的卖主
        // 卖主名称
        result.put("VendorCodeName" , OS.getVendorCodeName());//操作系统的卖主名
        // 操作系统名称
        result.put("VendorName" , OS.getVendorName());//操作系统名称
        // 操作系统卖主类型
        result.put("VendorVersion" , OS.getVendorVersion());//操作系统卖主类型
        // 操作系统的版本号
        result.put("Version" , OS.getVersion());//操作系统的版本号

        return result;

    }

}
