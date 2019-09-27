package pers.alex.system.collector.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.File;

/**
 * 进程信息存储类
 * @author Alex
 * @date 2019/9/24 13:44
 */
public class Process implements Comparable<Process>{

    public Process() {
    }

    public Process(String pid, String user, String startTime, String virt, String res, String shr, String status, String time, String description) {
        this.pid = pid;
        this.setUser(user);
        this.setStartTime(startTime);
        this.virt = virt;
        this.res = res;
        this.shr = shr;
        this.status = status;
        this.setTime(time);
        this.description = description;
        this.setRealRes(res);
    }

    /**
     * 进程的PID
     */
    private String pid;

    /**
     * 所属用户
     */
    private String user;

    /**
     * 启动时间
     */
    private String startTime;

    /**
     * 虚拟内存
     */
    private String virt;

    /**
     * 常驻内存
     */
    private String res;

    /**
     * 转换为KByte为单位，方便比较大小
     */
    private Double realRes;

    /**
     * 共享内存
     */
    private String shr;

    /**
     * 进程状态（SLEEP = ‘S’;RUN = ‘R’;STOP = ‘T’;ZOMBIE = ‘Z’;IDLE = ‘D’;）
     */
    private String status;

    /**
     * 总时长
     */
    private String time;

    /**
     * 进程所属详细信息
     */
    private String description;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        if (user.equals("???")) {
            this.user = "UNKNOWN";
        } else {
            this.user = user;
        }
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        if (startTime.equals("???")) {
            this.startTime = "UNKNOWN";
        } else {
            this.startTime = startTime;
        }
    }

    public String getVirt() {
        return virt;
    }

    public void setVirt(String virt) {
        this.virt = virt;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        if (time.equals("???")) {
            this.time = "UNKNOWN";
        } else {
            this.time = time;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRealRes() {
        return realRes;
    }
    public void setRealRes(String res) {
        if (res.indexOf("G") >= 0) {
            this.realRes = Double.parseDouble(res.substring(0,res.length()-1)) * 1024 * 1024;
        } else if (res.indexOf("M") >= 0) {
            this.realRes = Double.parseDouble(res.substring(0,res.length() - 1)) * 1024;
        } else if (res.indexOf("K") >= 0) {
            this.realRes = Double.parseDouble(res.substring(0,res.length() - 1));
        } else {
            this.realRes = 0D;
        }
    }

    @Override
    public int compareTo(Process o) {
        return ((int) (o.getRealRes() - this.getRealRes()));
    }

    @Override
    public String toString() {
        return this.toJSONObject().toString();
    }

    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pid", this.getPid());
        jsonObject.put("user", this.getUser());
        jsonObject.put("startTime", this.getStartTime());
        jsonObject.put("virt", this.getVirt());
        jsonObject.put("res", this.getRes());
        jsonObject.put("realRes", this.getRealRes());
        jsonObject.put("shr", this.getShr());
        jsonObject.put("status", this.getStatus());
        jsonObject.put("time", this.getTime());
        jsonObject.put("description", this.getDescription());
        if (this.getDescription().contains("/")) {
            jsonObject.put("name", this.getDescription().substring(this.getDescription().lastIndexOf("/") + 1));
        } else if (this.getDescription().contains("\\")) {
            jsonObject.put("name", this.getDescription().substring(this.getDescription().lastIndexOf("\\") + 1));
        } else if (this.getDescription().contains(".")) {
            jsonObject.put("name", this.getDescription().substring(this.getDescription().lastIndexOf(".") + 1));
        }  else {
            jsonObject.put("name", this.getDescription());
        }
        return jsonObject;
    }


}
