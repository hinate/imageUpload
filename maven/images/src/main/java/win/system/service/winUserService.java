package win.system.service;

import win.system.entity.winUser;

/**
 * Created  2016/3/25.
 */
public interface winUserService {

    //新增用户
    void save (winUser winuser);
    //登录验证
    winUser findByname(String pacount);
    winUser findByID(String id);
}
