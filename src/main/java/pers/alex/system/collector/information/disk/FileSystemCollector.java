package pers.alex.system.collector.information.disk;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * @author Alex
 * @date 2019/9/20 9:04
 */
public class FileSystemCollector {

    private static Sigar sigar = new Sigar();

    public static JSONArray collect() throws SigarException {

        JSONArray result = new JSONArray();

        FileSystem[] fileSystems = sigar.getFileSystemList();

        for (FileSystem fs : fileSystems) {
            if (fs.getType() != 2) {
                continue;
            }
            JSONObject jsonObject = new JSONObject();
            // 分区的盘符名称
            jsonObject.put("devName" , fs.getDevName());
            // 分区的盘符名称
            jsonObject.put("dirName" , fs.getDirName());

            jsonObject.put("flags" , fs.getFlags());
            // 文件系统类型，比如 FAT32、NTFS
            jsonObject.put("sysTypeName" , fs.getSysTypeName());
            // 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
            jsonObject.put("typeName" , fs.getTypeName());
            // 文件系统类型
            jsonObject.put("type" , fs.getType());

            FileSystemUsage usage = sigar.getFileSystemUsage(fs.getDirName());

            switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘
                    // 文件系统总大小
                    jsonObject.put("total" , usage.getTotal()/1024 + "MB");
                    // 文件系统剩余大小
                    jsonObject.put("free" , usage.getFree()/1024 + "MB");
                    // 文件系统可用大小
                    jsonObject.put("avail" , usage.getAvail()/1024 + "MB");
                    // 文件系统已经使用量
                    jsonObject.put("used" , usage.getUsed()/1024 + "MB");
                    double usePercent = usage.getUsePercent() * 100D;
                    // 文件系统资源的利用率
                    jsonObject.put("percent" , usePercent + "%");
                    break;
                case 3:// TYPE_NETWORK ：网络
                    break;
                case 4:// TYPE_RAM_DISK ：闪存
                    break;
                case 5:// TYPE_CDROM ：光驱
                    break;
                case 6:// TYPE_SWAP ：页面交换
                    break;
            }

            jsonObject.put("diskReads" , usage.getDiskReads());

            jsonObject.put("diskWrites" , usage.getDiskWrites());

            result.add(jsonObject);
        }
        
        return result;

    }

}
