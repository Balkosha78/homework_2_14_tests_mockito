package pro.sky.homework_2_14_tests_mockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2_14_tests_mockito.model.Employee;
import pro.sky.homework_2_14_tests_mockito.service.DepartmentService;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private  DepartmentService departmentService;
    @GetMapping("max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") Integer departmentId){
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") Integer departmentId){
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(
            @RequestParam(name = "departmentId", required = false) Integer departmentId){
        return departmentService.getGroupedByDepartmentEmployees(departmentId);
    }
}
