package com.cooperation.onlineshop.service.impl;

import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.Comment;
import com.cooperation.onlineshop.entity.Good2comment;
import com.cooperation.onlineshop.mapper.CommentMapper;
import com.cooperation.onlineshop.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cooperation.onlineshop.service.Good2commentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    CommentService commentService;
    @Resource
    Good2commentService good2commentService;

    @Transactional
    @Override
    public boolean addComment(Comment comment, String goodsId) {

        //保存到评论表
        comment.setId(UuidUtil.getShortUuid());
        commentService.save(comment);

        //保存到关联表
        Good2comment good2comment = new Good2comment();
        good2comment.setId(UuidUtil.getShortUuid());
        good2comment.setLeftId(goodsId);
        good2comment.setRightId(comment.getId());
        good2commentService.save(good2comment);
        return false;
    }
}
