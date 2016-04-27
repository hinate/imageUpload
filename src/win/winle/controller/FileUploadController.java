package win.winle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import win.winle.entity.winImage;
import win.winle.service.winImageService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created  2016/3/22.
 */
@Controller
@RequestMapping("fuController")
public class FileUploadController {

    @Autowired
    @Qualifier("wiService")
    private winImageService winService;
	/*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("/springUpload.htm")
    @ResponseBody
    public String  springUpload(HttpServletRequest request, winImage winimage) throws IllegalStateException, IOException
    {
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver( request.getSession().getServletContext());
        //生成文件名
        String filename=UUID.randomUUID().toString().replace("-", "");//文件名
        String id = UUID.randomUUID().toString().replace("-", "");//用来生成数据库的主键id
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String newDate=df.format(new Date());//当前时间

        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                //文件格式
                 String filesuffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
                if(file!=null) {
                    String filenames=filename+"."+filesuffix;//文件名
                    String path=newDate.substring(0,4)+"/"+newDate.substring(5,7)+"/"+newDate.substring(8,10);
                    String filePath = request.getSession().getServletContext().getRealPath("/")+"templete/" ;
                    mkdir(filePath+path);//新建文件夹

                    String filePaths=request.getSession().getServletContext().getRealPath("/")+"templete/" +path+filenames;
                    System.out.println(filePaths);
                    //上传
                    file.transferTo(new File(filePaths));
                    //保存数据库
                    winimage.setId(id); //id
                    winimage.setImageName(filenames); //文件名
                    winimage.setImageUrl("/templete/"+path+"/"+filenames);
                    winimage.setTimetamp(newDate);
                    winimage.setImageSize(String.valueOf(file.getSize()));
                    winService.save(winimage);
                }
            }
        }
        String Message = "";
        Message +="192.168.210.51:8080"+winimage.getImageUrl();
        return "" + Message + "";
    }

    // 创建文件上传路径
    public static void mkdir(String path) {
        File fd = null;
        try {
            fd = new File(path);
            if (!fd.exists()) {
                fd.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fd = null;
        }
    }
}
