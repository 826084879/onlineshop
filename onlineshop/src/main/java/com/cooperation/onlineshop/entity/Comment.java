package com.cooperation.onlineshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_comment")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 名称
     */
    private String customerId;

    /**
     * 产地
     */
    private String content;

    /**
     * 评论时间
     */
    private Integer publicTime;

    /**
     * 评分等级
     */
    private Integer score;

    @TableField("extrafield_A")
    private String extrafieldA;

    @TableField("extrafield_B")
    private String extrafieldB;

    @TableField("extrafield_C")
    private String extrafieldC;

    @TableField("extrafield_D")
    private String extrafieldD;

    @TableField("extrafield_E")
    private String extrafieldE;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}