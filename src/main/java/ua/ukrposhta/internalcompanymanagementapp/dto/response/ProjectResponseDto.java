package ua.ukrposhta.internalcompanymanagementapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String description;
}
