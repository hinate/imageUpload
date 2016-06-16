package win.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import win.system.common.CommonUtil;
import win.system.entity.winUser;
import win.system.service.winUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created  2016/3/25.
 */
@Controller
@RequestMapping("registerController")
public class registerController {
    @Autowired
    @Qualifier("wuService")
    private winUserService winUserService;

    @RequestMapping("/register.htm")
    @ResponseBody
    public  String register(winUser winuser, HttpServletRequest request){

        String id= UUID.randomUUID().toString().replace("-","");

        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        winuser.setId(id);
        winuser.setTimetamp(df.format(new Date()));
        winUserService.save(winuser);
        return "success";
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public String checkEmail(winUser winuser,HttpSession session,String email){
        String generate= CommonUtil.generateString();
        StringBuffer sb = new StringBuffer("注册验证码 ：")
                .append(generate).append("  ,验证码当日提交有效！");
        //emailUtil.sedEmail(email,sb.toString());
        return "success";

    }
}
