package win.winle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.winle.entity.winImage;
import win.winle.mapper.winImageMapper;
import win.winle.service.winImageService;

/**
 * Created  2016/3/25.
 */
@Service("wiService")
public class winImageServiceImpl implements winImageService {
    @Autowired
    private winImageMapper winimageMapper;
    @Override
    public void save(winImage wimage) {
        winimageMapper.save(wimage);
    }
}
