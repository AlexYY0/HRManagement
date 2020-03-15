package com.emperorws.hrmanagement.controller.salary;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.service.SalarycheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/13 21:34
 * @Description: 薪资计算核算控制层
 **/
@RestController
@RequestMapping("/salary/check")
public class SalarycheckController {
    @Autowired
    SalarycheckService salarycheckService;

    @GetMapping("/checkall")
    @SystemControllerLog(description="自动计算所有员工的上月薪资")
    public RespBean salarycheckAll(Date[] timerange,double overtimesal,double businesssal){
        if(salarycheckService.salarycheckAll(timerange,overtimesal,businesssal)){
            return RespBean.ok("计算所有员工的薪资成功!");
        }
        return RespBean.error("计算所有员工的薪资失败!");
    }

    @GetMapping("/checkbydepid")
    @SystemControllerLog(description="自动计算所选部门的所有员工的上月薪资")
    public RespBean salarycheckByDepid(Integer depid,Date[] timerange,double overtimesal,double businesssal){
        if(salarycheckService.salarycheckByDepid(depid,timerange,overtimesal,businesssal)){
            return RespBean.ok("计算所选部门的所有员工的薪资成功!");
        }
        return RespBean.error("计算所选部门的所有员工的薪资失败!");
    }

    @PostMapping("/checkbyworkid")
    @SystemControllerLog(description="自动计算所选员工的上月薪资")
    public RespBean salarycheckByWorkid(@RequestParam Date[] timerange,@RequestParam double overtimesal,@RequestParam double businesssal, @RequestBody List<Employee> employees){
        if(salarycheckService.salarycheckByWorkid(employees,timerange,overtimesal,businesssal)){
            return RespBean.ok("计算所选员工的薪资成功!");
        }
        return RespBean.error("计算所选员工的薪资失败!");
    }

    @GetMapping("/yearcheckall")
    @SystemControllerLog(description="自动计算所有员工的年终奖12+n")
    public RespBean yearSalarycheckAll(Date[] timerange,Integer n){
        if(salarycheckService.yearSalarycheckAll(timerange,n)){
            return RespBean.ok("计算所有员工的年终奖12+n成功!");
        }
        return RespBean.error("计算所有员工的年终奖12+n失败!");
    }

    @GetMapping("/yearcheckbydepid")
    @SystemControllerLog(description="自动计算所选部门的所有员工的年终奖12+n")
    public RespBean yearSalarycheckByDepid(Integer depid,Date[] timerange,Integer n){
        if(salarycheckService.yearSalarycheckByDepid(depid,timerange,n)){
            return RespBean.ok("计算所选部门的所有员工的年终奖12+n成功!");
        }
        return RespBean.error("计算所选部门的所有员工的年终奖12+n失败!");
    }

    @PostMapping("/yearcheckbyworkid")
    @SystemControllerLog(description="自动计算所选员工的年终奖12+n")
    public RespBean yearSalarycheckByWorkid(@RequestParam Date[] timerange,@RequestParam Integer n, @RequestBody List<Employee> employees){
        if(salarycheckService.yearSalarycheckByWorkid(employees,timerange,n)){
            return RespBean.ok("计算所选员工的年终奖12+n成功!");
        }
        return RespBean.error("计算所选员工的年终奖12+n失败!");
    }
}
