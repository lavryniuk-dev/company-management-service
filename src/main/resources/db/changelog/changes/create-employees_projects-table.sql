--liquibase formatted sql;
--changeset <postgres>:<create-employees_projects-table>

CREATE TABLE IF NOT EXISTS employees_projects
(
    employee_id bigint NOT NULL,
    project_id bigint NOT NULL,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES employees (id) ON UPDATE CASCADE,
    FOREIGN KEY (project_id) REFERENCES projects (id) ON UPDATE CASCADE
);

--rollback DROP TABLE employees_projects;
