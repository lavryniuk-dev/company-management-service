#!/bin/sh

export DATABASE_NAME=$"companydb"
export DATABASE_USER=$"postgres"
export LIQUIBASE_MIGRATIONS=$"classpath:db/changelog/db.changelog-master.yaml"
