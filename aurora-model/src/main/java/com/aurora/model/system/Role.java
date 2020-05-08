package com.aurora.model.system;

import com.aurora.model.PageModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 * 角色实体类
 * @author PHQ
 * @create 2020-05-01 16:09
 **/
@Data
@TableName("SYS_ROLE")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class Role extends PageModel implements Serializable {

    @TableId(value = "ID", type = IdType.AUTO)
    private int id;

    @TableField("name")
    private String name;

    @TableField("seq")
    private int seq;

//    @TableField("description")
//    private String description;

    @TableField("status")
    private int status;

}
