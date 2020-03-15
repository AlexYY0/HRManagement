package com.emperorws.hrmanagement.controller.salary;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Welfare;
import com.emperorws.hrmanagement.service.WelfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/29 14:04
 * @Description: 福利表控制层
 **/
@RestController
@RequestMapping("/salary/welfare")
public class WelfareController {
    @Autowired
    WelfareService welfareService;

    @GetMapping("/")
    @SystemControllerLog(description="获取所有的福利信息")
    public RespPageBean getAllWelfare(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Welfare welfare){
        if(page==-1&&size==-1) {
            return welfareService.getAllWelfareByPage(null, null, welfare);
        }
        return welfareService.getAllWelfareByPage(page, size, welfare);
    }

    @DeleteMapping("/{welid}")
    @SystemControllerLog(description="删除旧的福利信息")
    public RespBean deleteWelfareById(@PathVariable Integer welid){
        if (welfareService.deleteWelfareById(welid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/")
    @SystemControllerLog(description="添加新的福利信息")
    public RespBean addWelfare(@RequestBody Welfare welfare){
        if (welfareService.addWelfare(welfare) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    @SystemControllerLog(description="修改福利信息")
    public RespBean updateWelfare(@RequestBody Welfare welfare){
        if (welfareService.updateWelfare(welfare) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/deletewels")
    @SystemControllerLog(description="批量删除旧的福利信息")
    public RespBean deleteWelfares(@RequestBody List<Welfare> welfares){
        if(welfareService.deleteWelfares(welfares)==welfares.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
