package com.emperorws.hrmanagement.controller.salary;

import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.Treatment;
import com.emperorws.hrmanagement.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/29 13:18
 * @Description: 保障性待遇表控制层
 **/
@RestController
@RequestMapping("/salary/treatment")
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/")
    public List<Treatment> getAllTreatment(){
        return treatmentService.getAllTreatment();
    }

    @DeleteMapping("/{tretid}")
    public RespBean deleteTreatmentById(@PathVariable Integer tretid){
        if (treatmentService.deleteTreatmentById(tretid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/")
    public RespBean addTreatment(@RequestBody Treatment treatment){
        if (treatmentService.addTreatment(treatment) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updateTreatment(@RequestBody Treatment treatment){
        if (treatmentService.updateTreatment(treatment) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/deletetrets")
    public RespBean deleteTreatments(@RequestBody List<Treatment> treatments){
        if(treatmentService.deleteTreatments(treatments)==treatments.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
