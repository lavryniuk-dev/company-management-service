--liquibase formatted sql;
--changeset <postgres>:<create-employees-sequence-id>

CREATE SEQUENCE IF NOT EXISTS public.employees_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP SEQUENCE public.employees_id_seq;
