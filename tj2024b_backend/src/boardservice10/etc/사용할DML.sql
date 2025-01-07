# 프로젝트 : boardservice10 DML과 샘플 INSERT
# 데이터베이스 구성
drop database if exists boardservice10; -- 만일 boardservice10 DB명이 존재하면 삭제
create database boardservice10;			-- boardservice10 DB 생성
use boardservice10;						-- boardservice10 사용

# 테이블 생성
drop table if exists member;
create table member(
	mno int unsigned auto_increment,
    mid varchar(30) not null unique,
    mpwd varchar(30) not null,
    mname varchar(30) not null,
    mphone varchar(13) not null unique,
    mdate datetime default now(),
    constraint primary key(mno)
);
insert into member(mid, mpwd, mname, mphone) values ('qwe123', 'a123456', '유재석', '010-3333-3333');
insert into member(mid, mpwd, mname, mphone) values ('asd123', 'b123456', '강호동', '010-4444-4444');
insert into member(mid, mpwd, mname, mphone) values ('zxc123', 'c123456', '신동엽', '010-5555-5555');
insert into member(mid, mpwd, mname, mphone) values ('vbn456', 'd123456', '서장훈', '010-6666-6666');
insert into member(mid, mpwd, mname, mphone) values ('rty789', 'e123456', '하하', '010-7777-7777');

drop table if exists category;
create table category(
	cno int unsigned auto_increment,
    cname varchar(30) not null unique,
    cdate datetime default now(),
    constraint primary key(cno)
);
insert into category(cname) values ('자유');
insert into category(cname) values ('질문');
insert into category(cname) values ('노하우');
insert into category(cname) values ('공부');
insert into category(cname) values ('친목');

drop table if exists board;
create table board(
	bno  int unsigned auto_increment,
    btitle varchar(100) not null,
    bcontent longtext not null,
    bview int unsigned default 0,
    bdate datetime default now(),
    mno int unsigned not null,
    cno int unsigned not null,
    constraint primary key(bno),
    # FK 제약조건 옵션 
    # on update/delete [옵션] : FK가 참조하는 PK가 삭제/수정에 따른 FK의 제약 옵션
    # restrict(기본값)		 : FK가 PK를 참조 중이면 PK레코드를 삭제/수정 불가능
    # cascade				 : PK레코드가 삭제/수정되면 FK가 같이 삭제/수정
    # set null				 : PK값이 삭제/수정되면 FK는 참조를 없애고 null로 변경
    -- 특정 회원이 회원탈퇴로 PK레코드가 삭제되면 그를 참조하고 있는 작성자 FK레코드도 같이 삭제/수정한다.
    constraint foreign key(mno) references member(mno) on update cascade on delete cascade,
    -- 특정 카테고리가 삭제되면 그를 참조하고 있는 게시물도 같이 삭제/수정한다.
    constraint foreign key(cno) references category(cno) on update cascade on delete cascade
);
insert into board(btitle, bcontent, mno, cno) values ('안녕하세요1', '힘찬 자바1', 1, 1);
insert into board(btitle, bcontent, mno, cno) values ('안녕하세요2', '힘찬 자바2', 1, 3);
insert into board(btitle, bcontent, mno, cno) values ('안녕하세요3', '힘찬 자바3', 4, 3);
insert into board(btitle, bcontent, mno, cno) values ('안녕하세요4', '힘찬 자바4', 2, 5);
insert into board(btitle, bcontent, mno, cno) values ('안녕하세여5', '힘찬 자바5', 3, 2);

drop table if exists reply;
create table reply(
	rno int unsigned auto_increment,
    rcontent text not null,
    rdate datetime default now(),
    mno int unsigned not null,
    bno int unsigned not null,
    constraint primary key(rno),
    constraint foreign key(mno) references member(mno) on update cascade on delete cascade,
    constraint foreign key(bno) references board(bno) on update cascade on delete cascade
);
insert into reply(rcontent, mno, bno) values ('하하하 댓글1', 3, 3);
insert into reply(rcontent, mno, bno) values ('하하하 댓글2', 3, 3);
insert into reply(rcontent, mno, bno) values ('하하하 댓글3', 4, 5);
insert into reply(rcontent, mno, bno) values ('하하하 댓글4', 5, 5);
insert into reply(rcontent, mno, bno) values ('하하하 댓글5', 1, 4);

select * from member;
select * from category;
select * from board;
select * from reply;