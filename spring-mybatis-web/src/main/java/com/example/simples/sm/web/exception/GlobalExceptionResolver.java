/**
 * Copyright (C), 2017-2017, 2345free.com
 * FileName: GlobalExceptionResolver
 * Author:   tianyi
 * Date:     2017/8/22 17:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.simples.sm.web.exception;

import com.example.simples.sm.web.utils.JsonUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br>
 * 〈统一异常处理(包括ajax请求异常)〉
 *
 * @author tianyi
 * @create 2017/8/22
 * @since 1.0.0
 */
@Component
public class GlobalExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        String viewName = determineViewName(ex, request);
        response.setCharacterEncoding("UTF-8");
        if (viewName != null) {// JSP格式返回
            String ajaxHeader = request.getHeader("X-Requested-With");
            if (!(request.getHeader("Content-Type").contains("application/json") || request.getHeader("accept").contains("application/json") || (ajaxHeader != null && ajaxHeader.contains("XMLHttpRequest")))) {
                // 如果不是异步请求
                // Apply HTTP status code for error views, if specified.
                // Only apply it if we're processing a top-level request.
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                System.err.format("JSP格式返回%s", viewName);
                return getModelAndView(viewName, ex, request);
            } else {// JSON格式返回
                try {
                    response.addHeader("Content-Type", "application/json");
                    PrintWriter writer = response.getWriter();
                    writer.write(JsonUtils.getFailure("服务器内部异常", -500));
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.err.format("JSON格式返回%s", viewName);
                return new ModelAndView();
            }
        } else {
            return null;
        }
    }

    @PostConstruct
    public void init() {
        // 错误视图设置
        Properties mappings = new Properties();
        mappings.setProperty("java.lang.Exception", "500");
        setExceptionMappings(mappings);
    }

}