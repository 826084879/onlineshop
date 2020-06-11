package com.cooperation.onlineshop.service;

import com.cooperation.onlineshop.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
public interface CommentService extends IService<Comment> {

    boolean addComment(Comment comment, String goodsId);
}
