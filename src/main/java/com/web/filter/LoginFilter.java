package com.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String uri = httpRequest.getRequestURI();
        String urlPattern = uri.substring(httpRequest.getContextPath().length());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/user/userInfo.do");
        urlPatterns.add("/user/modifyUserInfo.do");
        urlPatterns.add("/page/modifyUserInfo.do");
        urlPatterns.add("/page/modifyUserInfoSuccess.do");
        urlPatterns.add("/background");
        urlPatterns.add("/modifyuserinfo.jsp");
        if(urlPatterns.indexOf(urlPattern) != -1) {
            User loginUser = (User) httpRequest.getSession().getAttribute("loginUser");
            if("/user/userInfo.do".equals(urlPattern) || "/user/modifyUserInfo.do".equals(urlPattern) 
                    || "/page/modifyUserInfo.do".equals(urlPattern) || "/page/modifyUserInfoSuccess.do".equals(urlPattern)) {
                
                    if(loginUser == null) {
                        httpResponse.sendRedirect(httpRequest.getContextPath() + "/page/login。do");
                        return;
                    }
                
            } else if("/background".equals(urlPattern)) {
                if(loginUser == null || !"管理员".equals(loginUser.getRole())) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
                    return;
                }
            } else {
                if(loginUser == null) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
