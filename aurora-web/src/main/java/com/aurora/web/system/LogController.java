package com.aurora.web.system;

import com.aurora.common.model.ResultModel;
import com.aurora.config.annotation.SystemLog;
import com.aurora.model.system.SysLog;
import com.aurora.model.system.vo.SysLogVo;
import com.aurora.service.api.system.SysLogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志控制类
 * @author :PHQ
 * @date：2020/5/19
 **/
@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 获取日志管理列表数据
     * @param sysLog
     * @return
     */
    @GetMapping(value = "/getLogList")
    @SystemLog(module="日志管理模块",methods="获取日志列表",url="/api/log/getLogList", desc="获取日志列表")
    @ApiOperation(value="获取日志列表", notes="获取日志列表 ",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysLog", value = "日志详情实体sysLog", required = true, dataType = "SysLog")
    })
    public ResultModel getLogList(SysLogVo sysLog){
        return sysLogService.getLogList(sysLog);
    }
}
