package com.aurora.service.api;

import com.aurora.model.test.TestModel;

/**
 * ${DESCRIPTION}
 *
 * @author PHQ
 * @create 2020-04-28 22:48
 **/

public interface TestService  {

    public String find(TestModel testModel);

    public String queryList(TestModel testModel);
}
