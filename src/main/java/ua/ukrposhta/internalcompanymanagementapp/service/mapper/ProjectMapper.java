package ua.ukrposhta.internalcompanymanagementapp.service.mapper;

import org.springframework.stereotype.Component;
import ua.ukrposhta.internalcompanymanagementapp.dto.request.ProjectRequestDto;
import ua.ukrposhta.internalcompanymanagementapp.dto.response.ProjectResponseDto;
import ua.ukrposhta.internalcompanymanagementapp.model.Project;

@Component
public class ProjectMapper implements RequestDtoMapper<ProjectRequestDto, Project>,
        ResponseDtoMapper<ProjectResponseDto, Project> {
    @Override
    public Project mapToModel(ProjectRequestDto dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        return project;
    }

    @Override
    public ProjectResponseDto mapToDto(Project project) {
        ProjectResponseDto responseDto = new ProjectResponseDto();
        responseDto.setId(project.getId());
        responseDto.setName(project.getName());
        responseDto.setDescription(project.getDescription());
        return responseDto;
    }
}
