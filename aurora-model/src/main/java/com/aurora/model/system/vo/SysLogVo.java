package com.aurora.model.system.vo;

import com.aurora.model.system.SysLog;
import lombok.Data;

/**
 *  日志vo类
 * @author :PHQ
 * @date：2020/5/19
 **/
@Data
public class SysLogVo extends SysLog {

    public String startTime;
    public String endTime;

}
