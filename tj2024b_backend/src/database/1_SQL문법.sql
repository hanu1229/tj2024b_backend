[]
	관계형 데이터베이스 : 자료들 간의 종속되는 관계(연관성)를 표현한 데이터베이스
	테이블 : 행과 열로 구성된 데이터의 집합
	
[SQL]
	*SQL 명령어는 대소문자를 구분하지 않는다.
	- Utility Command - 메타데이터 관리어
		1. SHOW
			1-1. SHOW DATABASES;	: DB Server의 전체데이터베이스 목록 조회
			1-2. SHOW VARIABLES;	: DB Server의 local path를 조회
			1-3. SHOW TABLES;		: DB의 전체테이블 목록 조회
		2. USE
			2-1. USE DB명; : DB Server의 지정한 DB 활성화(사용)
		
	- DDL : Data Definition Language - 데이터베이스 정의어
		1. CREATE
			1-1. CREATE DATABASE DB명; : DB Server에 DB명의 DB를 생성
		2. DROP
			2-1. DROP DATABASE DB명; 			: DB Server에 DB명의 DB를 제거
			2-2. DROP DATABASE IF EXISTS DB명;	: DB Server에 DB명이 존재하면 DB를 제거
		
	- DML : Data Manipulation Language - 데이터베이스 조작어
		1. INSERT
			1-1. 모든 속성에 값을 대입, 속성명 생략 가능
				- insert into 테이블명 values (값1, 값2, ...);
			1-2. 특정 속성에 값 대입, 속성명 작성
				- insert into 테이블명(속성값1, 속성값2, ...) values (값1, 값2, ...);
			1-3. 여러개의 레코드를 한번에 삽입할때
				- insert into 테이블명(속성명1, 속성명2, ...) values (값1, 값2, ...), (값1, 값2, ...), ...;
			※ 주의할점: 속성의 제약조건에 따라서 적절하게 값을 대입해야한다.
		2. SELECT
			2-1. 전체 속성의 레코드 조회
				- select * from 테이블명;
			2-2. 특정 속성의 레코드 조회
				- select 속성명 from 테이블명;
			2-3. 한번에 특정 속성의 레코드 조회
				- select 속성명1, 속성명2, ... from 테이블명;
			2-4. where 조건절을 이용한 레코드 조회 [조건절] where 조건;
				- select * from 테이블명 where 속성명 = 값;
				
		3. UPDATE
			3-1. 전체 레코드의 속성값 수정 (오류 : mySQL workbench에서 전체 수정을 막고 있음)
				- set SQL_SAFE_UPDATE = 0; --> save mode 꺼짐 1이면 켜짐
				- update 테이블명 set 속성명 = 새로운값;
			3-2. 특정 레코드의 속성값만 수정 [조건절] where 조건;
				- update 테이블명 set 속성명 = 새로운값 where 속성명 = 값;
			3-3. 여러 속성값을 수정 [조건절] where 조건;
				- update 테이블명 set 속성명1 = 새로운값, 속성명2 = 새로운값, ... where 속성명 = 값;
		
		4. DELETE
			4. delete from 테이블명 where 속성명 = 값;
			
	
	
	- DCL : Data Control Language - 데이터베이스 제어어
	
	- TCL : Transaction Control Language - 트랜잭션 제어어
	
[MySQL 데이터 타입]

	[정수]
		tinyint		: 1바이트		-2^7 ~ 2^7-1	java : byte
        smallint	: 2바이트		-2^15 ~ 2^15-1	java : short
        mediumint	: 3바이트		-2^23 ~ 2^23-1	java : 없음
        int			: 4바이트		-2^31 ~ 2^31-1	java : int
        bingint		: 8바이트		-2^63 ~ 2^63-1	java : long
        
	[실수]
		float		: 4바이트		부동소수점(표현 범위 이상일 경우 오차 발생)	java : float
        double		: 8바이트		부동소수점(표현 범위 이상일 경우 오차 발생)	java : double
        decimal		: 문자타입		실수를 문자로 처리하는 타입(오차 없음)	java : Decimal클래스
        
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
		
[제약조건] : 테이블에서 문제되는/결함이 되는 데이터가 입력되지 않도록 제약을 지정한 조건
	1. not null			: 해당 필드에 null값을 포함하지 않는다.
	2. unique			: 해당 필드에 중복값을 허용하지 않는다. (중복 데이터 차단)
	3. default 기본값		: 레코드(값) 삽입(추가)시 해당 필드에 값을 대입하지 않으면 
						  기본값으로 초기화 한다.
	   defalut now()	: 레코드 삽입시 현재 시스템의 날짜/시간을 초기화한다.
	   
	4. auto_increment	: (MySQL에서만 가능) 레코드 삽입 시 
						  자동으로 순서대로 번호(index)가 삽입된다.
						  
	5. primary key		: 기본키/식별키(PK) --> 식별 가능한 고유 값 필드 키 (학번/사번/주민등록번호 등등)
		- 기본키는 not null과 unique 조건이 포함되어있다.
		- constraint primary key(pk필드명)
	6. foreign key		: 참조키/외래키(FK) --> 다른 테이블의 PK를 참조하는 키
		- 참조키는 null과 중복 데이터를 가질 수 있다.
		- constraint foreign key(FK로 사용할 필드명) references 다른 테이블명(참조할 PK 필드명) on update/delete OOO
		- FK 제약조건 옵션
		    - on update/delete [옵션] : FK가 참조하는 PK가 삭제/수정에 따른 FK의 제약 옵션
		    - restrict(기본값)		 : FK가 PK를 참조 중이면 PK레코드를 삭제/수정 불가능
		    - cascade				 : PK레코드가 삭제/수정되면 FK가 같이 삭제/수정
		    - set null				 : PK값이 삭제/수정되면 FK는 참조를 없애고 null로 변경
	
	* 관계형 데이터베이스는 관례적으로 기본키(PK)는 테이블당 1개 이상을 갖는다.
	