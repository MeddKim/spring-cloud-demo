package com.demo.security.config.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Administrator
 * @date : 2017/3/17 0017
 * @Description:
 */
public class AccessFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 返回字符串代表不同生命周期的过滤类型 如：
     *         pre 在请求路由之前调用
     *         routing 在路由请求时调用
     *         post 在routing 和error过滤器之后调用
     *         error 在请求错误时调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过 int 值来定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否需要执行，返回true过滤器生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑实现了在请求被路由之前检查请求中是否有accessToken参数，
     * 若有就进行路由，若没有就拒绝访问，返回401 Unauthorized错误
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");

        if(null == accessToken){
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false); //令zuul过滤该请求，不进行路由
            ctx.setResponseStatusCode(401); //设置返回码，也可通过ctx.setResponseBody(body)对返回body内容进行编辑等。
            return null;
        }
        return null;
    }
}
