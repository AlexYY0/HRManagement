package com.emperorws.hrmanagement.controller.employee;

import com.emperorws.hrmanagement.model.Department;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.service.DepartmentService;
import com.emperorws.hrmanagement.service.EmployeeService;
import com.emperorws.hrmanagement.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
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
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee,@RequestParam(defaultValue = "") String politic,@RequestParam(defaultValue = "") String nation,@RequestParam(defaultValue = "") String workstate) {
        return employeeService.getEmployeeByPage(page, size, employee,politic,nation,workstate);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id) {
        if (employeeService.deleteEmpByEid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/deleteemps")
    public RespBean deleteEmps(@RequestBody List<Employee> emps){
        if(employeeService.deleteEmps(emps)==emps.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee) {
        if (employeeService.updateEmp(employee) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID() {
        RespBean respBean = RespBean.build().setStatus(200)
                .setObj(String.format("%011d", employeeService.maxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file, departmentService.getAllDepartmentsWithOutChildren());
        if (employeeService.addEmps(list) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }

    @PostMapping("/export")
    public ResponseEntity<byte[]> exportData(@RequestBody List<Employee> list) {
        //List<Employee> list = (List<Employee>) employeeService.getEmployeeByPage(null, null, null,null,null,null).getData();
        return POIUtils.employee2Excel(list);
    }
}
