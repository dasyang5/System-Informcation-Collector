package pers.alex.system.collector.information.system;

import com.alibaba.fastjson.JSONObject;
import org.hyperic.sigar.Sigar;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

/**
 * @author Alex
 * @date 2019/9/20 9:39
 */
public class JVMSystemCollector {

    public static JSONObject collect() throws UnknownHostException {

        JSONObject result = new JSONObject();

        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr;
        addr = InetAddress.getLocalHost();

        Map<String, String> map = System.getenv();
        result.put("userName" , map.get("USERNAME"));
        result.put("computerName" , map.get("COMPUTERNAME"));
        result.put("userDomain" , map.get("USERDOMAIN"));
        result.put("ip" , addr.getHostAddress());
        result.put("hostName" , addr.getHostName());
        result.put("totalMemory" , r.totalMemory());
        result.put("freeMemory" , r.freeMemory());
        result.put("availableProcessors" , r.availableProcessors());
        result.put("javaVersion" , props.getProperty("java.version"));
        result.put("javaVendor" , props.getProperty("java.vendor"));
        result.put("javaVendorUrl" , props.getProperty("java.vendor.url"));
        result.put("javaHome" , props.getProperty("java.home"));
        result.put("javaVmSpecificationVersion" , props.getProperty("java.vm.specification.version"));
        result.put("javaVmSpecificationVendor" , props.getProperty("java.vm.specification.vendor"));
        result.put("javaVmSpecificationName" , props.getProperty("java.vm.specification.name"));
        result.put("javaVmVersion" , props.getProperty("java.vm.version"));
        result.put("javaVmVendor" , props.getProperty("java.vm.vendor"));
        result.put("javaVmName" , props.getProperty("java.vm.name"));
        result.put("javaSpecificationVersion" , props.getProperty("java.specification.version"));
        result.put("javaSpecificationVendor" , props.getProperty("java.specification.vendor"));
        result.put("javaSpecificationName" , props.getProperty("java.specification.name"));
        result.put("javaClassVersion" , props.getProperty("java.class.version"));
        result.put("javaClassPath" , props.getProperty("java.class.path"));
        result.put("javaLibraryPath" , props.getProperty("java.library.path"));
        result.put("javaIoTmpdir" , props.getProperty("java.io.tmpdir"));
        result.put("javaExtDirs" , props.getProperty("java.ext.dirs"));
        result.put("osName" , props.getProperty("os.name"));
        result.put("osArch" , props.getProperty("os.arch"));
        result.put("osVersion" , props.getProperty("os.version"));
        result.put("fileSeparator" , props.getProperty("file.separator"));
        result.put("pathSeparator" , props.getProperty("path.separator"));
        result.put("lineSeparator" , props.getProperty("line.separator"));
        result.put("userAccountName" , props.getProperty("user.name"));
        result.put("userHome" , props.getProperty("user.home"));
        result.put("userDir" , props.getProperty("user.dir"));
        
        return result;
        
    }

}
