package com.aurora.model.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *  资源实体
 */
@Data
@TableName("SYS_RESOURCE")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class Resource {

    @TableId(value = "ID", type = IdType.AUTO)
    private int id;

    @TableField("name")
    private String name;

    @TableField("seq")
    private int seq;

    @TableField("status")
    private int status;
}
