--liquibase formatted sql

--changeset olha:1
CREATE INDEX student_name_index ON student (name);

--changeset olha:2
CREATE INDEX faculty_name_color_index ON faculty (name, color);