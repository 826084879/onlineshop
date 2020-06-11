package com.cooperation.onlineshop.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cooperation.onlineshop.entity.Files;
import com.cooperation.onlineshop.entity.Goods;
import com.cooperation.onlineshop.service.FilesService;
import net.sf.json.JSONArray;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cooperation.onlineshop.common.UuidUtil.getShortUuid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@RestController
@RequestMapping("/files")
public class FilesController {

    @Resource
    FilesService filesService;

    @RequestMapping(value = "/saveFiles", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    public String saveFiles(@RequestParam(value = "files",required = false) MultipartFile[] files, @RequestParam String img_location_json) {
        String res = "FAIL";
        //img_location_json  [{"fileName":"lz.jpg","location":"title"},{"fileName":"xg.jpg","location":"banner"},...]
        JSONArray object= JSONArray.fromObject(img_location_json);
        res=filesService.saveFiles(files,object);
        return res;
    }

}
