package com.cooperation.onlineshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.*;
import com.cooperation.onlineshop.mapper.*;
import com.cooperation.onlineshop.service.FilesService;
import com.cooperation.onlineshop.service.Goods2filesService;
import com.cooperation.onlineshop.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-18
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Resource
    GoodsService goodsService;
    @Resource
    FilesService filesService;
    @Resource
    Goods2filesService goods2filesService;
    @Resource
    GoodsMapper goodsMapper;
    @Resource
    Goods2filesMapper goods2filesMapper;
    @Resource
    FilesMapper filesMapper;
    @Resource
    CommentMapper commentMapper;
    @Resource
    Good2commentMapper good2commentMapper;


    @Transactional
    @Override
    public String addGoods(Goods goods, MultipartFile[] files, JSONArray object) {
        StringBuilder res= new StringBuilder();
        //保存图片
        String filePath = System.getProperty("user.dir") + "\\images\\";
        File fileTemp = new File(filePath);
        if (!fileTemp.exists()) {
            fileTemp.mkdirs();
        }

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.isEmpty()) {
                res.append("第").append(i + 1).append("个文件").append("上传失败;");
                continue;
            }
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取后缀名
            assert fileName != null;
            String[] strArray = fileName.split("\\.");
            String ext=strArray[strArray.length - 1];

            //创建唯一标识
            String uuid = UUID.randomUUID().toString().replace("-", "");
            File dest = new File(filePath + uuid);
            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) + "个文件上传成功");
                res.append("第").append((i + 1)).append("个文件").append(fileName).append("上传成功;");

                Files files1= new Files();
                files1.setId(UuidUtil.getShortUuid());
                files1.setName(dest.getName());
                files1.setPath(dest.getPath());
                files1.setSize(dest.length());
                files1.setExt(ext);
                for (int j = 0; j <object.size() ; j++) {
                    if (fileName.equals(object.getJSONObject(j).getString("name"))) {
                        files1.setLocation(object.getJSONObject(j).getString("location"));
                        break;
                    }
                }
                //保存图片信息
                boolean save = filesService.save(files1);
                if (save) {
                    //保存关联表信息
                    Goods2files goods2files = new Goods2files();
                    goods2files.setId(UuidUtil.getShortUuid());
                    goods2files.setLeftId(goods.getId());
                    goods2files.setRightId(files1.getId());
                    goods2filesService.save(goods2files);
                }

            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                res.append("第").append(i + 1).append("个文件").append(fileName).append("上传失败;");
            }
        }
        //保存商品基本信息
        goods.setModifyTime(LocalDateTime.now());
        goodsService.save(goods);
        return res.toString();
    }

    @Override
    public String updateGoods(Goods goods, MultipartFile[] files, JSONArray object) {
        StringBuilder res= new StringBuilder();

        if (goodsService.getById(goods.getId())==null){
            return "商品唯一标识不存在";
        }
        //保存图片
        String filePath = System.getProperty("user.dir") + "\\images\\";
        File fileTemp = new File(filePath);
        if (!fileTemp.exists()) {
            fileTemp.mkdirs();
        }

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.isEmpty()) {
                res.append("第").append(i + 1).append("个文件").append("上传失败;");
                continue;
            }
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取后缀名
            assert fileName != null;
            String[] strArray = fileName.split("\\.");
            String ext=strArray[strArray.length - 1];

            //创建唯一标识
            String uuid = UUID.randomUUID().toString().replace("-", "");
            File dest = new File(filePath + uuid);
            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) + "个文件上传成功");
                res.append("第").append((i + 1)).append("个文件").append(fileName).append("上传成功;");

                Files files1= new Files();
                files1.setId(UuidUtil.getShortUuid());
                files1.setName(dest.getName());
                files1.setPath(dest.getPath());
                files1.setSize(dest.length());
                files1.setExt(ext);
                for (int j = 0; j <object.size() ; j++) {
                    if (fileName.equals(object.getJSONObject(j).getString("fileName"))) {
                        files1.setLocation(object.getJSONObject(j).getString("location"));
                        break;
                    }
                }
                //保存图片信息
                boolean save = filesService.save(files1);
                if (save) {
                    //保存关联表信息
                    Goods2files goods2files = new Goods2files();
                    goods2files.setId(UuidUtil.getShortUuid());
                    //先清理
                    goodsService.removeById(goods.getId());
                    //再添加
                    goods2files.setLeftId(goods.getId());
                    goods2files.setRightId(files1.getId());
                    goods2filesService.save(goods2files);
                }

            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                res.append("第").append(i + 1).append("个文件").append(fileName).append("上传失败;");
            }
        }
        //保存商品基本信息
        goods.setModifyTime(LocalDateTime.now());
        goodsService.updateById(goods);
        return res.toString();
    }

    @Override
    public String getDetailGoodsMsg(String orderBy, boolean asc) {


        Map<String,Object> map = new HashMap<>();
        map.put("orderBy",orderBy);
        map.put("asc",asc);
        goodsMapper.getDetailGoodsMsg(map);
        return null;
    }

    @Override
    public List<Map<String,Object>> getGoodByName(String name) {
        return goodsMapper.getGoodByName(name);
    }

    @Override
    public JSONArray getAllGoods(String orderBy,boolean isAsc) {
        JSONArray object = new JSONArray();

        //商品数据
        QueryWrapper<Goods> goodQueryWrapper = new QueryWrapper<>();
        goodQueryWrapper.orderBy(true,isAsc,orderBy);
        List<Goods> goods = goodsMapper.selectList(goodQueryWrapper);
        JSONArray jsonObject =JSONArray.fromObject(goods);
        object.add(jsonObject);

        for (int i = 0; i < jsonObject.size(); i++) {
            //文件中间类
            QueryWrapper<Goods2files> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("left_id",jsonObject.getJSONObject(i).getString("id"));
            List<Goods2files> goods2files = goods2filesMapper.selectList(queryWrapper);
            List<String> leftIdList = new ArrayList<>();
            for (Goods2files goods2files1: goods2files ) {
                leftIdList.add(goods2files1.getRightId());
            }

            //文件数据
            if (leftIdList.size()>0) {
                QueryWrapper<Files> filesQueryWrapper = new QueryWrapper<>();
                filesQueryWrapper.in("id", leftIdList);
                List<Files> filesList = filesMapper.selectList(filesQueryWrapper);
                jsonObject.getJSONObject(i).put("files", filesList);
            }
            //评论中间类
            QueryWrapper<Good2comment> commentQueryWrapper = new QueryWrapper<>();
            commentQueryWrapper.eq("left_id",jsonObject.getJSONObject(i).getString("id"));
            List<Good2comment> good2commentList = good2commentMapper.selectList(commentQueryWrapper);
            List<String> leftIdListCommon = new ArrayList<>();
            for (Good2comment good2comment: good2commentList ) {
                leftIdListCommon.add(good2comment.getRightId());
            }

            //评论数据
            if (leftIdListCommon.size()>0) {
                QueryWrapper<Comment> commentQueryWrapper1 = new QueryWrapper<>();
                commentQueryWrapper1.in("id", leftIdListCommon);
                List<Comment> commentList = commentMapper.selectList(commentQueryWrapper1);
                jsonObject.getJSONObject(i).put("comments", commentList);
            }
        }

        return object;
    }
}
