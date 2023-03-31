package ua.ukrposhta.internalcompanymanagementapp.service.mapper;

import org.springframework.stereotype.Component;
import ua.ukrposhta.internalcompanymanagementapp.dto.request.EmployeeRequestDto;
import ua.ukrposhta.internalcompanymanagementapp.dto.response.EmployeeResponseDto;
import ua.ukrposhta.internalcompanymanagementapp.model.Employee;
import ua.ukrposhta.internalcompanymanagementapp.model.Level;
import ua.ukrposhta.internalcompanymanagementapp.model.Type;

@Component
public class EmployeeMapper implements RequestDtoMapper<EmployeeRequestDto, Employee>,
        ResponseDtoMapper<EmployeeResponseDto, Employee> {
    @Override
    public Employee mapToModel(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setLevel(Level.valueOf(dto.getLevel().toUpperCase()));
        employee.setType(Type.valueOf(dto.getType().toUpperCase()));
        return employee;
    }

    @Override
    public EmployeeResponseDto mapToDto(Employee employee) {
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        responseDto.setId(employee.getId());
        responseDto.setName(employee.getName());
        responseDto.setSurname(employee.getSurname());
        responseDto.setLevel(employee.getLevel());
        responseDto.setType(employee.getType());
        responseDto.setProjects(employee.getProjects());
        return responseDto;
    }
}
