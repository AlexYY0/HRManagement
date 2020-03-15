package com.emperorws.hrmanagement.logger;

import com.emperorws.hrmanagement.model.SystemlogWithBLOBs;
import com.emperorws.hrmanagement.model.User;
import com.emperorws.hrmanagement.service.SystemlogService;
import com.emperorws.hrmanagement.service.UserService;
import com.emperorws.hrmanagement.utils.UserUtils;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/8 18:00
 * @Description: AOP切面拦截打印日志
 **/
@Aspect
@Component
@SuppressWarnings("all")
public class RecordLoggerAcpect {
    @Autowired
    UserService userService;
    @Autowired
    SystemlogService systemlogService;
    private static final Logger log = LoggerFactory.getLogger(RecordLoggerAcpect.class);

    /**
     * @Description: 定义切入点
     */
    //被注解CustomAopAnnotation表示的方法
    //Controller层切点
    @Pointcut("@annotation(com.emperorws.hrmanagement.logger.SystemControllerLog)")
    public void controllerAspect(){}

    @Pointcut("@annotation(com.emperorws.hrmanagement.logger.SystemServiceLog)")
    public void serviceAspect(){
    }

    /**
     * @Description: 定义前置通知
     */
    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        log.info("【注解：Before】------------------切面  before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取浏览器信息
        Browser browser = UserAgent.parseUserAgentString(request.getHeader("User-Agent")).getBrowser();
        // 获取浏览器版本号
        Version version = browser.getVersion(request.getHeader("User-Agent"));
        User user=UserUtils.getCurrentUser();
        try {
            // 记录下请求内容
            SystemlogWithBLOBs systemlogWithBLOBs=new SystemlogWithBLOBs();
            String logcontent="HTTP " + request.getMethod() + ":" + request.getRequestURL().toString() + ";使用系统方法: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "请求参数: " + Arrays.toString(joinPoint.getArgs());
            systemlogWithBLOBs.setWorkid(user.getWorkid());
            systemlogWithBLOBs.setBroswer(browser.getName());
            systemlogWithBLOBs.setVersion(version.getVersion());
            systemlogWithBLOBs.setIp(request.getRemoteAddr());
            systemlogWithBLOBs.setLogcontent(logcontent);
            systemlogWithBLOBs.setDescription(getControllerMethodDescription(joinPoint));
            systemlogService.addSystemlog(systemlogWithBLOBs);
            // 记录下请求内容
            log.info("【注解：Before】操作人ID ："+user.getUserid());
            log.info("【注解：Before】操作描述：" + getControllerMethodDescription(joinPoint));
            log.info("【注解：Before】浏览器输入的网址=URL : " + request.getRequestURL().toString());
            log.info("【注解：Before】HTTP_METHOD : " + request.getMethod());
            log.info("【注解：Before】IP : " + request.getRemoteAddr());
            log.info("【注解：Before】执行的业务方法名=CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            log.info("【注解：Before】业务方法获得的参数=ARGS : " + Arrays.toString(joinPoint.getArgs()));
            log.info("【注解：Before】浏览器类型 : " + browser.getName());
            log.info("【注解：Before】浏览器类型和版本 : " + version.getVersion());
        }catch (Exception e){
            //记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息：{}",e.getMessage());
        }
    }

    /**
     * @Description: 后置返回通知
     */
    @AfterReturning(returning = "ret", pointcut = "controllerAspect()")
    public void afterReturning(Object ret) throws Throwable {
        log.info("【注解：AfterReturning】这个会在切面最后的最后打印，方法的返回值 : " + ret);
    }

    /**
     * @Description: 后置异常通知
     */
    @AfterThrowing(pointcut = "serviceAspect()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Throwable e){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取浏览器信息
        Browser browser = UserAgent.parseUserAgentString(request.getHeader("User-Agent")).getBrowser();
        // 获取浏览器版本号
        Version version = browser.getVersion(request.getHeader("User-Agent"));
        User user=UserUtils.getCurrentUser();
        log.info("【注解：AfterThrowing】方法异常时执行.....");
        try {
            SystemlogWithBLOBs systemlogWithBLOBs=new SystemlogWithBLOBs();
            String logcontent="异常" + e.getClass().getName() + ";" + e.getMessage() + "使用方法" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()异常");
            systemlogWithBLOBs.setWorkid(user.getWorkid());
            systemlogWithBLOBs.setBroswer(browser.getName());
            systemlogWithBLOBs.setVersion(version.getVersion());
            systemlogWithBLOBs.setIp(request.getRemoteAddr());
            systemlogWithBLOBs.setLogcontent(logcontent);
            systemlogWithBLOBs.setDescription(getControllerMethodDescription(joinPoint));
            systemlogService.addSystemlog(systemlogWithBLOBs);
            // 记录下请求内容
            log.info("【注解：AfterThrowing】操作人ID ："+user.getUserid());
            log.info("【注解：AfterThrowing】浏览器输入的网址=URL : " + request.getRequestURL().toString());
            log.info("【注解：AfterThrowing】HTTP_METHOD : " + request.getMethod());
            log.info("【注解：AfterThrowing】IP : " + request.getRemoteAddr());
            log.info("【注解：AfterThrowing】异常代码:" + e.getClass().getName());
            log.info("【注解：AfterThrowing】异常信息:" + e.getMessage());
            log.info("【注解：AfterThrowing】异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.info("【注解：AfterThrowing】操作描述:" + getServiceMethodDescription(joinPoint));
            log.info("【注解：AfterThrowing】浏览器类型 : " + browser.getName());
            log.info("【注解：AfterThrowing】浏览器类型和版本 : " + version.getVersion());
        }catch (Exception ex){
            //记录本地异常日志
            log.error("==异常通知异常==");
            log.error("异常信息:{}", ex.getMessage());
        }
    }

    /**
     * @Description: 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("controllerAspect()")
    public void after(JoinPoint jp){
        log.info("【注解：After】方法最后执行.....");
    }

    /**
     * @Description: 环绕通知,环绕增强
     * @return
     */
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) {
        log.info("【注解：Around . 环绕前】方法环绕start.....");
        try {
            //如果不执行这句，会不执行切面的Before方法及controller的业务方法
            Object o =  pjp.proceed();
            log.info("【注解：Around. 环绕后】方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Description  获取注解中对方法的描述信息 用于controller层注解
     * @date 2020年3月8日 下午5:05
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint)throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * @Description  获取注解中对方法的描述信息 用于service层注解
     * @date 2018年9月3日 下午5:05
     */
    public static String getServiceMethodDescription(JoinPoint joinPoint)throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
