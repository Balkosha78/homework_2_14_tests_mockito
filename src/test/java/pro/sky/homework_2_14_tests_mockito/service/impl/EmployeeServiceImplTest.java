package pro.sky.homework_2_14_tests_mockito.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework_2_14_tests_mockito.model.Employee;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {


    @Test
    public void shouldAddEmployee() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Employee employee = new Employee("Aleksey", "Romanov", 100_000, 1);
        employeeService.add("Aleksey", "Romanov", 100_000, 1);
        Map<String, Employee> actual = employeeService.getAllEmployees();
        Map<String, Employee> expected = new HashMap<>(Map.of("AlekseyRomanov", employee));
        assertEquals(expected, actual);
    }
    @Test
    public void shouldAddExistEmployee() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.add("Aleksey", "Romanov", 100_000, 1);
        Assertions.assertThrows(RuntimeException.class, () -> {
            employeeService.add("Aleksey", "Romanov", 100_000, 1);
        });
    }

    @Test
    void shouldRemoveEmployee() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.add("Aleksey", "Romanov", 100_000, 1);
        employeeService.remove("Aleksey", "Romanov");
        Map<String, Employee> actual = employeeService.getAllEmployees();
        Map<String, Employee> expected = new HashMap<>();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldRemoveNonExistEmployee() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Assertions.assertThrows(RuntimeException.class, () -> {
            employeeService.remove("Aleksey", "Romanov");
        });
    }

    @Test
    public void shouldFindEmployee() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.add("Aleksey", "Romanov", 100_000, 1);
        Employee actual = employeeService.find("Aleksey", "Romanov");
        Employee expected = new Employee("Aleksey", "Romanov", 100_000, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindNonExistEmployee() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Assertions.assertThrows(RuntimeException.class, () -> {
            employeeService.find("Aleksey", "Romanov");
        });
    }
}