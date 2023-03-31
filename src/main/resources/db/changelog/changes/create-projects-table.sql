--liquibase formatted sql;
--changeset <postgres>:<create-projects-table>

CREATE TABLE IF NOT EXISTS projects
(
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

--rollback DROP TABLE projects;
