package com.cooperation.onlineshop.config;

import com.cooperation.onlineshop.mapper.FilesMapper;
import com.cooperation.onlineshop.service.FilesService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//@Component
public class FileScheduler {
    @Resource
    FilesMapper filesMapper;
    @Resource
    FilesService filesService;

    //1.定时删除无用图片
    //每周2点 删除一次 删除那些在商品表中标签中不存在的图片 且有商品id
    @Scheduled(cron = "* * * * * 1")
    @Transactional
    void delFiles(){
        try{
            List<String> list= filesMapper.getDelFiles();
            filesService.removeByIds(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
