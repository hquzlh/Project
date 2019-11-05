package com.ucar.training.filter;

import javax.servlet.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: final
 * @description: 脏话过滤
 * @author: Mr.Zhu
 * @create: 2019-08-07 16:24
 **/

public class WordFilter implements Filter {
    //文字过滤
    private List<String> list = new ArrayList<>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String path ="D:\\final\\src\\main\\webapp\\WEB-INF\\word.txt";
        InputStream stream = null;
        try {
            stream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //使用转换流
            InputStreamReader is = new InputStreamReader(stream, "utf-8");
            //读取文件
            BufferedReader br = new BufferedReader(is);
            //定义一个空字符串
            String len= null;
            //循环读取文件
            while ((len=br.readLine())!=null){
                //把读取到的内容加入集合中
               list.add(len);
            }
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
  @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取留言板内容
       String text=servletRequest.getParameter("mess1");
       //过滤脏话
       text=text.replaceAll(list.toString(),"*");
       servletRequest.setAttribute("mess1", text);
        //过滤器放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
