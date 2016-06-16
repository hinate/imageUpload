package win.winle.entity;

import java.io.Serializable;

/**
 * Created  2016/3/22.
 */
public class winImage implements Serializable {

    private  String id;
    private  String userId;//用户id
    private  String imageUrl;//图片地址
    private  String imageSize;//图片大小
    private  String imageName;//图片名称
    private  String timetamp;//时间
    private  String url;//地址

    public winImage() {
        super();
    }

    public winImage(String id, String userId, String imageUrl, String imageSize, String imageName, String timetamp, String url) {
        this.id = id;
        this.userId = userId;
        this.imageUrl = imageUrl;
        this.imageSize = imageSize;
        this.imageName = imageName;
        this.timetamp = timetamp;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getTimetamp() {
        return timetamp;
    }

    public void setTimetamp(String timetamp) {
        this.timetamp = timetamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
