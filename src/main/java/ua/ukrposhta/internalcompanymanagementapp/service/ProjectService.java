package ua.ukrposhta.internalcompanymanagementapp.service;

import java.util.List;
import ua.ukrposhta.internalcompanymanagementapp.model.Project;

public interface ProjectService {
    Project add(Project project);

    Project getById(Long id);

    boolean isExistsById(Long id);

    List<Project> getAll();

    List<Project> getAllProjectsByEmployeeId(Long id);

    void deleteById(Long id);
}
