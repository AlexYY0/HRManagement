package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.AttelogdayMapper;
import com.emperorws.hrmanagement.mapper.UserMapper;
import com.emperorws.hrmanagement.mapper.WorkingscheduleMapper;
import com.emperorws.hrmanagement.model.*;
import com.emperorws.hrmanagement.service.rabbitmq.ClockinSender;
import com.emperorws.hrmanagement.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/18 12:07
 * @Description: 专用于微信用户登录的服务层
 **/
@Service
public class WechatAPIService {

    @Value("${wx.longitude}")
    private String longitude;
    @Value("${wx.latitude}")
    private String latitude;

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    UserMapper userMapper;
    @Autowired
    WorkingscheduleMapper workingscheduleMapper;
    @Autowired
    AttelogdayMapper attelogdayMapper;
    @Autowired
    ClockinSender clockinSender;

    @SystemServiceLog(description="员工换绑或者开始绑定自己的微信和系统账户")
    public Boolean bind(Map<String, Object> info){
        String skey = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=(String) info.get("username");
        String password=(String) info.get("password");

        String value=redisUtil.get(skey);
        String values[] = value.split("---");
        String openid = values[0];

        User user=userMapper.findUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Boolean isMatch=encoder.matches(password,user.getPassword());
        if(null!=user&&isMatch==true){
            if(userMapper.bind(user.getUserid(),openid)==1){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    @SystemServiceLog(description="员工通过微信小程序获取今天的考勤安排,用于打卡")
    public RespBean getTodayAtten(Date today){
        String skey = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String value=redisUtil.get(skey);
        String values[] = value.split("---");
        String openid = values[0];
        Workingschedule workingschedule = workingscheduleMapper.getTodayAtten(openid,today);
        if(null!=workingschedule){
            workingschedule.setLongitude(longitude);
            workingschedule.setLatitude(latitude);
            return RespBean.ok("成功查到今日打卡",workingschedule);
        }else{
            return RespBean.ok("没有查到今日打卡数据");
        }
    }

    @SystemServiceLog(description="员工通过微信小程序签到打卡")
    public RespBean signIn(Date signintime,Integer clockinflag) throws ParseException {
        SimpleDateFormat dfd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dft = new SimpleDateFormat("HH:mm:ss");
        Date today=dfd.parse(dfd.format(signintime));
        Date time=dft.parse(dft.format(signintime));
        String skey = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String value=redisUtil.get(skey);
        String values[] = value.split("---");
        String openid = values[0];
        Attelogday attelogday=attelogdayMapper.selectByOpenidAndDay(openid,today);
        if(null!=attelogday) {
            attelogday.setClockinflag(clockinflag);
            attelogday.setSignintime(time);
            //生成消息的唯一id
            String msgid = UUID.randomUUID().toString();
            clockinSender.sendMsg(attelogday,msgid);
            clockinSender.sendDelayMsg(attelogday,msgid,0);
            return RespBean.ok("今日签到成功");
        }else{
            return RespBean.error("签到失败,没有查到签到数据");
        }

        /*if(null!=attelogday){
            attelogday.setClockinflag(clockinflag);
            attelogday.setSignintime(time);
            if(attelogdayMapper.updateByPrimaryKeySelective(attelogday)==1){
                return RespBean.ok("今日签到成功");
            }else {
                return RespBean.error("签到失败,无法插入数据");
            }

        }else{
            return RespBean.error("签到失败,没有查到签到数据");
        }*/
    }

    @SystemServiceLog(description="员工通过微信小程序签退打卡并计算需要工时和实际工时")
    public RespBean signOut(Date signouttime) throws ParseException {
        SimpleDateFormat dfd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dft = new SimpleDateFormat("HH:mm:ss");
        Date today=dfd.parse(dfd.format(signouttime));
        Date time=dft.parse(dft.format(signouttime));

        String skey = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String value=redisUtil.get(skey);
        String values[] = value.split("---");
        String openid = values[0];

        Attelogday attelogday=attelogdayMapper.selectByOpenidAndDay(openid,today);
        Workingschedule workingschedule = workingscheduleMapper.getTodayAtten(openid,today);

        int signOutFlag=time.compareTo(workingschedule.getBusinesshours().getEndtime());
        if(signOutFlag==-1){
            //早退
            if(attelogday.getClockinflag()==0){
                //未签到&早退
                attelogday.setClockinflag(1);
                attelogday.setWorkinghours(0d);
            }else if(attelogday.getClockinflag()==10){
                //迟到&早退
                double workinghoursl=(time.getTime()-attelogday.getSignintime().getTime())/(3600000d);
                BigDecimal workinghours=new BigDecimal(workinghoursl);
                attelogday.setClockinflag(11);
                attelogday.setWorkinghours(workinghours.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            } else if(attelogday.getClockinflag()==20){
                //正常签到&早退
                double workinghoursl=(time.getTime()-workingschedule.getBusinesshours().getBegintime().getTime())/(3600000d);
                BigDecimal workinghours=new BigDecimal(workinghoursl);
                attelogday.setClockinflag(21);
                attelogday.setWorkinghours(workinghours.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
        } else{
            //正常签退
            if(attelogday.getClockinflag()==0){
                //未签到&正常签退
                attelogday.setClockinflag(2);
                attelogday.setWorkinghours(0d);
            }else if(attelogday.getClockinflag()==10){
                //迟到&正常签退
                double workinghoursl=(workingschedule.getBusinesshours().getEndtime().getTime()-attelogday.getSignintime().getTime())/(3600000d);
                BigDecimal workinghours=new BigDecimal(workinghoursl);
                attelogday.setClockinflag(12);
                attelogday.setWorkinghours(workinghours.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            } else if(attelogday.getClockinflag()==20){
                //正常签到&正常签退
                double workinghoursl=(workingschedule.getBusinesshours().getEndtime().getTime()-workingschedule.getBusinesshours().getBegintime().getTime())/(3600000d);
                BigDecimal workinghours=new BigDecimal(workinghoursl);
                attelogday.setClockinflag(22);
                attelogday.setWorkinghours(workinghours.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
        }
        attelogday.setSignouttime(time);

        //生成消息的唯一id
        String msgid = UUID.randomUUID().toString();
        clockinSender.sendMsg(attelogday,msgid);
        clockinSender.sendDelayMsg(attelogday,msgid,0);
        return RespBean.ok("今日签退成功");

        /*if(attelogdayMapper.updateByPrimaryKeySelective(attelogday)==1){
            return RespBean.ok("今日签退成功");
        }else {
            return RespBean.error("签退失败,无法插入数据");
        }*/
    }
}
