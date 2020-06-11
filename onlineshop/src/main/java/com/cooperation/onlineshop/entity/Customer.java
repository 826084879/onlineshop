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
@TableName("t_customer")
public class Customer extends Model<Customer> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String vxNumber;

    private String name;

    private Integer gender;

    private String phone;

    private String addr;

    private String headPortrait;

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
