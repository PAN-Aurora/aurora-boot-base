package com.aurora.es.service;

import com.aurora.es.api.EsTestApi;
import com.aurora.es.util.EsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  es api 测试实现类
 * @author :PHQ
 * @date：2020/6/5
 **/
@Service
public class EsTestServiceImpl implements EsTestApi {

    @Autowired
    private EsUtil esUtil;

    @Override
    public String createIndex() {
        EsUtil.createIndex("test");
        return "success";
    }
}
