package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.SystemlogMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.SystemlogWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/9 16:05
 * @Description: 系统日志服务层
 **/
@Service
public class SystemlogService {
    @Autowired
    SystemlogMapper systemlogMapper;

    @SystemServiceLog(description="获取所有的系统日志信息")
    public RespPageBean getSystemlogByPage(Integer page, Integer size, Employee employee, Date[] logtime){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<SystemlogWithBLOBs> data=systemlogMapper.getSystemlogByPage(page,size,employee,logtime);
        Long total=systemlogMapper.getTotal(employee,logtime);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @SystemServiceLog(description="添加新的系统日志信息")
    public void addSystemlog(SystemlogWithBLOBs systemlogWithBLOBs){
        systemlogMapper.insert(systemlogWithBLOBs);
    }

    @SystemServiceLog(description="批量删除旧的系统日志信息")
    public Integer deleteSystemlogs(List<SystemlogWithBLOBs> systemlogWithBLOBs){
        return systemlogMapper.deleteSystemlogs(systemlogWithBLOBs);
    }
}
