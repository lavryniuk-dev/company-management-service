package ua.ukrposhta.internalcompanymanagementapp.service.mapper;

import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.ukrposhta.internalcompanymanagementapp.dto.request.EmployeeRequestDto;
import ua.ukrposhta.internalcompanymanagementapp.dto.response.EmployeeResponseDto;
import ua.ukrposhta.internalcompanymanagementapp.model.Employee;
import ua.ukrposhta.internalcompanymanagementapp.model.Level;
import ua.ukrposhta.internalcompanymanagementapp.model.Project;
import ua.ukrposhta.internalcompanymanagementapp.model.Type;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void shouldMapEmployeeRequestDtoToEmployeeModel() {
        Employee expectedEmployee = new Employee();
        expectedEmployee.setName("Ethan");
        expectedEmployee.setSurname("Carter");
        expectedEmployee.setLevel(Level.SENIOR);
        expectedEmployee.setType(Type.DEVELOPER);

        Assertions.assertEquals(expectedEmployee,
                employeeMapper.mapToModel(new EmployeeRequestDto(expectedEmployee.getName(), expectedEmployee.getSurname(),
                        "Senior", "Developer")));
    }
}