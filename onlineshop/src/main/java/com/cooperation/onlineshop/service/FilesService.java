package com.cooperation.onlineshop.service;

import com.cooperation.onlineshop.entity.Files;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cooperation.onlineshop.entity.Goods;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
public interface FilesService extends IService<Files> {

//    String batchFiles(String goodsId, MultipartFile[] files, String imgUseJson);

    String saveFiles(MultipartFile[] files, JSONArray object);

}
