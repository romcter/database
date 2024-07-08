CREATE DATABASE spring_boot_postgres_db;

drop table if exists person cascade;
create table person (id bigint generated by default as identity, created timestamp(6), deleted timestamp(6), name varchar(255), updated timestamp(6), primary key (id));

drop table if exists student cascade;
drop table if exists building cascade;
drop table if exists building_student cascade;

create table building (id bigint generated by default as identity, name varchar(255), primary key (id));
create table building_student (building_id bigint not null, student_id bigint not null);
create table student (id bigint generated by default as identity, name varchar(255), primary key (id));
alter table if exists building_student add constraint FK7g9iilsi0tpa2efncfoa8n5in foreign key (student_id) references student;
alter table if exists building_student add constraint FKegmt59hrpkj8080so7kwl04u foreign key (building_id) references building;

INSERT INTO person (name, created, deleted, updated) VALUES ('USA', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974');
INSERT INTO person (name, created, deleted, updated) VALUES ('France', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974');
INSERT INTO person (name, created, deleted, updated) VALUES ('Brazil', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974');
INSERT INTO person (name, created, deleted, updated) VALUES ('Italy', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974');
INSERT INTO person (name, created, deleted, updated) VALUES ('Canada', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974', '2023-03-25T13:08:32.006974');


INSERT INTO building (name) VALUES ('USA');
INSERT INTO building (name) VALUES ('KMA');
INSERT INTO building (name) VALUES ('FHD');
INSERT INTO building (name) VALUES ('ERT');
INSERT INTO building (name) VALUES ('FDS');
INSERT INTO building (name) VALUES ('SIU');
INSERT INTO building (name) VALUES ('NCV');
INSERT INTO building (name) VALUES ('PER');
--
INSERT INTO student (name) VALUES ('Vivaldi');
INSERT INTO student (name) VALUES ('Motsart');
INSERT INTO student (name) VALUES ('Hang');
INSERT INTO student (name) VALUES ('Trumen');

INSERT INTO building_student (student_id, building_id) VALUES (1, 2);
INSERT INTO building_student (student_id, building_id) VALUES (3, 2);
INSERT INTO building_student (student_id, building_id) VALUES (4, 3);
INSERT INTO building_student (student_id, building_id) VALUES (3, 3);
INSERT INTO building_student (student_id, building_id) VALUES (1, 2);
INSERT INTO building_student (student_id, building_id) VALUES (1, 2);
--
--
--CREATE TABLE `employee` (
--  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
--  `first_name` varchar(50) DEFAULT NULL,
--  `last_name` varchar(50) DEFAULT NULL,
--  PRIMARY KEY (`employee_id`)
--) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
--
--CREATE TABLE `project` (
--  `project_id` int(11) NOT NULL AUTO_INCREMENT,
--  `title` varchar(50) DEFAULT NULL,
--  PRIMARY KEY (`project_id`)
--) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
--
--CREATE TABLE `employee_project` (
--  `employee_id` int(11) NOT NULL,
--  `project_id` int(11) NOT NULL,
--  PRIMARY KEY (`employee_id`,`project_id`),
--  KEY `project_id` (`project_id`),
--  CONSTRAINT `employee_project_ibfk_1`
--   FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
--  CONSTRAINT `employee_project_ibfk_2`
--   FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;