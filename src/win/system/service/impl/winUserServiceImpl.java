package win.system.service.impl;

import org.springframework.stereotype.Service;
import win.system.entity.winUser;
import win.system.mapper.winUserMapper;
import win.system.service.winUserService;

/**
 * Created  2016/3/25.
 */
@Service("wuService")
public class winUserServiceImpl implements winUserService {

    private winUserMapper winuserMapper;

    //新增用户
    public  void save(winUser winuser){
        winuserMapper.save(winuser);
    }

    //登录验证
    public winUser findByname(String pacount) {
        return winuserMapper.findByname(pacount);
    }
}
