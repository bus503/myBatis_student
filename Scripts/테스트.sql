select user(), database ();
use mybatis_study;

select *
from ADDRESSES;
select *
from students;
select*
from tutors;
select*
from courses;
select*
from course_enrollment;

select stud_id as studId, name, email, dob, phone
		from students
		where stud_id=1;

select stud_id, name, email, dob, phone,
		substring(phone, 1,3) as f,
		substring(phone, 5,3) as m,
		substring(phone, 9,4) as l
		from students where stud_id =1;
		
select stud_id as studId, name, email, phone, dob from students;

desc students;

insert into students(stud_id ,name, email, phone, dob) 
values(3, '홍길동', 'test@test.co.kr', '010-1234-1234', '1991-12-18');

select*
from students;

delete 
from students
where stud_id =5;

select stud_id, name, email, phone, dob, a.addr_id, street, city, state, zip, country
from students s join addresses a on s.addr_id = a.addr_id
where stud_id = 1;

select*
from addresses;


select t.tutor_id, t.name as tutor_name,email,c.course_id,c.name,description,start_date,end_date
from tutors t left outer join courses c on t.tutor_id = c.tutor_id 
where t.tutor_id =1;

select*
from students;

insert into students(stud_id,name,email,phone,dob,gender) 
		values();

desc students;

ALTER TABLE mybatis_study.user_pics MODIFY COLUMN pic LONGBLOB NULL COMMENT 'pic';


alter table students add gender tinyint unsigned;
desc students;

desc user_pics;

select*
from user_pics;

select stud_id, name, email, phone, dob, gender
from students
where name='황태원';

delete
from students 
where stud_id =3;

select * from courses
where tutor_id in(1,2);


select *
from courses;

select *
from students;

delete 
from courses
where course_id in(4,5,6);

select*
from tutors;

select*
from courses;

drop procedure if exists course_total;
DELIMITER $$
create procedure course_total(in tutor_id int)
begin
	select t.name as tutor, ifnull(count(c.name),0) as total
	from tutors t left join courses c on t.tutor_id =c.tutor_id 
	where t.tutor_id = tutor_id;
end $$ 
DELIMITER ;

call course_total(1);


select *
from tutors t left join courses c on t.tutor_id =c.tutor_id;

select ifnull(count(c.name),0)
from





		