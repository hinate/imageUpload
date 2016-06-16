package win.system.entity;

import java.io.Serializable;

/**
 * Created  2016/3/22.
 */
public class winUser  implements Serializable {

    private  String id;//主键
    private  String userName;//用户名
    private  String password;//密码
    private  String email;//邮箱
    private  String timetamp;//时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimetamp() {
        return timetamp;
    }

    public void setTimetamp(String timetamp) {
        this.timetamp = timetamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
