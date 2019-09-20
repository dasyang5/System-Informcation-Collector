package pers.alex.system.collector.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Alex
 * @date 2019/9/20 16:46
 */
@Entity
@Table(name = "user")
public class User {

    private User id;

    private String userName;

    private String password;

    private Date createTime;

    private Date updateTime;

    @Id
    @Column(name = "id",length = 32)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

    @Column(name = "userName",length = 32,nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password",length = 64,nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "createTime",nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "updateTime", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
