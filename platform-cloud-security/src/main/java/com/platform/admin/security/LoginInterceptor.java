package com.platform.admin.security;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by xinleisong on 2018/1/11.
 */
@WebFilter(filterName = "loginAdminFilter", urlPatterns = "/*", initParams = {@WebInitParam(name = "EXCLUDED_PAGES", value = "/login,/interceptor,/imageCode,/authenticate")})
public class LoginInterceptor implements Filter {

    private static String IP = "127.0.0.1";

    private static int PORT = 8120;

    private String excludedPages[];

    private String STATIC_PATH[] = {".css", ".js"};

    public void init(FilterConfig filterConfig) throws ServletException {
        ResourceBundle msgBundle = ResourceBundle.getBundle("login_interceptor", Locale.CHINA);
        IP = msgBundle.getString("com.platform.admin.LoginIp");
        String portStr = msgBundle.getString("com.platform.admin.LoginPort");
        System.out.println("启动拦截器IP地址 [" + IP + "] 端口 [" + portStr + "]");
        if (portStr != null && !portStr.equals(""))
            PORT = Integer.parseInt(portStr);
        String excludedUrl = filterConfig.getInitParameter("EXCLUDED_PAGES");
        if (excludedUrl != null) {
            excludedPages = excludedUrl.split(",");
        } else {
            excludedUrl = "";
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 过滤静态地址
        if (isStaticPath(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 过滤掉例外地址
        if (isExcludedUrl(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String token = servletRequest.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            token = (String) request.getSession().getAttribute("token");
        }
        if (!StringUtils.isEmpty(token)) {
            request.getSession().setAttribute("token", token);
        }
        // 未登录
        if (request.getSession().getAttribute("token") == null) {
            String backUrl = request.getRequestURL().toString();
            String queryString = request.getQueryString();
            if (!StringUtils.isEmpty(queryString)) {
                backUrl += "?" + queryString;
            }
            response.sendRedirect("http://" + IP + ":" + PORT + "/interceptor?backUrl=" + URLEncoder.encode(backUrl, "UTF-8"));
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
    }

    /**
     * 检查是否存在过滤地址
     *
     * @param request
     * @return
     */
    private boolean isExcludedUrl(HttpServletRequest request) {
        String uri = request.getRequestURI();
        for (String excludedUrl : excludedPages) {
            if (excludedUrl.equals(uri)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 过滤结尾的静态地址
     *
     * @param request
     * @return
     */
    private boolean isStaticPath(HttpServletRequest request) {
        String uri = request.getRequestURI();
        if (request.getRequestURL().indexOf("/static/") != -1) {
            return true;
        }
        for (String staticPath : STATIC_PATH) {
            if (uri.indexOf(staticPath) != -1) {
                return true;
            }
        }
        return false;
    }

    public void destroy() {

    }
}
