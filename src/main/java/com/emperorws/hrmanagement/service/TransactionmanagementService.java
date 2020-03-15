package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.AppattMapper;
import com.emperorws.hrmanagement.mapper.WorkingscheduleMapper;
import com.emperorws.hrmanagement.model.Appatt;
import com.emperorws.hrmanagement.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/5 22:13
 * @Description: 考勤事务申请管理服务层
 **/
@Service
public class TransactionmanagementService {
    @Autowired
    AppattMapper appattMapper;
    @Autowired
    WorkingscheduleMapper workingscheduleMapper;

    @SystemServiceLog(description="领导获取员工的考勤事务申请")
    public RespPageBean getManaAppByWorkidAndPage(Integer page, Integer size, Boolean isapprove, Integer workid){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Appatt> data=appattMapper.getManaAppByWorkidAndPage(workid,page,size,isapprove);
        Long total = appattMapper.getManaAppTotal(workid,isapprove);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @Transactional
    @SystemServiceLog(description="领导同意或拒绝员工的考勤事务申请")
    public Integer updateManaApp(Appatt appatt,Integer workid) throws ParseException {
        Boolean flag=appatt.getIsapprove();
        String category=appatt.getCategory();
        SimpleDateFormat dfd = new SimpleDateFormat("yyyy-MM-dd");
        Date begindate=dfd.parse(dfd.format(appatt.getAppbegindate()));
        Date enddate=dfd.parse(dfd.format(appatt.getAppenddate()));
        if(flag==true&&category.equals("调休")){
            Date[] daterange={begindate,enddate};
            int days = (int) ((daterange[1].getTime() - daterange[0].getTime()) / (1000*3600*24));
            if(workingscheduleMapper.updateWorkingscheduleSelf(appatt.getWorkid(),daterange)==(days+1)){
                if(appattMapper.checkManaApp(appatt.getWorkid(),workid)!=1)
                    return -1;
                return appattMapper.updateByPrimaryKeySelective(appatt);
            }else
                return -1;
        }
        if(appattMapper.checkManaApp(appatt.getWorkid(),workid)!=1)
            return -1;
        return appattMapper.updateByPrimaryKeySelective(appatt);
    }
}
