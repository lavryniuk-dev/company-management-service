package ua.ukrposhta.internalcompanymanagementapp.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
import ua.ukrposhta.internalcompanymanagementapp.dto.request.ProjectRequestDto;
import ua.ukrposhta.internalcompanymanagementapp.dto.response.EmployeeResponseDto;
import ua.ukrposhta.internalcompanymanagementapp.dto.response.ProjectResponseDto;
import ua.ukrposhta.internalcompanymanagementapp.exception.ResourceNotFoundException;
import ua.ukrposhta.internalcompanymanagementapp.model.Employee;
import ua.ukrposhta.internalcompanymanagementapp.model.Project;
import ua.ukrposhta.internalcompanymanagementapp.service.EmployeeService;
import ua.ukrposhta.internalcompanymanagementapp.service.ProjectService;
import ua.ukrposhta.internalcompanymanagementapp.service.mapper.EmployeeMapper;
import ua.ukrposhta.internalcompanymanagementapp.service.mapper.ProjectMapper;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final EmployeeService employeeService;
    private final ProjectMapper projectMapper;
    private final EmployeeMapper employeeMapper;

    @PostMapping("/employees/{employeeId}/projects")
    public ProjectResponseDto addProject(@PathVariable("employeeId") Long employeeId,
                                         @RequestBody @Valid ProjectRequestDto projectRequest) {
        Project requestModel = projectMapper.mapToModel(projectRequest);
        Project project = Optional.ofNullable(employeeService.getById(employeeId)).map(employee -> {
            Long projectId = projectRequest.getId();

            if (projectId != null) {
                Project projectFromDB = projectService.getById(projectId);
                employee.addProject(projectFromDB);
                employeeService.add(employee);
                return projectFromDB;
            }

            employee.addProject(requestModel);
            return projectService.add(requestModel);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Not found Employee with id = " + employeeId));

        return projectMapper.mapToDto(project);
    }

    @GetMapping("/projects/{id}")
    public ProjectResponseDto getProjectById(@PathVariable("id") Long id) {
        return projectMapper.mapToDto(projectService.getById(id));
    }

    @GetMapping("/employees/{employeeId}/projects")
    public List<ProjectResponseDto> getAllProjectsByEmployeeId(
            @PathVariable("employeeId") Long employeeId) {
        if (!employeeService.isExistsById(employeeId)) {
            throw new ResourceNotFoundException("Not found Employee with id = " + employeeId);
        }

        List<Project> projects = projectService.getAllProjectsByEmployeeId(employeeId);
        return projects.stream()
                .map(projectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/projects/{projectId}/employees")
    public List<EmployeeResponseDto> getAllEmployeesByProjectId(
            @PathVariable("projectId") Long projectId) {
        if (!projectService.isExistsById(projectId)) {
            throw new ResourceNotFoundException("Not found Project with id = " + projectId);
        }

        List<Employee> employees = employeeService.getAllEmployeesByProjectId(projectId);
        return employees.stream()
                .map(employeeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/projects")
    public List<ProjectResponseDto> getAll() {
        return projectService.getAll()
                .stream()
                .map(projectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/projects/{id}")
    public ProjectResponseDto updateProjectById(
            @PathVariable("id") Long id,
            @RequestBody @Valid ProjectRequestDto projectRequest) {
        Project project = projectService.getById(id);
        project.setName(projectRequest.getName());
        project.setDescription(projectRequest.getDescription());

        return projectMapper.mapToDto(projectService.add(project));
    }

    @DeleteMapping("employees/{employeeId}/projects/{projectId}")
    public ResponseEntity<HttpStatus> deleteProjectFromEmployee(
            @PathVariable("employeeId") Long employeeId,
            @PathVariable("projectId") Long projectId) {
        Employee employee = employeeService.getById(employeeId);

        employee.removeProject(projectId);
        employeeService.add(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
