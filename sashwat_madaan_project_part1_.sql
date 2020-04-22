/*1. Checking the existing database.*/
show databases;

/*2. Creating database named CONFERENCE_REVIEW.*/
create database conference_review;

/*3. Checking the databases. Below query will display all the databases that exist. */
show databases;

/*4. Using the use command to change the database.*/
use conference_review;

/*5. Creating the AUTHOR table.*/
create table author
(
email_id varchar(100) not null unique,
first_name char(50) not null,
last_name char(50) not null,
constraint author_pk primary key(email_id)
);

/*6.Creating the PAPER table.*/
create table paper
(
paper_id int not null,
title  char(50) not null,
abstract varchar(10000) not null,
file_name char(50) not null,
constraint paper_pk primary key(paper_id)
);

/*7. Creating TOPIC table.*/
create table topic
(
paper_id int not null,
topic_name char(100) not null,
constraint topic_pk primary key(paper_id),
constraint topic_fk foreign key(paper_id)
references paper(paper_id)
on update cascade
on delete cascade
);

/*8. Creating REVIEWER table.*/
create table reviewer
(
reviewer_id int not null,
email_id varchar(50) not null,
first_name char(25) not null,
last_name char(25) not null,
phone_no char(12) null,
affiliation char(50) not null,
author_feedback char(100) null,
committee_feedback char(100) null,
constraint reviewr_pk primary key(reviewer_id)
);

/*9. Creating REVIEW table.*/
create table review
(
rv_id int not null,
paper_id int not null,
reviewer_id int not null,
recommendation char(100) null,
merit_score smallint not null,
readibility_score smallint not null,
originality_score smallint not null,
relevance_score smallint not null,
constraint review_pk primary key(rv_id),
constraint rv_paper_fk foreign key(paper_id)
references paper(paper_id)
on update cascade,
constraint rv_reviewer_fk foreign key(reviewer_id)
references reviewer (reviewer_id)
);

/*10. Populating AUTHOR table.*/
insert into author (email_id , first_name , last_name ) values
( 'sw12@gmail.com', 'sashwat', 'madaan',
( 'as23@gmail.com', 'afreen', 'shaikh’),
( 'kp34@gmail.com', 'krishna','panyala');


/*11. Populating PAPER table.*/
insert into paper(paper_id, title, abstract, file_name) values
(10, 'biodiesel, ethanol and peroxide', 'experimental investigation of performance of  biodiesel, ethanol and peroxide blends in 60 w diesel engine.', 'bep'),
(11, 'automated monitoring system',  'automated monitoring system to support investigation of contributing factors of work-related disorders and accidents', 'ams'),
(12, 'cloud computing problem', 'access control and data security are two most critical problems with cloud computing. access control can be defined as a procedure by which users can access data from the cloud server.', 'cc');

/*12. Populating TOPIC table.*/
insert into topic (paper_id, topic_name) values
(11,'chemical'),
(12, 'it'),
(13,'biology');

/*13. Populating REVIEWER table.*/
insert into reviewer (reviewer_id, email_id , first_name , last_name, phone_no, affiliation) values
(101,'kj09@gmail.com','kalyani','jhaveri',9987654321,'ruan publications'),
(102,'is98@gmail.com','isha','seth',9887765432,'siia publications'),
(103,'jj87@gmail.com','jordan','james',9877665432,'xiyox publications');

/*14. Population review table.*/
insert into review (rv_id, paper_id, reviewer_id, merit_score, readibility_score, originality_score, relevance_score) values
(1100,10,101,8,9,9,9),
(1200,12,102,10,9,10,10),
(1300,11,103,8,8,9,9);

/*15. Below query will display all the authors from the AUTHOR table.*/
select * 
from author
order by last_name;

/*16. Below query will display all the papers from the PAPER table.*/
select * 
from paper;

/*17. Below query will display all the reviewers from the REVIEWER table.*/
select * 
from reviewer 
order by reviewer_id;

/*18. Below query will display all the reviews with a merit score of 10 from the REVIEW table.*/
select * 
from review 
where merit_score=’10’;

/*19. Below query will arrange all the reviews in descending order from the REVIEW table.*/
select * 
from review 
order by relevance_score desc;

/*20. Below query will display the total number of papers from the PAPER table.*/
select count(*) as number_of_papers 
from paper;




