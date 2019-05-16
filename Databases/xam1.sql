create table Student(
    studentID varchar(10) not null, -- IT17046558
    firstname varchar(15), -- Vishwa
    lastname varchar(15), -- Gunarathne
    email varchar(30), -- justmakeavish@gmail.com
    phone char(10), -- 0773969501
    xamStatus varchar(10), -- Registered/Unregistered--
    password varchar(16), -- n0tag00dpW!
    constraint pk_student primary key (studentID)
);

create table Teacher(
    teacherID varchar(10) not null, -- TE17035298
    firstname varchar(15), -- Gayana
    lastname varchar(15), -- Fernando
    email varchar(30), -- gayana.f@sliit.lk
    phone char(10), -- 0112674839
    xamStatus varchar(10), -- Registered/Unregistered
    password varchar(16), -- n0tag00dpW!
    constraint pk_teacher primary key (teacherID)
);

create table Subject(
    subjectID varchar(6), -- IT2020
    teacherID varchar(10), -- TE17035298
    subjectName varchar(40), -- Object Oriented Programming - Java
    credit float, -- 4.0
    constraint pk_subject primary key (subjectID),
    constraint fk_tidS foreign key (teacherID) references Teacher(teacherID)
);

create table Exam(
    examID varchar(10), -- IT2020MID2
    subjectID varchar(10), -- IT2020
    examName varchar(20), -- Mid semester exam
    enrlmntKey varchar(10),
    constraint pk_exam primary key (examID),
    constraint fk_exaS foreign key (subjectID) references Subject(subjectID)
);

create table Question(
    questionID int not null AUTO_INCREMENT,
    examID varchar(10), -- IT2020
    constraint pk_question primary key (questionID),
    constraint fk_exQ foreign key (examID) references Exam(examID)
);

create table Answers(
    answerID int not null AUTO_INCREMENT,
    questionID varchar(10),
    correctAnswer varchar(200), -- (Correct Answer)
    altAnswer1 varchar(200), -- (Wrong answer 1)
    altAnswer2 varchar(200), -- (Wrong answer 2) if there is no wrong answer 2, keep this null
    altAnswer3 varchar(200), -- (Wrong answer 3) if there is no wrong answer 3, keep this null
    constraint pk_answer primary key (answerID),
    constraint fk_qidA foreign key (questionID) references Question(questionID)
);

create table StudentSubjects(
    studentID varchar(10) not null,
    subjectID varchar(6),
    primary key (studentID, subjectID),
    constraint fk_studentSS foreign key (studentID) references Student(studentID),
    constraint fk_subjectSS foreign key (subjectID) references Subject(subjectID)
);

create table test(
    tid varchar(5) primary key,
    tname varchar(10),
    tvalue1 varchar(10)
);

alter table Question
add question varchar(150);

insert into Question 
(examID, question)
values 
('IT2030MID1', 'What is JIT compiler?'),
('IT2030MID1', 'A top level class can be private or protected.'),
('IT2030MID1', 'Inheritance represents'),
('IT2030MID1', 'Try statements can be nested.'),
('IT2030MID1', 'Which of the following is true about private access modifier?'),
('IT2030MID1', 'What is inheritance?'),
('IT2030MID1', 'What is the default value of char variable?');

-- answerID was set to 'auto increment' before below execution

insert into Answers
(questionID, correctAnswer, altAnswer1, altAnswer2, altAnswer3)
values
(1, 'JIT improves the runtime performance of computer programs based on bytecode.', 'JIT is an application development framework.', 'JIT is an implementation of the Java Virtual Machine which executes Java programs.', 'None of the mentioned.'),
(2, 'False', 'True', null, null),
(3, 'IS-A relationship.', 'HAS-A relationship.', null, null),
(4, 'True', 'False', null, null),
(5, 'Variables, methods and constructors which are declared private can be accessed only by the members of the same class.', 'Variables, methods and constructors which are declared private can be accessed by any class lying in same package.', 'Variables, methods and constructors which are declared private in the superclass can be accessed only by its child class.', 'None of the mentioned.'),
(6, 'It is the process where one object acquires the properties of another.', null, null, null),
(7, "'\u0000'", null, null, null);

select q.questionID, q.question, a.correctAnswer, a.altAnswer1, a.altAnswer2, a.altAnswer3 from Question q, Answers a where examID = 'IT2030MID1' and q.questionID = a.answerID

select subjectName from subject where subjectID = ''

select examName from exam where examID = ''

-- 2 new tables

create table Results(
    resultID int not null auto increment,
    examID varchar(10),
    studentID varchar(10),
    result int, -- marks
    examstatus varchar(10), -- pass or failed
    constraint pkResults primary key (resultID),
    constraint examRe foreign key (examID) references Exam(examID),
    constraint studentRe foreign key (studentID) references Student(studentID)
);

create table GivenAnswers(
    studentID varchar(10),
    examID varchar(10),
    questionID int,
    answer varchar(200),
    constraint pkgivenAnswers primary key (studentID, examID, questionID),
    constraint studentidGA foreign key (studentID) references Student(studentID),
    constraint examidGA foreign key (examID) references Exam(examID),
    constraint qidGA foreign key (questionID) references Question(questionID)
);

insert into Student
(studentID, firstname, lastname, email, phone, xamStatus, password)
values
('IT125', 'Iresh', 'Udara', 'iukrox@gmail.com', '0723454567', 'Registered', 'tharu2'),
('IT126', 'Pasindu', 'Senarath', 'pas@gmail.com', '0776785674', 'Registered', 'single4life'),
('IT127', 'Rajeewa', 'Harshana', 'focus@gmail.com', '0774536278', 'Registered', 'rajeewa69'),
('IT128', 'Chamika', 'Danusekara', 'chamika@gmail.com', '0754566789', 'Registered', 'chamibada'),
('IT129', 'Thanuja', 'Dilhan', 'ataya@gmail.com', '0743564781', 'Registered', 'scoobydoo'),
('IT130', 'Fazlur', 'Rahman', 'fazl@gmail.com', '0710983967', 'Registered', 'lenovo'),
('IT131', 'Roshan', 'Nizar', 'roshan.jr@gmail.com', '0774567388', 'Registered', 'shimra')