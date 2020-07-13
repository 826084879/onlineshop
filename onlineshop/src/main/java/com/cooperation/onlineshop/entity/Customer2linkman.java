package com.cooperation.onlineshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @since 2020-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_customer2linkman")
public class Customer2linkman extends Model<Customer2linkman> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String leftId;

    private String rightId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
