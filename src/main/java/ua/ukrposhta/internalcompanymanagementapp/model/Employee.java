package ua.ukrposhta.internalcompanymanagementapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(generator = "employees_id_seq",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employees_id_seq",
            sequenceName = "employees_id_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "employees_projects",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<>();

    public void addProject(Project project) {
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public void removeProject(Long projectId) {
        Project project = this.projects.stream()
                .filter(p -> Objects.equals(p.getId(), projectId))
                .findFirst()
                .orElse(null);

        if (project != null) {
            this.projects.remove(project);
            project.getEmployees().remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id)
                && name.equals(employee.name)
                && surname.equals(employee.surname)
                && level == employee.level && type == employee.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, level, type);
    }
}
