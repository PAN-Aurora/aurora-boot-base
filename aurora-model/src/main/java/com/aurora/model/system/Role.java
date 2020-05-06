package com.aurora.model.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * 角色实体类
 * @author PHQ
 * @create 2020-05-01 16:09
 **/
@Setter
@Getter
@Data
@TableName("SYS_ROLE")
@Builder
public class Role implements Serializable {

    @TableId(value = "ID", type = IdType.AUTO)
    private int id;

    @TableField("name")
    private String name;

    @TableField("seq")
    private int seq;

    @TableField("description")
    private String description;

    @TableField("status")
    private int status;

}
