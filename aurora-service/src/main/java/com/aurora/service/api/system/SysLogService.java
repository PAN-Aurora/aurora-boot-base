package com.aurora.service.api.system;

import com.aurora.model.system.SysLog;

/**
 * 日志记录业务接口
 * @author PHQ
 * @create 2020-05-01 23:46
 **/
public interface SysLogService {

    public int saveLog(SysLog sysLog);
}
