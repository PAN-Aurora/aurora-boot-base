package com.aurora.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  路由过滤器
 *     目的为了对路由进行校验过滤
 * @author :PHQ
 * @date：2020/12/28
 **/
@Component
public class TokenFilter extends  ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(TokenFilter.class) ;
    @Override
    public String filterType() {
        //前置过滤器
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //此方法可以根据请求的url进行判断是否需要拦截
        return true;
    }

    //对路由进行校验操作
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext() ;
        HttpServletRequest request = requestContext.getRequest() ;
        String reqUri = request.getRequestURI() ;

        log.info("请求路径："+reqUri);
        return null;
    }
}
