package com.boot.demo.handler;


import com.boot.demo.util.ResponseBean;
import com.boot.demo.util.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * 全局统一异常处理类
 *
 * @author cui
 * @create 2018-08-06 13:55
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    public static final String DEFAULT_ERROR_VIEW = "error";

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * 系统异常处理，比如：404,500
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(HttpServletRequest req, HttpServletResponse response, Exception e)
            throws Exception {
        logger.error("异常打印 >>>", e);
        if (req.getRequestURI().startsWith("/rest")) {
            ResponseBean r = new ResponseBean();
            r.setMsg(e.getMessage());
            if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
                r.setStatus(404);
            } else {
                r.setStatus(500);
            }
            r.setRes(null);
            r.setFlag(false);
            PrintWriter writer = response.getWriter();
            writer.println(objectMapper.writeValueAsString(r));
            writer.flush();
            writer.close();
            return null;
        } else {
            if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
                return "error/404";
            } else{
                return "error/500";
            }
        }
    }

}
