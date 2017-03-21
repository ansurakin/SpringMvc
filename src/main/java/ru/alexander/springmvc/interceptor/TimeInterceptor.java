package ru.alexander.springmvc.interceptor;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeInterceptor extends HandlerInterceptorAdapter{
    
    private static final Logger logger = Logger.getLogger(TimeInterceptor.class.toString());
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        long endTime =  System.currentTimeMillis();
        double duration = (endTime - startTime) / 1000;
        logger.info(handler + ": Общее время работы: " + duration + " с.");        
    }
    
    
}
