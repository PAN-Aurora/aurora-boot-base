package com.aurora.service.service;/**
 * @author PHQ
 * @create 2020-04-28 22:48
 **/

import com.alibaba.fastjson.JSON;
import com.aurora.service.api.TestService;
import com.aurora.service.mapper.TestMapper;
import com.aurora.model.test.TestModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author PHQ
 * @create 2020-04-28 22:48
 **/
@Service
public class TestServiceImpl implements TestService {

    private final static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private TestMapper testMapper;

    public String find(TestModel testModel){
        String test ="ceshi";
        List list = testMapper.query(testModel);
        //JSON.toJSONString(list);
        return JSON.toJSONString(list);
    }

    public String queryList(TestModel testModel){
        IPage<TestModel> pageBean = new Page<TestModel>(1, 2);
        pageBean = testMapper.selectPage(pageBean,null);

        List<TestModel> list =  pageBean.getRecords();
        logger.info(JSON.toJSONString(pageBean.getRecords()));
        //JSON.toJSONString(list);
        return JSON.toJSONString(list);
    }

}
