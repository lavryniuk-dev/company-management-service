package ua.ukrposhta.internalcompanymanagementapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.ukrposhta.internalcompanymanagementapp.dto.request.ProjectRequestDto;
import ua.ukrposhta.internalcompanymanagementapp.dto.response.ProjectResponseDto;
import ua.ukrposhta.internalcompanymanagementapp.model.Project;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectMapperTest {
    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void shouldMapProjectRequestDtoToProjectModel() {
        Project expectedProject = new Project();
        expectedProject.setName("Gambling");
        expectedProject.setDescription("Application 'Black Jack'");

        Assertions.assertEquals(expectedProject,
                projectMapper.mapToModel(new ProjectRequestDto(expectedProject.getId(), expectedProject.getName(),
                        expectedProject.getDescription())));
    }

    @Test
    public void shouldMapProjectModelToProjectResponseDto() {
        ProjectResponseDto expectedDto =
                new ProjectResponseDto(1L, "Gambling", "Application 'Black Jack'");

        Assertions.assertEquals(expectedDto, projectMapper.mapToDto(
                new Project(expectedDto.getId(), expectedDto.getName(), expectedDto.getDescription(), null)));
    }
}