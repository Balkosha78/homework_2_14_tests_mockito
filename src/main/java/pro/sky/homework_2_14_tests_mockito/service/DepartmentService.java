package pro.sky.homework_2_14_tests_mockito.service;

import pro.sky.homework_2_14_tests_mockito.model.Employee;
import java.util.List;
import java.util.Map;
public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);
    Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(Integer departmentId);
}
