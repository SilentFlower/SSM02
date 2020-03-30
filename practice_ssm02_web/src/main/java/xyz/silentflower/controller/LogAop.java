package xyz.silentflower.controller;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.silentflower.domain.SysLog;
import xyz.silentflower.service.SysLogService;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author SiletFlower
 * @date 2020/3/30 20:39:03
 * @description
 */
@Component
@Aspect
public class LogAop {

    private Date virsttime;
    private Class clazz;
    private Method method;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    //前置通知

    @Before("execution(* xyz.silentflower.controller.*.*(..)) && !execution(* xyz.silentflower.controller.SysLogController.*(..))")
    public void doBefore(JoinPoint jp)throws Exception{
        virsttime=new Date();//当前时间
        clazz=jp.getTarget().getClass();
        String methodStr=jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if(args == null || args.length==0){
            method=clazz.getMethod(methodStr);
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0;i<args.length;i++){
                classArgs[i]=args[i].getClass();
            }
            method = clazz.getMethod(methodStr, classArgs);
        }
    }


    //后置通知
    @After("execution(* xyz.silentflower.controller.*.*(..)) && !execution(* xyz.silentflower.controller.SysLogController.*(..)) ")
    public void doAfter(JoinPoint jp){
        long time = System.currentTimeMillis()-virsttime.getTime();
        String url ="";

        //获取url
        if(clazz!=null && method!=null && clazz!=LogAop.class){

            RequestMapping annotation1 = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(annotation1!=null){
                String[] classValue = annotation1.value();
                if(classValue != null){
                    RequestMapping annotation2 = method.getAnnotation(RequestMapping.class);
                    if(annotation2!=null){
                        String[] methodValue = annotation2.value();
                        url=classValue[0]+methodValue[0];
                        //获取IP
                        String ip =request.getRemoteAddr();
                        SecurityContext context = SecurityContextHolder.getContext();
                        if(context != null){
                            User user = (User) context.getAuthentication().getPrincipal();
                            String username = user.getUsername();
                            //或者使用request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")来获context
                            if(username != null){
                                SysLog sysLog = new SysLog();
                                sysLog.setUrl(url);
                                sysLog.setUsername(username);
                                sysLog.setExecutionTime(time);
                                sysLog.setVisitTime(virsttime);
                                sysLog.setIp(ip);
                                sysLog.setMethod("[类名] "+clazz.getName()+"[方法名]"+method.getName());
                                sysLogService.Insert(sysLog);
                            }
                        }
                    }
                }
                
            }
        }


    }
}
