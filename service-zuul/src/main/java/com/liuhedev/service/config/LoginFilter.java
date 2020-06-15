package com.liuhedev.service.config;

import com.netflix.discovery.util.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul过滤器
 *
 * @author liuhe
 * @date 2020/06/15
 */
@Configuration
public class LoginFilter extends ZuulFilter {
    /**
     * filterType：返回字符串，代表过滤器的类型。包含以下4种：
     * - pre：请求在被路由之前执行
     * - route：在路由请求时调用
     * - post：在route和errror过滤器之后调用
     * - error：处理请求时发生错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //filterOrder：通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
    @Override
    public int filterOrder() {
        return 0;
    }

    //返回一个Boolean值，判断该过滤器是否需要执行。返回true执行，返回false不执行。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 登录校验
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 获取zuul提供的上下文对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 从上下文对象中获取请求对象
        HttpServletRequest request = currentContext.getRequest();
        // 获取token信息
        String token = request.getParameter("access-token");
        if (StringUtils.isEmpty(token)) {
//            http://127.0.0.1:10010/gateway/service-provider/user/2?access-token=1
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            currentContext.setResponseBody("{\"message\":\"login first!\",\"status\":\"401\"}");
        }
        currentContext.set("token", token);
        return null;
    }
}
