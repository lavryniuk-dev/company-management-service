package ua.ukrposhta.internalcompanymanagementapp.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ukrposhta.internalcompanymanagementapp.exception.ResourceNotFoundException;
import ua.ukrposhta.internalcompanymanagementapp.model.Employee;
import ua.ukrposhta.internalcompanymanagementapp.repository.EmployeeRepository;
import ua.ukrposhta.internalcompanymanagementapp.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not found Employee with id = " + id));
    }

    @Override
    public boolean isExistsById(Long id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployeesByProjectId(Long id) {
        return employeeRepository.findEmployeesByProjectsId(id);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
