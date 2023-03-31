package ua.ukrposhta.internalcompanymanagementapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(generator = "projects_id_seq",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "projects_id_seq",
            sequenceName = "projects_id_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "projects")
    @JsonIgnore
    private Set<Employee> employees = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Project project = (Project) o;
        return Objects.equals(id, project.id)
                && name.equals(project.name)
                && description.equals(project.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
