Create database hcl;
use hcl;
create table trainers(
    facultyId int PRIMARY KEY,
    facultyname VARCHAR(50) not null,
    Designation VARCHAR(20),
    Mobileno int,
    Experience int,
    salary int check(salary>0)
);
ALTER TABLE trainers
MODIFY facultyname VARCHAR(50) not null;

ALTER TABLE trainers
ADD age int check(age >0);

CREATE TABLE Dept(
  dept_id int AUTO_INCREMENT primary key,
  dept_name varchar(10)
  );
  
  
  create database school_db;
  create table students(
  student_id int auto_increment primary key,
  student_name varchar(50) not null,
  email varchar(100) unique,
  age int check(age>5),
  city varchar(20) default 'delhi',
  admission_date date
  
  
  );
  
  INSERT INTO students (student_name, email, age, city, admission_date)
VALUES
('Rahul', 'rahul@gmail.com', 20, 'Delhi', '2026-01-10'),
('Aman', 'aman@gmail.com', 21, 'Mumbai', '2026-01-12'),
('Priya', 'priya@gmail.com', 19, 'Noida', '2026-01-15'),
('Sneha', 'sneha@gmail.com', 22, 'Pune', '2026-01-18'),
('Rohit', 'rohit@gmail.com', 20, 'Delhi', '2026-01-20'),
('Anjali', 'anjali@gmail.com', 18, 'Lucknow', '2026-01-22'),
('Vikas', 'vikas@gmail.com', 23, 'Jaipur', '2026-01-25'),
('Neha', 'neha@gmail.com', 19, 'Ghaziabad', '2026-01-28'),
('Karan', 'karan@gmail.com', 21, 'Agra', '2026-02-01'),
('Pooja', 'pooja@gmail.com', 20, 'Delhi', '2026-02-05');

select * from students;

create table marks(
mark_id int primary key,
student_id int,
FOREIGN KEY(student_id) references students(student_id),
subject varchar(10),
score int,
phone varchar(10)
);

INSERT INTO marks (mark_id, student_id, subject, score, phone)
VALUES
(1, 1, 'Java', 85, '9876543210'),
(2, 1, 'SQL', 90, '9876543211'),
(3, 2, 'Java', 78, '9876543212'),
(4, 2, 'SQL', 88, '9876543213'),
(5, 3, 'Java', 92, '9876543214'),
(6, 3, 'SQL', 95, '9876543215'),
(7, 4, 'Java', 75, '9876543216'),
(8, 5, 'SQL', 80, '9876543217'),
(9, 6, 'Java', 89, '9876543218'),
(10, 7, 'SQL', 91, '9876543219');

create table mark_table(
mark_id int primary key,
subject_name varchar(10),
score int
);
INSERT INTO mark_table (mark_id, subject_name, score)
VALUES
(1, 'Java', 85),
(2, 'SQL', 90),
(3, 'Java', 78 ),
(4,  'SQL', 88 ),
(5,  'Java', 92),
(6,  'SQL', 95),
(7,  'Java', 75 ),
(8,  'SQL', 80 ),
(9, 'Java', 89),
(10,  'SQL', 91 );
update mark 
set score = score +5;