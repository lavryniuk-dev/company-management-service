--liquibase formatted sql;
--changeset <postgres>:<create-projects-sequence-id>

CREATE SEQUENCE IF NOT EXISTS public.projects_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.projects_id_seq;
