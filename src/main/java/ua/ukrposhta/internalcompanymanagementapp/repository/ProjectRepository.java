package ua.ukrposhta.internalcompanymanagementapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.ukrposhta.internalcompanymanagementapp.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findProjectsByEmployeesId(Long employeeId);
}
