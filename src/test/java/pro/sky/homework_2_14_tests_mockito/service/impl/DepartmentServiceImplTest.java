package pro.sky.homework_2_14_tests_mockito.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework_2_14_tests_mockito.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private final List<Employee> employees = new ArrayList<>(){{
        add(new Employee("Aleksey", "Romanov", 100_000, 1));
        add(new Employee("Mikhail", "Titov", 200_000, 1));
        add(new Employee("Sergey", "Nikolaev", 300_000, 1));
    }};

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        //given
        final int departmentId = 1;
        final Map <String, Employee> employeeMap = new HashMap<>();
        for (Employee employee:employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        given(employeeService.getAllEmployees()).willReturn(employeeMap);

        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);

        //then
        assertEquals(employees.get(2), employeeWithMaxSalary);
        verify(employeeService, times(1)).getAllEmployees();

    }
    @Test
    void shouldReturnNullWhenNoEmployeesInDepartment() {
        //given
        final int departmentId = 2;
        final Map <String, Employee> employeeMap = new HashMap<>();
        for (Employee employee:employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        given(employeeService.getAllEmployees()).willReturn(employeeMap);

        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);

        //then
        assertNull(employeeWithMaxSalary);
        verify(employeeService, times(1)).getAllEmployees();

    }

    @Test
    void shouldReturnEmployeeWithMinSalary() {
        //given
        final int departmentId = 1;
        final Map <String, Employee> employeeMap = new HashMap<>();
        for (Employee employee:employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        given(employeeService.getAllEmployees()).willReturn(employeeMap);

        //when
        Employee employeeWithMinSalary = departmentService.getEmployeeWithMaxSalary(departmentId);

        //then
        assertEquals(employees.get(2), employeeWithMinSalary);
        verify(employeeService, times(1)).getAllEmployees();

    }

    @Test
    void shouldReturnGroupedByDepartmentEmployees() {
        //given
        final int departmentId = 1;
        final Map <String, Employee> employeeMap = new HashMap<>();
        for (Employee employee:employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        given(employeeService.getAllEmployees()).willReturn(employeeMap);
        //when
        Map<Integer, List<Employee>> employeesByDepartment = departmentService.getGroupedByDepartmentEmployees(departmentId);
        //then
       assertEquals(employeeMap, employeesByDepartment);
        verify(employeeService, times(1)).getAllEmployees();
    }
}