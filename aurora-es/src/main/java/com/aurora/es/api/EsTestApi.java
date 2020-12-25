package com.aurora.es.api;

import com.aurora.common.model.ResultModel;
import com.aurora.model.test.EsTest;

/**
 * todo..
 *
 * @author :PHQ
 * @date：2020/6/5
 **/
public interface EsTestApi {

    public String  createIndex();

    public ResultModel queryTest(EsTest esTest);

}
