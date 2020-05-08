package com.aurora.model.system;

import com.aurora.model.PageModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *  资源实体
 */
@Accessors(chain = true)
@Builder
@Data
@TableName(value = "SYS_RESOURCE",autoResultMap = true)
@AllArgsConstructor //全参构造函数
@NoArgsConstructor  //无参构造函数
public class Resource extends PageModel {

    @TableId(value = "ID", type = IdType.AUTO)
    private int id;

    @TableField(value = "pid")
    private int pid;

    @TableField( value = "name")
    private String name;

    @TableField( value = "seq")
    private int seq;

    @TableField( value = "module")
    private String module;

    @TableField( value = "url")
    private String url;

    @TableField( value = "status")
    private int status;

    @TableField( value = "createdate")
    private Date createdate;
}
