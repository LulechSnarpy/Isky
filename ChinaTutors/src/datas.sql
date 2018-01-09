use ChinaTutors;

insert into students values('yzw','张子瑾','Andy','','321');
insert into students values('zjx','赵家欣','Clone','','790');
insert into students values('zlh','赵子瑜','Mike','','567');
insert into students values('zyx','宋东生','Jack','','478');
insert into students values('zyh','张延超','Jeffery','','354');

insert into teachers values('qps','蔺东升','Petter','','231');
insert into teachers values('sqe','奥巴马','Dava','','2134');
insert into teachers values('qdq','惠博文','Aaron','','4312');
insert into teachers values('rqs','常英杰','John','','7474');
insert into teachers values('dfr','宗有荣','James','','7453');

insert into courses values('COU000001','Math');
insert into courses values('COU000002','Physics ');
insert into courses values('COU000003','Chemistry');
insert into courses values('COU000004','Politics');
insert into courses values('COU000005','Biology');

insert into classes values('CLA000001','COU000001','qps','Japanese');
insert into classes values('CLA000002','COU000002','sqe','Music');
insert into classes values('CLA000003','COU000003','qdq','Geography');
insert into classes values('CLA000004','COU000004','rqs','History');
insert into classes values('CLA000005','COU000005','dfr','Art');

insert into curricula_variable values('CV00000001','CLA000001','yzw');
insert into curricula_variable values('CV00000002','CLA000001','zjx');
insert into curricula_variable values('CV00000003','CLA000001','zlh');
insert into curricula_variable values('CV00000004','CLA000001','zyx');
insert into curricula_variable values('CV00000005','CLA000001','zyh');

insert into chapters values('CHAP00000001','COU000001','Math','1424','11111');
insert into chapters values('CHAP00000002','COU000001','Physics','5245','11111');
insert into chapters values('CHAP00000003','COU000001','Chemistry','8653','11111');
insert into chapters values('CHAP00000004','COU000001','Politics','2521','11111');
insert into chapters values('CHAP00000005','COU000001','Biology','8565','11111');

insert into exams values('yt56','CHAP00000001','D:/files/yt56.xls',60);
insert into exams values('wt25','CHAP00000002','D:/files/yt56.xls',60);
insert into exams values('qe34','CHAP00000003','D:/files/yt56.xls',60);
insert into exams values('jh09','CHAP00000004','D:/files/yt56.xls',60);
insert into exams values('rh56','CHAP00000005','D:/files/yt56.xls',60);

insert into scores values('SCR0000001','yzw','yt56',80);
insert into scores values('SCR0000002','zjx','wt25',83);
insert into scores values('SCR0000003','zlh','qe34',83);
insert into scores values('SCR0000004','zyx','jh09',82);
insert into scores values('SCR0000005','zyh','rh56',85);

select * from  students;
select * from  teachers;
select * from  courses;
select * from  classes;
select * from  curricula_variable;
select * from  chapters;
select * from  exams;
select * from  scores;