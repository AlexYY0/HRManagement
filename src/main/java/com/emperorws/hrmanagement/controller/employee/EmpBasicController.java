package com.emperorws.hrmanagement.controller.employee;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.Department;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.service.DepartmentService;
import com.emperorws.hrmanagement.service.EmployeeService;
import com.emperorws.hrmanagement.utils.EmpPOIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/18 14:56
 * @Description: 员工管理控制层
 **/
@RestController
@RequestMapping("/employee/basic/info")
public class EmpBasicController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    @SystemControllerLog(description="获取所有的员工信息")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee,@RequestParam(defaultValue = "") String politic,@RequestParam(defaultValue = "") String nation,@RequestParam(defaultValue = "") String workstate) {
        return employeeService.getEmployeeByPage(page, size, employee,politic,nation,workstate);
    }

    @PostMapping("/")
    @SystemControllerLog(description="添加新的员工信息和自动添加系统用户")
    public RespBean addEmpAndUser(@RequestBody Employee employee) {
        employeeService.addEmpAndUser(employee);
        if ( employee.getResult() + employee.getResult2() == 2) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{workid}")
    @SystemControllerLog(description="删除员工信息")
    public RespBean deleteEmpByEid(@PathVariable Integer workid) {
        if (employeeService.deleteEmpByEid(workid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/deleteemps")
    @SystemControllerLog(description="批量删除员工信息")
    public RespBean deleteEmps(@RequestBody List<Employee> emps){
        if(employeeService.deleteEmps(emps)==emps.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    @SystemControllerLog(description="更新员工信息")
    public RespBean updateEmp(@RequestBody Employee employee) {
        if (employeeService.updateEmp(employee) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/maxWorkID")
    @SystemControllerLog(description="自动获取新的员工工号")
    public RespBean maxWorkID() {
        RespBean respBean = RespBean.build().setStatus(200)
                .setObj(String.format("%011d", employeeService.maxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/deps")
    @SystemControllerLog(description="获取所有的部门组织结构信息")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/import")
    @SystemControllerLog(description="上传文件批量导入员工信息")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = EmpPOIUtils.excel2Employee(file, departmentService.getAllDepartmentsWithOutChildren());
        if (employeeService.addEmpAndUsers(list) == list.size()*2) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }

    @PostMapping("/export")
    @SystemControllerLog(description="批量导出所选择的员工信息")
    public ResponseEntity<byte[]> exportData(@RequestBody List<Employee> list) {
        return EmpPOIUtils.employee2Excel(list);
    }
}
