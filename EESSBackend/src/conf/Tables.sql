--drop table subject_student;
drop table subject_teacher;
drop table Student;
drop table Teacher;
drop table Subject;

create table Subject (
id_subject int primary key,
subject_name varchar(30) not null,
description varchar(255) not null,
teacher varchar(30),
pool varchar(1),
first_elective_round varchar(1)
);

create table Teacher (
id_teacher int primary key,
teacher_name varchar(30),
intials varchar(3)
);

create table Student (
id_student int primary key,
student_name varchar(30),
first_priority_a int,
first_priority_b int,
second_priority_a int,
second_priority_b int,
constraint fk_sub_one_a  foreign key(first_priority_a) references Subject(id_subject),
constraint fk_sub_one_b  foreign key(first_priority_b) references Subject(id_subject),
constraint fk_sub_two_a  foreign key(second_priority_a) references Subject(id_subject),
constraint fk_sub_two_b  foreign key(second_priority_b) references Subject(id_subject)
);

create table subject_teacher (
teacher_id int,
subject_id int,
constraint fk_teacherid foreign key(teacher_id) references Teacher(id_teacher),
constraint fk_subjectid1 foreign key(subject_id) references Subject(id_subject),
primary key(teacher_id, subject_id)
);

-- create table subject_student (
-- student_id int,
-- subject_id int,
-- pool varchar(1),
-- priority int,
-- constraint fk_studentid foreign key(student_id) references Student(id_student),
-- constraint fk_subjectid2 foreign key(subject_id) references Subject(id_subject),
-- primary key(student_id, subject_id)
-- );