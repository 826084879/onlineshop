package com.cooperation.onlineshop.controller;


import com.cooperation.onlineshop.entity.Comment;
import com.cooperation.onlineshop.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    CommentService commentService;

    @PostMapping("/add")
    public boolean addComment(@RequestBody Comment comment, @RequestParam String goodsId){
        return commentService.addComment(comment, goodsId);
    }

}
