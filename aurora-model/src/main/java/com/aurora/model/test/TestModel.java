package com.aurora.model.test;/**
 * @author PHQ
 * @create 2020-04-28 22:53
 **/

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author PHQ
 * @create 2020-04-28 22:53
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_ROLE")
public class TestModel implements Serializable {

    @TableId(value = "ID", type = IdType.AUTO)
    private int id;

    @TableId("name")
    private String name;

    @TableId("seq")
    private int seq;

    @TableId("description")
    private String description;

    @TableId("status")
    private int status;

}
