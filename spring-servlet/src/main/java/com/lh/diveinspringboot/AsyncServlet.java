package com.lh.diveinspringboot;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        asyncSupported = true, // 激活异步特性
        name = "asyncServlet", // Servlet 名字
        urlPatterns = "/async-servlet"
)
public class AsyncServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        // 判断是否支持异步
        if (request.isAsyncSupported()) {
            // 创建 AsyncContext
            AsyncContext asyncContext = request.startAsync();
            // 设置超时时间
            asyncContext.setTimeout(1000L);
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent event) {
                    HttpServletResponse servletResponse = (HttpServletResponse)event.getSuppliedResponse();
                    servletResponse.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                    println("执行超时");
                }

                @Override
                public void onError(AsyncEvent event) {
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent event) {
                    println("开始执行");
                }
            });

            println("Hello,World");
            ServletResponse servletResponse = asyncContext.getResponse();
            // 设置响应媒体类型
            servletResponse.setContentType("text/plain;charset=UTF-8");
            // 获取字符输出流
            PrintWriter writer = servletResponse.getWriter();
            writer.println("Hello,World");
            writer.flush();
        }
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("AsyncServlet[" + threadName + "]: " + object);
    }

}
