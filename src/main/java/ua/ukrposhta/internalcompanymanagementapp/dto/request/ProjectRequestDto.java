package ua.ukrposhta.internalcompanymanagementapp.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {
    @Min(0)
    private Long id;
    @Size(min = 2)
    private String name;
    @Size(min = 2)
    private String description;
}
