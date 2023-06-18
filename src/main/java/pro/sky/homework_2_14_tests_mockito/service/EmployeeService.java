package pro.sky.homework_2_14_tests_mockito.service;

import pro.sky.homework_2_14_tests_mockito.model.Employee;

import java.util.Map;
public interface EmployeeService {
    Employee add(String firstName, String lastName, Integer salary, Integer department);
    void  remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Map<String, Employee> getAllEmployees();
}
