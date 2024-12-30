# DB Server에 있는 데이터베이스 전체 출력
show databases;
# 데이터베이스의 위치 출력 (DB Server의 local path 조회)
show variables like 'datadir';
# DB Server에 데이터베이스 생성 
create database mydb1230;
# DB Server에 데이터베이스 삭제
drop database mydb1230;
# 작성한 데이터베이스가 존재하면 삭제
drop database if exists mydb1230;
# 데이터베이스 사용 (DB Server의 사용할 DB 활성화)
use mydb1230;

# 데이터베이스 생성
create database mydb1230;
# 데이터베이스 활성화(사용)
use mydb1230;
# 테이블 생성 CREATE TABLE TABLE명(속성(필드)명 타입);
create table testtable1(필드명 INT);
# 현재 활상화(상용)중인 DB내 모든 테이블 조회
show tables;
# 테이블 생성 (필드(속성)가 여러개일 경우 쉼표로 구분)
create table testtable2(필드명1 int, 필드명2 double);
# 테이블 삭제 DROP TABLE TABLE명;
drop table testtable1;
drop table if exists testtable2, testtable1;
# MySQL 데이터 타입
/*
	[정수]
		tinyint		: 1바이트		-2^7 ~ 2^7-1	java : byte
        smallint	: 2바이트		-2^15 ~ 2^15-1	java : short
        int			: 4바이트		-2^31 ~ 2^31-1	java : int
        bingint		: 8바이트		-2^63 ~ 2^63-1	java : long
        
	[실수]
		float		: 4바이트		부동소수점(표현 범위 이상일 경우 오차 발생)	java : float
        double		: 8바이트		부동소수점(표현 범위 이상일 경우 오차 발생)	java : double
        decimal		: 문자타입		실수를 문자로 처리하는 타입(오차 없음)		java : Decimal클래스
        
	[날짜/시간]
		date		: 날짜표현			0000-00-00	(1000년 ~ 9999년)
        time		: 시간표현			00:00:00
        datetime	: 날짜/시간표현		0000-00-00 00:00:00
	
    [문자]
		char(문자길이)		: 문자열표현 고정길이 최대 255글자까지 표현, char(5)
							--> "유재석" --> [유] [재] [석] [ ] [ ]
        varchar(문자길이)	: 문자열표현 가변길이 최대 255글자까지 표현, varchar(5)
							--> "유재석" --> [유] [재] [석] 남은 길이는 제거
		text			: 문자열표현 고정길이 최대 6만글자까지 표현
        longtext		: 문자열표현 최대 42억개의 글자(4GB), 대용량
        
	[논리]
		bool	: true 또는 false표현, tinyint와 같다.
*/

# MySQL 데이터 타입 사용
# 다양한 데이터 타입을 이용한 테이블 생성 실습
# 주의할 점 : DB 사용 활성화된 상태에서 가능하다.
# 테이블이 생성되지 않는 경우 : DB를 활성화 하지 않은 경우, 이미 같은 이름의 테이블이 있는 경우, 틀린 부분이 있는 경우
create table testtable3(
	# 속성명 타입을 작성 여러개의 경우 쉼표로 구분(마지막은 쉼표를 넣지 않는다)
    정수필드1 tinyint, 정수필드2 smallint, 정수필드3 mediumint, 정수필드4 int, 정수필드5 bigint,
    실수필드1 float, 실수필드2 double,
	날짜필드 date, 시간필드 time, 날짜시간 datetime,
    문자필드1 char(100), 문자필드2 varchar(100), 문자필드3 text, 문자필드4 longtext,
    논리필드 bool
);
show tables;
# 특정한 테이블 조회
select * from testtable3;

# 실습1 : boardService9의 DB 설계를 하시오.
# 단계1 : DB Server에 DB 만들기
create database boardService9;
show databases;

