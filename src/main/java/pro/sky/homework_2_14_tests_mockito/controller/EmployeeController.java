package pro.sky.homework_2_14_tests_mockito.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2_14_tests_mockito.model.Employee;
import pro.sky.homework_2_14_tests_mockito.service.EmployeeService;
import java.util.Map;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public ResponseEntity<Employee> add(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("salary") Integer salary,
            @RequestParam("department") Integer department){
       // if (EmployeeValidate.validate(firstName, lastName)){
            return ResponseEntity.ok(employeeService.add(firstName, lastName, salary, department));
       //}else {
           // return ResponseEntity.badRequest().build();
       // }
    }
    @GetMapping("/remove")
    public void removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }
    @GetMapping("/all")
    public Map<String, Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}





