package win.system.common;

import java.util.Random;

/**
 * Created  2016/3/25.
 */
public class CommonUtil {

    //生成一个6为的随机字符串---验证码
    public static String generateString() {
        String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length=6;
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }
}