# 단계2 : 지정한 DB의 테이블을 만들기 위해서 DB 활성화
use boardService9;
# DTO : Data Transfer Object (데이터 전송 객체)
# 단계3 : 지정한 DB에 테이블 생성하기 (DTO와 비슷하게 설계)
create table board(
	# 자바 : private String title;
    # 임의로 제목은 최대 100글자로 설계
	title varchar(100),
    # 자바 : private String content;
    # 임의로 내용은 긴글과 사진도 넣기위해 longtext로 설계
    content longtext,
    # 자바 : private String writer;
    # 임의로 작성자는 최대 30글자로 설계
    writer varchar(30)
);
# 생성된 테이블 확인
select * from board;

# 실습2 : day09패키지의 waitingService의 DB를 설계 하시오.
create database waitingService;
show databases;
use waitingservice;
create table waiting(
	phoneNumber varchar(15),
    headCount tinyint
);
show tables;
select * from waiting;

# 제약조건 : 테이블에서 데이터의 문제/결함이 되는 데이터가 입력되지 않도록 제약을 지정한 조건
use mydb1230;
create table testtable4(
	-- 지정한 필드에는 null을 대입할 수 없다.
	필드명1 tinyint not null,
    -- 지정한 필드에는 중복값을 대입할 수 없다.
    필드명2 smallint unique,
    -- 지정한 필드에는 레코드 삽입시 값을 생략하면 자동으로 기본값이 대입된다.
    필드명3 int default 10,
    -- 지정한 필드에는 레코드 삽입시 순서대로 자동번호가 대입된다.
    필드명4 bigint auto_increment,
    PK필드명5 double,
    -- 지정한 필드를 pk필드로 설정
    constraint primary key(PK필드명5)
);

create table testtable5(
	FK필드명1 double,
    -- 지정한 필드를 FK필드로 설정
    constraint  foreign key(FK필드명1) references testtable4(PK필드명5)
);

# 실습3 : boardService7에서 회원제 게시판 DB를 설계하시오.
# 회원테이블, 게시판테이블 --> 회원이 존재해야 게시물이 존재할 수 있다.
# 즉 회원이 상위 개념 회원(PK) 게시물(FK)

create database boardservice7;
use boardservice7;
# 회원 테이블
create table member(
	-- 회원번호는 자동으로 번호가 부여(auto_increment 제약조건 사용)
    -- 회원번호는 최대 20억 이상이 될 수 없을 것 같아서 int타입을 선택
	mno int auto_increment,
    -- 회원아이디는 공백이라는 아이디가 존재하면 안되기 때문에 not null 제약 조건 사용
    -- 회원아이디는 중복이 되면 안되기 때문에 unique 제약 조건 사용
    mid varchar(30) not null unique,
    -- 회원비밀번호는 공백을 차단하기 위해 not null 제약조건 사용
    mpw varchar(30) not null,
    -- 회원이름은 최대 10글짜까지 입력받기 위해 varchar(10)으로 선택
    -- 회원이름은 공백을 차단하기 위해 not null 제약조건 사용
    mname varchar(10) not null,
    -- 회원번호는 pk필드로 선정하면 not null과 unique 제약조건이 포함
    constraint primary key(mno)
);
select * from member;

# 게시판 테이블
create table board(
	-- 게시물번호는 자동으로 번호를 부여하기위해 auto_increment 제약조건을 사용
    -- 게시물번호가 20억 이상일 것 같아서 bigint타입으로 설계
	bno bigint auto_increment,
    -- 게시물제목은 공백을 없애기 위해 not null 제약조건을 사용
    -- 게시물제목은 최대 100글자까지 작성이 가능하도록 varchar(100)으로 설계
    btitle varchar(100) not null,
    -- 게시물내용은 공백을 허용하고 최대 4GB까지 대용량 입력이 가능하도록 설계
    bcontent longtext,
    -- 게시물작성일은 defalut 기본값에 now() 함수를 사용하면 자동으로 시스템 날짜/시간이 삽입
    bdate datetime default now(),
    -- 게시물조회수는 defalut 기본값을 0으로 설계
    bview int default 0,
    -- PK필드
    constraint primary key(bno),
    -- FK필드
    mno int,
    # board테이블의 mno필드가 member테이블의 mno필드를 참조한다.
    constraint foreign key(mno) references member(mno)
);
select * from board;