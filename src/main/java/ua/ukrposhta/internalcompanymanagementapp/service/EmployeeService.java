package ua.ukrposhta.internalcompanymanagementapp.service;

import java.util.List;
import ua.ukrposhta.internalcompanymanagementapp.model.Employee;

public interface EmployeeService {
    Employee add(Employee employee);

    Employee getById(Long id);

    boolean isExistsById(Long id);

    List<Employee> getAll();

    List<Employee> getAllEmployeesByProjectId(Long id);

    void deleteById(Long id);

    void deleteAllEmployees();
}
