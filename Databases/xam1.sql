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

create table Question(
    questionID int not null AUTO_INCREMENT,
    subjectID varchar(10), -- IT2020
    constraint pk_question primary key (questionID),
    constraint fk_sidQ foreign key (subjectID) references Subject(subjectID)
);

create table Answers(
    answerID int not null AUTO_INCREMENT,
    questionID varchar(10),
    correctAnswer varchar(100), -- (Correct Answer)
    altAnswer1 varchar(100), -- (Wrong answer 1)
    altAnswer2 varchar(100), -- (Wrong answer 2) if there is no wrong answer 2, keep this null
    altAnswer3 varchar(100), -- (Wrong answer 3) if there is no wrong answer 3, keep this null
    constraint pk_answer primary key (answerID),
    constraint fk_qidA foreign key (questionID) references Question(questionID)
);

create table test(
    tid varchar(5) primary key,
    tname varchar(10),
    tvalue1 varchar(10)
);