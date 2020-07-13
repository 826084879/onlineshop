package com.cooperation.onlineshop.controller;

import com.cooperation.onlineshop.mapper.FilesMapper;
import com.cooperation.onlineshop.service.FilesService;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @PostMapping("/saveFiles")
    public String saveFiles(HttpServletRequest request) {
        List<MultipartFile> files=((MultipartHttpServletRequest)request).getFiles("files");
        return filesService.saveFiles(files,request.getParameter("goodsId"),request.getParameter("operator"),Integer.parseInt(request.getParameter("location")));
    }

    @GetMapping("/banners")
    public String getBannerImgs(){
        return filesService.getBannerImgs();
    }

}
