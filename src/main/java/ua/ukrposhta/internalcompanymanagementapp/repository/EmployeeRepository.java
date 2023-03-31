package ua.ukrposhta.internalcompanymanagementapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.ukrposhta.internalcompanymanagementapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByProjectsId(Long projectId);
}
