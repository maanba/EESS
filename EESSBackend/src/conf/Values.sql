
insert into Subject values(1, 'cs', 'dette er csharp', null, null, null);
insert into Subject values(2, 'python', 'dette er python', 'Torben', 'A', null);
insert into Subject values(3, 'Android', 'dette er android', 'peter', null, 'Y');
insert into Subject values(4, 'GameDev', 'dette er gamedev', 'tobias', null, 'Y');

insert into Teacher values(100, 'Torben', 'tor');
insert into Teacher values(101, 'Peter', 'pet');
insert into Teacher values(102, 'Anders', 'and');

insert into Student values(200, 'jonh hitler', 1, 4, 2, 3);
insert into Student values(201, 'Monty mus', 4, 2, 1, 3);
insert into Student values(202, 'James Bond', 2, 1, 3, 4);

insert into subject_teacher values(100, 2);
insert into subject_teacher values(101, 1);
insert into subject_teacher values(102, 3);

-- insert into subject_student values(200, 1, null, 1);
-- insert into subject_student values(200, 4, null, 2);
-- insert into subject_student values(200, 3, null, 1);
-- insert into subject_student values(200, 2, null, 2);
-- insert into subject_student values(201, 1, null, 2);
-- insert into subject_student values(201, 4, null, 2);
-- insert into subject_student values(201, 3, null, 1);
-- insert into subject_student values(201, 2, null, 1);
-- insert into subject_student values(202, 1, null, 1);
-- insert into subject_student values(202, 4, null, 2);
-- insert into subject_student values(202, 3, null, 2);
-- insert into subject_student values(202, 2, null, 1);