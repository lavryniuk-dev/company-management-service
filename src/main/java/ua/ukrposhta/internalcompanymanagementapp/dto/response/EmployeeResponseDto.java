package ua.ukrposhta.internalcompanymanagementapp.dto.response;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.ukrposhta.internalcompanymanagementapp.model.Level;
import ua.ukrposhta.internalcompanymanagementapp.model.Project;
import ua.ukrposhta.internalcompanymanagementapp.model.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
    private Long id;
    private String name;
    private String surname;
    private Level level;
    private Type type;
    private Set<Project> projects;
}
