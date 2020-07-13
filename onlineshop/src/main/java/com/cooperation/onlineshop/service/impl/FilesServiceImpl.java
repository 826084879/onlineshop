package com.cooperation.onlineshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.Files;
import com.cooperation.onlineshop.entity.Goods2files;
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
import java.util.*;

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
//    @Resource
//    Goods2filesService goods2filesService;
    @Resource
    FilesMapper filesMapper;

    /**
     * 批量上传文件
     * @param files 文件
     * @param goodsId 商品id 用户id
     * @return String
     */
    @Transactional
    @Override
    public String saveFiles(List<MultipartFile> files, String goodsId,String operator,int location) {
        JSONArray array = new JSONArray();

        String uuid=UUID.randomUUID().toString().replace("-", "");
        String tempGoodsId="";
        if (!"".equals(goodsId)) {
            tempGoodsId=goodsId;
        }else{
            tempGoodsId=UuidUtil.getShortUuid();
        }
        //保存图片
        String filePath = System.getProperty("user.dir") + "\\images\\";
        File fileTemp = new File(filePath);
        if (!fileTemp.exists()) {
            fileTemp.mkdirs();
        }

        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                LOGGER.error("第"+(i + 1)+"个文件上传失败;");
                continue;
            }
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取后缀名
            assert fileName != null;

            //创建唯一标识

            File dest = new File(filePath + uuid);
            Files files1= new Files();
            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) +fileName+ "个文件上传成功");

                String ext = fileName.substring(fileName.lastIndexOf("."));
                files1.setId(UuidUtil.getShortUuid());
                files1.setName(dest.getName());
                files1.setPath(dest.getPath()+ext);
                files1.setSize(dest.length());
                files1.setExt(ext);
                files1.setOperator(operator);
                //保存图片信息
                filesService.save(files1);
            } catch (IOException e) {
                LOGGER.error(e.toString()+"第" + (i + 1) +fileName+ "个文件上传失败", e);
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",tempGoodsId);
            jsonObject.put("fileName",files1.getPath()+files1.getExt());
            array.add(jsonObject);
        }

        return array.toString();
    }

    @Override
    public String getBannerImgs() {
        List<Map<String, Object>> bannerImgs = filesMapper.getBannerImgs();
        JSONArray array = new JSONArray();
        if (bannerImgs.size()>0) {

            for (Map<String, Object> map : bannerImgs) {
                if (array.size()>6) {//最多六个
                    break;
                }
                boolean had=false;
                for (int i = 0; i < array.size(); i++) {//每个商品最多显示一张图片
                    if (array.getJSONObject(i).getString("id").equals(map.get("id"))){
                        had=true;
                        break;
                    }
                }
                if (!had){
                    JSONObject object = new JSONObject();
                    object.put("id",map.get("id"));
                    object.put("path",map.get("path"));
                    array.add(object);
                }


            }
        }
        return array.toString();
    }


}
