package com.aurora.service.mapper;
/**
 *
 * @author 测试maaper
 * @create 2020-04-28 22:47
 **/

import com.aurora.model.test.TestModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper  extends BaseMapper<TestModel> {

    public List<TestModel> query(TestModel test);
}
