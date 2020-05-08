package com.aurora.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PHQ
 * @create 2020-05-01 11:09
 **/
@Setter
public class PageModel {
    @TableField(exist = false)
    @JSONField(serialize = false)
    @Getter
    private int current = 1;

    @TableField(exist = false)
    @JSONField(serialize = false)
    private int start = 0;

    @TableField(exist = false)
    @JSONField(serialize = false)
    private int limit = 10;

    public int getStart() {
        start = (this.current-1) * this.limit;
        return start;
    }

    public int getLimit() {
        return limit;
    }
}
