package win.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import win.system.entity.winUser;
import win.system.service.winUserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created  2016/3/25.
 */
@Controller
@RequestMapping("loginController")
public class loginController {

    @Autowired
    @Qualifier("wuService")
    private winUserService wuService;
    /**
     * 进入主页面
     * @return
     */
    @RequestMapping("/toMain.htm")
    public String toMain(){
        return "index";
    }

    /**
     * 进入登录页
     * @return
     */
    @RequestMapping("/toLogin.htm")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login.htm")
    @ResponseBody
    public Map<String,String> loginUser(String pacount, String password , HttpSession session){
        Map<String,String> map=new HashMap<String, String>();
        winUser winu=wuService.findByname(pacount);
        if(winu!=null&&!"".equals(winu.getEmail())){
            if(!pacount.equals(winu.getEmail())&&!password.equals(winu.getPassword())){
                map.put("flag", "1");
                map.put("msg", "密码输入错误！");
            }else{
                session.setAttribute("pacount",pacount);
                map.put("flag", "success");
                map.put("msg", "登陆成功！");
            }
        }
        return map;
    }

    /**登出
     * @param session
     * @return
     */
    @RequestMapping("/getOut.htm")
    @ResponseBody
    public Map<String,String>  getOut(HttpSession session){
        Map<String,String> map = new HashMap<String,String>();
        try {
            session.invalidate();
            map.put("flag", "success");
            map.put("msg", "退出成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "failure");
            map.put("msg", "退出失败，请联系管理员！");
            return map;
        }
        return map;
    }

}
