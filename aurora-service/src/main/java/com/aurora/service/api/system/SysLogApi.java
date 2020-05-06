package com.aurora.service.api.system;

import com.aurora.model.system.SysLog;

/**
 * ${DESCRIPTION}
 *
 * @author PHQ
 * @create 2020-05-01 23:46
 **/
public interface SysLogApi {

    public int saveLog(SysLog sysLog);
}
