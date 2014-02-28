drop table subject_student;
drop table subject_teacher;
drop table Student;
drop table Teacher;
drop table Subject;

create table Subject (
id_subject int primary key not null unique,
subject_name varchar(30) not null,
description varchar(255) not null,
teacher varchar(30),
pool varchar(1),
first_elective_round varchar(1)
);

create table Teacher (
id_teacher int primary key not null unique,
teacher_name varchar(30),
intials varchar(3)
);

create table Student (
id_student int primary key not null unique,
student_name varchar(30)
);

create table subject_teacher (
teacher_id int,
subject_id int,
constraint fk_teacherid foreign key(teacher_id) references Teacher(id_teacher),
constraint fk_subjectid foreign key(subject_id) references Subject(id_subject),
primary key(teacher_id, subject_id)
);

create table subject_student (
student_id int,
subject_id int,
pool varchar(1),
priority int,
constraint fk_studentid foreign key(student_id) references Student(id_student),
constraint fk_subjectid foreign key(subject_id) references Subject(id_subject),
primary key(teacher_id, subject_id)
);