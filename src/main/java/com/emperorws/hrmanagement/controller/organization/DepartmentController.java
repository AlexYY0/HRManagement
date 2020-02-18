package com.emperorws.hrmanagement.controller.organization;

import com.emperorws.hrmanagement.model.Department;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/15 23:55
 * @Description: 返回部门数据json
 **/
@RestController
@RequestMapping("/organization/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/employee")
    public List<Map<String,Object>> getWorkidAndEmpname(){
        return departmentService.getWorkidAndEmpname();
    }

    @PutMapping("/update")
    public RespBean updateDep(@RequestBody Department dep){
        Integer reslut=departmentService.updateDep(dep);
        dep.setLeadername(departmentService.getLeadernameByLeaderid(dep.getLeaderid()));
        if ( reslut== 1) {
            return RespBean.ok("更新成功!",dep);
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep) {
        departmentService.addDep(dep);
        dep.setLeadername(departmentService.getLeadernameByLeaderid(dep.getLeaderid()));
        if (dep.getResult() == 1) {
            return RespBean.ok("添加成功", dep);
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepById(@PathVariable Integer id) {
        Department dep = new Department();
        dep.setDepid(id);
        departmentService.deleteDepById(dep);
        if (dep.getResult() == -2) {
            return RespBean.error("该部门下有子部门，删除失败");
        } else if (dep.getResult() == -1) {
            return RespBean.error("该部门下有员工，删除失败");
        } else if (dep.getResult() == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
