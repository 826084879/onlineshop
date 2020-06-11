package com.cooperation.onlineshop.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseEntity<T extends Model> extends Model implements Serializable {

    @TableField(value = "creator", fill = FieldFill.INSERT)
    private String creator;
    @TableField(value = "modifier", fill = FieldFill.INSERT_UPDATE)
    private String modifier;
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "modifyTime", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;
    @TableField(value = "deleteFlag", fill = FieldFill.INSERT)
    private int deleteFlag;
    @TableField(value = "deleteFlag", fill = FieldFill.INSERT)
    private String remark;


}
