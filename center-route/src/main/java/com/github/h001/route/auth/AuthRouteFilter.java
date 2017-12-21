package com.github.h001.route.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 还可以用 keycloak传播header的filter。
 * 参考：https://github.com/Activiti/activiti-cloud-gateway/blob/master/src/main/java/org/activiti/cloud/gateway/KeycloakFilterRoute.java
 * -----------------------------------------------------------------
 * 这个用自定义的Filter,zuul不仅只是路由，并且还能过滤，还可以做一些安全验证
 * **/
@Component
@Slf4j
public class AuthRouteFilter extends ZuulFilter{
    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     pre：路由之前
     routing：路由之时
     post： 路由之后
     error：发送错误调用
     filterOrder：过滤的顺序
     shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                log.error("输出错误",e);
            }

            return null;
        }
        log.info("ok");
        return null;
    }
}
