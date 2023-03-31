package ua.ukrposhta.internalcompanymanagementapp.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ukrposhta.internalcompanymanagementapp.dto.request.EmployeeRequestDto;
import ua.ukrposhta.internalcompanymanagementapp.dto.response.EmployeeResponseDto;
import ua.ukrposhta.internalcompanymanagementapp.model.Employee;
import ua.ukrposhta.internalcompanymanagementapp.service.EmployeeService;
import ua.ukrposhta.internalcompanymanagementapp.service.mapper.EmployeeMapper;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @PostMapping("/employees")
    public EmployeeResponseDto addEmployee(@RequestBody @Valid EmployeeRequestDto employeeRequest) {
        Employee savedEmployee = employeeService.add(employeeMapper.mapToModel(employeeRequest));
        return employeeMapper.mapToDto(savedEmployee);
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable("id") Long id) {
        Employee employeeFromDB = employeeService.getById(id);
        return employeeMapper.mapToDto(employeeFromDB);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @PutMapping("/employees/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable("id") Long id,
                                      @RequestBody @Valid EmployeeRequestDto employeeRequest) {
        Employee requestModel = employeeMapper.mapToModel(employeeRequest);
        Employee employeeFromDb = employeeService.getById(id);
        employeeFromDb.setName(requestModel.getName());
        employeeFromDb.setSurname(requestModel.getSurname());
        employeeFromDb.setLevel(requestModel.getLevel());
        employeeFromDb.setType(requestModel.getType());

        return employeeMapper.mapToDto(employeeService.add(employeeFromDb));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
