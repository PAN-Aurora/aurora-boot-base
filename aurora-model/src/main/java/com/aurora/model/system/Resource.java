package com.aurora.model.system;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * todo..
 *
 * @author :86157
 * @date：2020/5/7
 **/
@Data
@TableName("SYS_RESOURCE")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class Resource {

    private int id;
}
