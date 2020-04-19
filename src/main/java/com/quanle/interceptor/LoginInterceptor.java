package com.quanle.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author quanle
 * @date 2020/3/24 12:58 AM
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 校验用户是否登录，如果是调整到登录页或者执行登录方法则不执行此拦截器
     * 往往在这里完成权限校验工作
     *
     * @param request
     * @param response
     * @param handler
     * @return 返回值boolean代表是否放行，true代表放行，false代表中止
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        String requestURI = request.getRequestURI();
        /*if ("/login".equals(requestURI) || "/toLogin".equals(requestURI) || requestURI.endsWith(".js")) {
            return true;
        }*/
        HttpSession session = request.getSession();
        System.out.println("==========>>>>sessionId:" + session.getId());
        System.out.println("======SESSION::::" + session);

        Enumeration<String> attrs = session.getAttributeNames();
        // 遍历attrs中的
        while (attrs.hasMoreElements()) {
            // 获取session键值
            String name = attrs.nextElement();
            // 根据键值取session中的值
            Object vakue = session.getAttribute(name);
            // 打印结果
            System.out.println("------" + name + ":" + vakue + "--------\n");

        }

        System.out.println("===============>>>>>>当前uri：" + requestURI);
        Object username = session.getAttribute("username");
        System.out.println("=================>>>>>username:" + username);
        if (username == null) {
            // 没有登录,重定向到登录页
            System.out.println("未登录，请登录");
            response.sendRedirect(request.getContextPath() + "/login/toLogin");
            return false;
        } else {
            System.out.println("已登录，放行请求");
            // 已登录，放行
            return true;
        }
    }


    /**
     * 会在handler方法业务逻辑执行之后尚未跳转页面时执行
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 封装了视图和数据，此时尚未跳转页面呢，你可以在这里针对返回的数据和视图信息进行修改
     * @throws Exception
     */
    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    /**
     * 页面已经跳转渲染完毕之后执行
     *
     * @param request
     * @param response
     * @param handler
     * @param ex       可以在这里捕获异常
     * @throws Exception
     */
    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) throws Exception {
    }
}
