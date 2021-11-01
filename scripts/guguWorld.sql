21-11-01						
						
-- 사용자						
create table guguUser(						
idx int auto_increment,						
name varchar(10) not null,						
email varchar(30) not null,						
password varchar(10) not null,						
birth int not null,						
gender char(1) not null check (gender in('F','M')),						
phone_number varchar(13) not null,						
hobby varchar(30),   -- ���						
school varchar(20), -- ��� �б�						
job varchar(20),   -- ����						
mbti char(4), -- MBTI						
filename varchar(50),						
short_intro varchar(30),						
introduce varchar(60),-- �ڱ�Ұ�						
title varchar(30),						
primary key(idx)						
);						
-- -----------------------------------------------------------------------------						
-- 홈						
create table guguHome(						
	u_idx int ,					
	todayCount int default 0, -- ���� �湮��					
	totalCount int default 0,					
	primary key(u_idx),					
	foreign key(u_idx) references guguUser(idx)					
);	-- �ڱ�Ұ�introduce varchar(60), -- �ڱ�Ұ�					
						
-- -----------------------------------------------------------------------------						
-- 사진첩		카테고리		
create table gugucategory(						
	u_idx int,					
	category varchar(30),					
	foreign key(u_idx) references guguUser(idx)					
)						
-- -----------------------------------------------------------------------------						
-- 사진첩					
create table guguGallery(						
	idx   int   auto_increment,					
	u_idx int,					
	category varchar(30),					
	title varchar(20) not null,					
	filename varchar(50) not null,					
	gdate timestamp default current_timestamp,					
	gcontent varchar(100),					
	heart int default 0,					
	primary key(idx),					
	foreign key(u_idx) references gugucategory(u_idx)					
);						
						
-- -----------------------------------------------------------------------------						
-- 게시판					
create table guguBoard(						
	idx	int auto_increment,				
	u_idx int,					
	subject	varchar(40)	not null,			
	content	varchar(1000),				
	heart int default 0,					
	wdate datetime default current_timestamp,					
	commentCount smallint default 0,					
	primary key(idx),					
	foreign key(u_idx) references guguUser(idx)					
);						
-- -----------------------------------------------------------------------------						
-- 방명록						
create table guestBook(						
	idx	int	auto_increment,			
	u_idx int,					
	v_idx int,					
	content	varchar(200),				
	name varchar(10) not null,					
	wdate datetime default current_timestamp,					
	primary key(idx),					
	foreign key(u_idx) references guguUser(idx)					
);						
-- -----------------------------------------------------------------------------						
-- 친구					
create table mate(						
	u_idx int, -- ģ�� idx					
	v_idx int, -- �� idx					
	state char(1) check (state in('H','O','X')), -- ģ�� ��û : O, ģ���� �� : H					
	nickName varchar(20),					
	foreign key(u_idx) references guguUser(idx)					
);						
-- -----------------------------------------------------------------------------						
-- 게시판 댓글					
create table boardComment(						
	idx int auto_increment,					
	u_idx int not null,					
	board_idx int,					
	name varchar(10) not null,					
	content	varchar(100) not null,				
	wdate timestamp	default current_timestamp,				
	primary key(idx),					
	foreign key(board_idx) references guguBoard(idx)					
);						
-- -----------------------------------------------------------------------------						
-- 갤러리 댓글					
create table galleryComment(						
idx int auto_increment,						
u_idx int not null,						
gallery_idx int,						
name varchar(10) not null,						
content varchar(100) not null,						
wdate timestamp   default current_timestamp,						
primary key(idx),						
foreign key(gallery_idx) references guguGallery(idx)						
);						
-- -----------------------------------------------------------------------------						
-- 방명록 댓글					
create table gbookComment(						
	idx int auto_increment,					
	u_idx int not null,					
	book_idx int,					
	name varchar(10) not null,					
	content	varchar(100) not null,				
	wdate timestamp default current_timestamp,					
	primary key(idx),					
	foreign key(book_idx) references guestbook(idx)					
);						
						