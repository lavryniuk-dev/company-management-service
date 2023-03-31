package ua.ukrposhta.internalcompanymanagementapp.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ukrposhta.internalcompanymanagementapp.exception.ResourceNotFoundException;
import ua.ukrposhta.internalcompanymanagementapp.model.Project;
import ua.ukrposhta.internalcompanymanagementapp.repository.ProjectRepository;
import ua.ukrposhta.internalcompanymanagementapp.service.ProjectService;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public Project add(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not found Project with id = " + id));
    }

    @Override
    public boolean isExistsById(Long id) {
        return projectRepository.existsById(id);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getAllProjectsByEmployeeId(Long id) {
        return projectRepository.findProjectsByEmployeesId(id);
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
