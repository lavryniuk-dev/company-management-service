package ua.ukrposhta.internalcompanymanagementapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.ukrposhta.internalcompanymanagementapp.model.Level;
import ua.ukrposhta.internalcompanymanagementapp.model.Type;
import ua.ukrposhta.internalcompanymanagementapp.util.EnumValidator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {
    @NotEmpty
    @NotBlank
    @Size(min = 2)
    private String name;
    @NotEmpty
    @NotBlank
    @Size(min = 2)
    private String surname;
    @EnumValidator(enumClass = Level.class, message = "invalid professional skill")
    private String level;
    @EnumValidator(enumClass = Type.class, message = "invalid employee position")
    private String type;
}
