package win.test_ued;

/**
 * Created  2016/6/12.
 */
public class Test {

    public static void main(String[] args) {

        try {
            String d="数学";
            String e=java.net.URLEncoder.encode(d);
            System.out.println(e);
            String ccc=java.net.URLDecoder.decode(e,"UTF-8");

            System.out.println(ccc);
        }catch (Exception e){
            e.getMessage();
        }

    }
}
