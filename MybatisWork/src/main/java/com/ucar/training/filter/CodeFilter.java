package com.ucar.training.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: final
 * @description: 字符串过滤
 * @author: Mr.Zhu
 * @create: 2019-08-05 21:31
 **/

public class CodeFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    //编码格式的过滤
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
