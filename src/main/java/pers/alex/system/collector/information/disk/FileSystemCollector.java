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
            JSONObject jsonObject = new JSONObject();
            // 分区的盘符名称
            jsonObject.put("DevName" , fs.getDevName());
            // 分区的盘符名称
            jsonObject.put("DirName" , fs.getDirName());

            jsonObject.put("Flags" , fs.getFlags());
            // 文件系统类型，比如 FAT32、NTFS
            jsonObject.put("SysTypeName" , fs.getSysTypeName());
            // 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
            jsonObject.put("TypeName" , fs.getTypeName());
            // 文件系统类型
            jsonObject.put("Type" , fs.getType());

            FileSystemUsage usage = sigar.getFileSystemUsage(fs.getDirName());

            switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘
                    // 文件系统总大小
                    jsonObject.put("Total" , usage.getTotal()/1024 + "MB");
                    // 文件系统剩余大小
                    jsonObject.put("Free" , usage.getFree()/1024 + "MB");
                    // 文件系统可用大小
                    jsonObject.put("Avail" , usage.getAvail()/1024 + "MB");
                    // 文件系统已经使用量
                    jsonObject.put("Used" , usage.getUsed()/1024 + "MB");
                    double usePercent = usage.getUsePercent() * 100D;
                    // 文件系统资源的利用率
                    jsonObject.put("Percent" , usePercent + "%");
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

            jsonObject.put("DiskReads" , usage.getDiskReads());

            jsonObject.put("DiskWrites" , usage.getDiskWrites());

            result.add(jsonObject);
        }
        
        return result;

    }

}
