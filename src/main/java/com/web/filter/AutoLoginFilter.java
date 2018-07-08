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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.domain.User;
import com.exception.UserException;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements Filter {
    @Autowired
    private UserService userService;
    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String uri = httpRequest.getRequestURI();
        String urlPattern = uri.substring(httpRequest.getContextPath().length());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/page/cart.do");
        urlPatterns.add("/page/index.do");
        urlPatterns.add("/page/product_info.do");
        urlPatterns.add("/page/product_list.do");
        if(urlPatterns.indexOf(urlPattern) != -1) {
            HttpSession session = httpRequest.getSession();
            Object loginStatus = session.getAttribute("loginStatus");
            User loginUser = (User) session.getAttribute("loginUser");
            if(loginStatus == null && loginUser == null) {
                // 获取cookie
                Cookie[] cookies = httpRequest.getCookies();
                if(cookies != null) {
                    for (Cookie cookie : cookies) {
                        if("autoLogin".equals(cookie.getName())) {
                            String valuesStr = cookie.getValue();
                            if(!"".equals(valuesStr)) {
                                String[] values = valuesStr.split("&");
                                try {
                                    loginUser = userService.login(new User(values[0], values[1]));
                                    if(!"管理员".equals(loginUser.getRole())) {
                                        session = httpRequest.getSession();
                                        session.setAttribute("loginStatus", "true");
                                        session.setAttribute("loginUser", loginUser);
                                    }
                                    
                                } catch (UserException e) {
                                    e.printStackTrace();
                                }                               
                            }                       
                            break;
                        }
                    }
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
