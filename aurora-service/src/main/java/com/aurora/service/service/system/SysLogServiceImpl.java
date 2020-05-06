package com.aurora.service.service.system;

import com.aurora.model.system.SysLog;
import com.aurora.service.api.system.SysLogApi;
import com.aurora.service.mapper.system.SysLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author PHQ
 * @create 2020-05-01 23:45
 **/
@Service
public class SysLogServiceImpl implements SysLogApi {

    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 系统日志保存
     * @param sysLog
     * @return
     */
    public int saveLog(SysLog sysLog){
        int result =  sysLogMapper.insert(sysLog);
        return result;
    }

}
