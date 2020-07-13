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
 * @since 2020-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user2role")
public class User2role extends Model<User2role> {

//    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * user_id
     */
    private String leftId;

    /**
     * role_id
     */
    private String rightId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
