package com.aurora.web.test;

import com.aurora.common.model.ResultModel;
import com.aurora.es.api.EsTestApi;
import com.aurora.model.test.EsTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo..
 * es 测试类
 * @author :PHQ
 * @date：2020/8/13
 **/
@RestController
@RequestMapping("/api/testEs")
public class EsTestController {
    private final static Logger logger = LoggerFactory.getLogger(EsTestController.class);

    @Autowired
    private EsTestApi esTestApi;


    /**
     * 模糊查询
     */
    @RequestMapping(value= "/esTestSearch",method = RequestMethod.GET)
    public ResultModel esTestSearch(@RequestBody EsTest test) {
        return esTestApi.queryTest(test);
    }

}
