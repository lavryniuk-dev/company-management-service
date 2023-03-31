--liquibase formatted sql;
--changeset <postgres>:<create-employees-table>

CREATE TABLE IF NOT EXISTS employees
(
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    surname character varying(255) NOT NULL,
    level character varying(255) NOT NULL,
    type character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

--rollback DROP TABLE employees;
