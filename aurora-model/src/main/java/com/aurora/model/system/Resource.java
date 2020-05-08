package com.aurora.model.system;

import com.aurora.model.PageModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *  资源实体
 */
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@Data
@TableName("SYS_RESOURCE")
public class Resource extends PageModel implements Serializable {

    @TableId(value = "ID", type = IdType.AUTO)
    private int id;

    @TableField("pid")
    private int pid;

    @TableField("name")
    private String name;

    @TableField("seq")
    private int seq;

    @TableField("status")
    private int status;

    @TableField("url")
    private int url;

    @TableField("module")
    private String module;

    @TableField("createdate")
    private Date createdate;
}
