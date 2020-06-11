package com.cooperation.onlineshop.service.impl;

import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.Files;
import com.cooperation.onlineshop.mapper.FilesMapper;
import com.cooperation.onlineshop.service.FilesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cooperation.onlineshop.service.Goods2filesService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@Service
public class FilesServiceImpl extends ServiceImpl<FilesMapper, Files> implements FilesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilesServiceImpl.class);
    @Resource
    FilesService filesService;

    /**
     * 批量上传文件
     * @param files 文件
     * @param imgUseJson 文件说明
     * @return String
     */
    @Transactional
    @Override
    public String saveFiles(MultipartFile[] files, JSONArray imgUseJson) {
        JSONArray array = new JSONArray();
        //保存图片
        String filePath = System.getProperty("user.dir") + "\\images\\";
        File fileTemp = new File(filePath);
        if (!fileTemp.exists()) {
            fileTemp.mkdirs();
        }

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.isEmpty()) {
                LOGGER.error("第"+(i + 1)+"个文件上传失败;");
                continue;
            }
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取后缀名
            assert fileName != null;

            //创建唯一标识
            String uuid = UUID.randomUUID().toString().replace("-", "");
            File dest = new File(filePath + uuid);
            String result="fail";
            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) +fileName+ "个文件上传成功");
                Files files1= new Files();
                String ext = fileName.substring(fileName.lastIndexOf("."));
                files1.setId(UuidUtil.getShortUuid());
                files1.setName(dest.getName());
                files1.setPath(dest.getPath());
                files1.setSize(dest.length());
                files1.setExt(ext);
                for (int j = 0; j <imgUseJson.size() ; j++) {
                    if (fileName.equals(imgUseJson.getJSONObject(j).getString("fileName"))) {
                        files1.setLocation(imgUseJson.getJSONObject(j).getString("location"));
                        break;
                    }
                }
                //保存图片信息
                boolean save = filesService.save(files1);

                result=dest.getName();
            } catch (IOException e) {
                LOGGER.error(e.toString()+"第" + (i + 1) +fileName+ "个文件上传失败", e);
            }
            JSONObject object = new JSONObject();
            object.put("id",uuid);
            object.put("fileName",result);
            array.add(object);
        }

        return array.toString();
    }

}
