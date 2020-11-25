package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.AppattMapper;
import com.emperorws.hrmanagement.mapper.WorkingscheduleMapper;
import com.emperorws.hrmanagement.model.Appatt;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Workingschedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/5 13:10
 * @Description: 考勤事务申请管理服务层
 **/
@Service
public class AppattService {
    @Autowired
    AppattMapper appattMapper;
    @Autowired
    WorkingscheduleMapper workingscheduleMapper;

    @SystemServiceLog(description="获取员工本人的考勤事务申请")
    public RespPageBean getAppattByWorkid(Integer page, Integer size, Boolean isSubmit, Boolean isapprove, Integer workid){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Appatt> data=appattMapper.getAppattByWorkidAndPage(workid,page,size,isSubmit,isapprove);
        Long total = appattMapper.getTotal(workid,isSubmit,isapprove);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @SystemServiceLog(description="删除员工本人未提交的考勤事务申请")
    public Integer deleteUncommittedAppattById(Integer aatid,Integer workid){
        return appattMapper.deleteByPrimaryKey(aatid,workid);
    }

    @SystemServiceLog(description="批量删除员工本人未提交的考勤事务申请")
    public Integer deleteUncommittedAppatts(List<Appatt> appatts,Integer workid){
        return appattMapper.deleteAppatts(appatts,workid);
    }

    @SystemServiceLog(description="添加员工本人未提交的考勤事务申请")
    public Integer addUncommittedAppatt(Appatt appatt){
        return appattMapper.insert(appatt);
    }

    @SystemServiceLog(description="更新员工本人未提交的考勤事务申请")
    public Integer updateUncommittedAppatt(Appatt appatt){
        return appattMapper.updateByPrimaryKeySelective(appatt);
    }

    @SystemServiceLog(description="计算员工本人考勤事务申请的时间")
    public double calcAppattTime(Integer workid, Date[] leavedaterange) throws ParseException {
        for(int i=0;i<leavedaterange.length;i++){
            if(leavedaterange[i]==null){
                return 0;
            }
        }
        double total=0;
        SimpleDateFormat dfd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dft = new SimpleDateFormat("HH:mm:ss");
        Date begindate=dfd.parse(dfd.format(leavedaterange[0]));
        Date begintime=dft.parse(dft.format(leavedaterange[0]));
        Date enddate=dfd.parse(dfd.format(leavedaterange[1]));
        Date endtime=dft.parse(dft.format(leavedaterange[1]));
        Date[] daterange={begindate,enddate};
        List<Workingschedule> workingschedules=workingscheduleMapper.getAllWorkingscheduleByDate(workid,daterange);
        if(workingschedules.size()==1&&workingschedules.get(0).getTodaysche()!=1){
            int topborderb=begintime.compareTo(workingschedules.get(0).getBusinesshours().getBegintime());
            int topbordere=endtime.compareTo(workingschedules.get(0).getBusinesshours().getBegintime());
            int upperboderb=workingschedules.get(0).getBusinesshours().getEndtime().compareTo(begintime);
            int upperbodere=workingschedules.get(0).getBusinesshours().getEndtime().compareTo(endtime);
            if(upperboderb==-1)
                begintime=workingschedules.get(0).getBusinesshours().getEndtime();
            if(topbordere==-1)
                endtime=workingschedules.get(0).getBusinesshours().getBegintime();
            if(topborderb==-1)
                begintime=workingschedules.get(0).getBusinesshours().getBegintime();
            if(upperbodere==-1)
                endtime=workingschedules.get(0).getBusinesshours().getEndtime();
            int tophalf=begintime.compareTo(workingschedules.get(0).getBusinesshours().getBeginrest());
            int upperhalf=workingschedules.get(0).getBusinesshours().getEndrest().compareTo(endtime);
            if((tophalf==-1||tophalf==0)&&(upperhalf==-1||upperhalf==0)){
                double tophalfh=(workingschedules.get(0).getBusinesshours().getBeginrest().getTime()-begintime.getTime())/(3600000d);
                double upperh=(endtime.getTime()-workingschedules.get(0).getBusinesshours().getEndrest().getTime())/(3600000d);
                BigDecimal all=new BigDecimal(tophalfh+upperh);
                return all.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }else{
                double tot=(endtime.getTime()-begintime.getTime())/(3600000d);
                BigDecimal all=new BigDecimal(tot);
                return all.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
        }
        for(Workingschedule ws : workingschedules){
            int topborderb=begintime.compareTo(ws.getBusinesshours().getBegintime());
            int topbordere=endtime.compareTo(ws.getBusinesshours().getBegintime());
            int upperboderb=ws.getBusinesshours().getEndtime().compareTo(begintime);
            int upperbodere=ws.getBusinesshours().getEndtime().compareTo(endtime);
            if(upperboderb==-1)
                begintime=ws.getBusinesshours().getEndtime();
            if(topbordere==-1)
                endtime=ws.getBusinesshours().getBegintime();
            if(topborderb==-1)
                begintime=ws.getBusinesshours().getBegintime();
            if(upperbodere==-1)
                endtime=ws.getBusinesshours().getEndtime();
            if(ws.getToday().equals(begindate)&&ws.getTodaysche()!=1){
                int tophalf=begintime.compareTo(ws.getBusinesshours().getBeginrest());
                if(tophalf==-1||tophalf==0){
                    double tophalfh=(ws.getBusinesshours().getBeginrest().getTime()-begintime.getTime())/(3600000d);
                    double upperh=(ws.getBusinesshours().getEndtime().getTime()-ws.getBusinesshours().getEndrest().getTime())/(3600000d);
                    BigDecimal all=new BigDecimal(tophalfh+upperh);
                    total+=all.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                }else{
                    double upperh=(ws.getBusinesshours().getEndtime().getTime()-begintime.getTime())/(3600000d);
                    BigDecimal all=new BigDecimal(upperh);
                    total+=all.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                }
            }else if(ws.getToday().equals(enddate)&&ws.getTodaysche()!=1){
                int upperhalf=endtime.compareTo(ws.getBusinesshours().getBeginrest());
                if(upperhalf==-1||upperhalf==0){
                    double tophalfh=(endtime.getTime()-ws.getBusinesshours().getBegintime().getTime())/(3600000d);
                    BigDecimal all=new BigDecimal(tophalfh);
                    total+=all.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                }else{
                    double tophalfh=(ws.getBusinesshours().getBeginrest().getTime()-ws.getBusinesshours().getBegintime().getTime())/(3600000d);
                    double upperh=(endtime.getTime()-ws.getBusinesshours().getEndrest().getTime())/(3600000d);
                    BigDecimal all=new BigDecimal(tophalfh+upperh);
                    total+=all.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                }
            }else if(ws.getTodaysche()!=1){
                double tophalfh=(ws.getBusinesshours().getBeginrest().getTime()-ws.getBusinesshours().getBegintime().getTime())/(3600000d);
                double upperh=(ws.getBusinesshours().getEndtime().getTime()-ws.getBusinesshours().getEndrest().getTime())/(3600000d);
                BigDecimal all=new BigDecimal(tophalfh+upperh);
                total+=all.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
        }
        return total;
    }
}
