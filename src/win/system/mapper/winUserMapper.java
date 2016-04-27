package win.system.mapper;

import win.system.entity.winUser;

/**
 * Created  2016/3/25.
 */
public interface winUserMapper {

    //新增用户
    void save (winUser winuser);
    //登录验证
    winUser findByname(String pacount);
}
