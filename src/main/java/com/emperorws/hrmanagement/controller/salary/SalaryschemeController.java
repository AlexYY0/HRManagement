package com.emperorws.hrmanagement.controller.salary;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.Salaryscheme;
import com.emperorws.hrmanagement.service.SalaryschemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/14 12:07
 * @Description: 薪资方案管理控制层
 **/
@RestController
@RequestMapping("/salary/scheme")
public class SalaryschemeController {
    @Autowired
    SalaryschemeService salaryschemeService;

    @GetMapping("/")
    @SystemControllerLog(description="获取所有的薪资计算方案信息")
    public List<Salaryscheme> getAllSalaryscheme(){
        return salaryschemeService.getAllSalaryscheme();
    }

    @DeleteMapping("/{ssid}")
    @SystemControllerLog(description="删除旧的薪资计算方案信息")
    public RespBean deleteSalaryschemeById(@PathVariable Integer ssid){
        if (salaryschemeService.deleteSalaryschemeById(ssid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/")
    @SystemControllerLog(description="添加新的薪资计算方案信息")
    public RespBean addSalaryscheme(@RequestBody Salaryscheme salaryscheme){
        if (salaryschemeService.addSalaryscheme(salaryscheme) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    @SystemControllerLog(description="修改旧的薪资计算方案信息")
    public RespBean updateSalaryscheme(@RequestBody Salaryscheme salaryscheme){
        if (salaryschemeService.updateSalaryscheme(salaryscheme) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/deletesalsches")
    @SystemControllerLog(description="批量删除旧的薪资计算方案信息")
    public RespBean deleteSalaryschemes(@RequestBody List<Salaryscheme> salaryschemes){
        if(salaryschemeService.deleteSalaryschemes(salaryschemes)==salaryschemes.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
