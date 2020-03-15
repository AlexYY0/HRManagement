package com.emperorws.hrmanagement.controller.salary;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Speadd;
import com.emperorws.hrmanagement.service.SpeaddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/29 18:11
 * @Description: 专项附加扣除控制层
 **/
@RestController
@RequestMapping("/salary/specialadditionaldeduction")
public class SpeaddController {
    @Autowired
    SpeaddService speaddService;

    @GetMapping("/")
    @SystemControllerLog(description="获取所有的专扣信息")
    public RespPageBean getAllSpeadd(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Speadd speadd){
        if(page==-1&&size==-1){
            return speaddService.getAllSpeaddByPage(null, null, speadd);
        }
        return speaddService.getAllSpeaddByPage(page, size, speadd);
    }

    @DeleteMapping("/{welid}")
    @SystemControllerLog(description="删除旧的专扣信息")
    public RespBean deleteSpeaddById(@PathVariable Integer welid){
        if (speaddService.deleteSpeaddById(welid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/")
    @SystemControllerLog(description="添加新的专扣信息")
    public RespBean addSpeadd(@RequestBody Speadd speadd){
        if (speaddService.addSpeadd(speadd) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    @SystemControllerLog(description="修改旧的专扣信息")
    public RespBean updateSpeadd(@RequestBody Speadd speadd){
        if (speaddService.updateSpeadd(speadd) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/deletespeadds")
    @SystemControllerLog(description="批量删除旧的专扣信息")
    public RespBean deleteSpeadds(@RequestBody List<Speadd> speadds){
        if(speaddService.deleteSpeadds(speadds)==speadds.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
