package com.aurora.web.test;

import com.aurora.config.annotation.SystemLog;
import com.aurora.service.api.TestService;
import com.aurora.model.test.TestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PHQ
 * @create 2020-04-28 23:13
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);


    @Autowired
    private TestService testService;

    /**
     * 模糊查询
     */
    @SystemLog(module="测试模块",methods="模糊查询",url="/test/dorest", desc="测试模糊查询")
    @RequestMapping(value= "/dorest",method = RequestMethod.GET)
    public String dorest(TestModel testModel) {
        String res = testService.queryList(testModel);
        return res;
    }
}
