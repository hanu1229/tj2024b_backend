drop database if exists example5_연산자;
create database example5_연산자;
use example5_연산자;

# 1. 회원테이블
drop table if exists member;
# 아이돌 그룹
create table member(
	# 식별키       최대 8자리            
    mid char(8) not null ,      
    # 그룹명      최대 10자리
    mname varchar(10) not null ,
    # 인원수      정수 +-21억정도
    mnumber int not null ,
    # 지역      최대 2자리
    maddr char(2) not null , 
    # 지역번호   최대 2자리 
    mphone1 char(3) ,
    # 전화번호    최대 8자리
    mphone2 char(8) ,
    # 평균키       정수 +-3만정도
    mheight smallint ,      
    # 데뷔일       yyyy-mm-dd 
	mdebut date ,      
    # 제약조건 
    constraint primary key ( mid )            
);

# 2. 구매테이블
drop table if exists buy;
create table buy(
	# 구매번호   정수    자동번호 부여 
	bnum int auto_increment ,
    # 구매자      FK 
    mid char(8),
    # 제품명      최대 6자리 
    bpname char(6) not null ,
    # 분류명       최대   4자리
    bgname char(4) ,
    # 가격       정수 
    bprice int not null ,
    # 구매수량   정수 
    bamount smallint not null ,  
    # 제약조건 
    constraint primary key(bnum) ,               
    constraint foreign key ( mid ) references member(mid)
);

# 샘플데이터 
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# DML : insert 삽입, select 조회, update 수정, delete 삭제
# [1] 모든 속성의 레코드 조회
#select * from 테이블명;
select * from member;
select * from buy;

# [2] 특정 속성의 레코드를 조회
# select 속성명, 속성명 from 테이블명;
select mid from member;
select mid, mname from member;

# [3] 속성명과 테이블명에 별칭 / 별칭 : 조회 결과의 속성명을 변경(원본은 그래도)
# 다중테이블 조회시 속성명이 중복되는 경우가 있기 때문에 사용 또는 간소화하기 위해 사용
# 속성명 as  / 주의할점 : as 생략 가능(속성명은 띄어쓰기로 작성할 수 없다)
# 조회 결과를 mid 속성명을 회원아이디로 변경
select mid as 회원아이디 from member;
select mid as 회원아이디, mname as 회원명 from member;
select mid 회원아이디, mname 회원명 from member;
# 테이블에 as를 사용하는 이유는 테이별이름을 간소화 할 수 있다.
select mid 회원아이디, mname 회원명 from member as m;
select mid 회원아이디, mname 회원명 from member m;

# [4] 속성값이 중복인 레코드 제거
# distinct 속성명 : 중복된 레코드를 제거
select maddr from member;
select distinct maddr from member;

# [5] 속성값에 산술연산
# 산술연산자 : +(덧셈), -(뺄셈), *(곱셈), /(나눗셈), div(몫), mod(나머지)
select mnumber from member;
select mnumber, mnumber + 3 as 덧셈, mnumber - 3 as 뺄셈, mnumber * 3 as 곱셈, mnumber / 3 as 나눗셈, 
mnumber div 3 as 몫, mnumber mod 3 as 나머지 from member;

# [6] 조건절 where
# 비교연산자 : 속성명 = 값, 속성명 != 값
# 논리연산자 : not 조건, 조건1 and 조건2, 조건1 or 조건2
# 기타연산자 : 속성명 between 시작값 and 끝값, 속성명 in(값1, 값2, 값3),
# 기타연산자 : 속성명 is null, 속성명 is not null
# 문자열패턴 : 속성명 like "문자패턴"
#			% : 모든 문자를 대응, 문자의 개수는 상관없다.
#			_ : _의 개수만큼 문자를 대응한다.

# mname 속성값이 "블랙핑크"인 레코드를 조회
select * from member where mname = "블랙핑크";
# mnumber 속성값이 4인 레코드를 조회
select * from member where mnumber = 4;
# mname 속성값이 "블랙핑크"가 아닌 레코드를 조회
select * from member where mname != "블랙핑크";
# mname 속성값이 "블랙핑크"가 아닌 레코드를 조회
select * from member where not mname = "블랙핑크";
# mheight 속성값이 162이하인 레코드를 조회
select * from member where mheight <= 162;
# mheight 속성값이 165이상이면서 170이하인 레코드를 조회
select * from member where mheight >= 165 and mheight <= 170;
# mheight 속성값이 165 ~ 170사이인 레코드를 조회
select * from member where mheight between 165 and 170;
# maddr 속성값이 "경기"이거나 "전남" 이거나 "경남"인 레코드를 조회
select * from member where maddr = "경기" or maddr = "전남" or maddr = "경남";
select * from member where maddr in("경기", "전남", "경남");
# mphone1 속성값이 " "인 레코드를 조회
select * from member where mphone1 = " ";
# 속성값이 null일때는 = 불가능
select * from member where mphone1 = null;
# mphone1 속성값이 null인 레코드를 조회
select * from member where mphone1 is null;
# mphone1 속성값이 null이 아닌 레코드를 조회
select * from member where mphone1 is not null;
# mname 속성값이 "에이"로 시작하는 레코드를 조회
select * from member where mname like "에이%";
# mname 속성값이 "에이"로 시작하는 세글자인 레코드를 조회
select * from member where mname like "에이_";
# mname 속성값이 "핑크"로 끝나는 레코드 조회
select * from member where mname like "%핑크";
# mname 속성값에 "이"가 포함된 레코드를 조회
select * from member where mname like "%이%";
# mname 속성값에 "이"가 두번째 글자에 존재하고 총 글자 수가 세글자인 레코드를 조회
select * from member where mname like "_이_";

# [7] 정렬, 조회 결과의 레코드를 특정한 필드 기준으로 정렬
# order by 속성명 asc		: 지정한 속성명 기준으로 속성값들을 오름차순 정렬(작은값 -> 큰값, 과거날짜 -> 최신날짜, ABC, ㄱㄴㄷ)
# order by 속성명 desc	: 지정한 속성명 기준으로 속성값들을 내림차순 정렬(큰값 -> 작은값, 최신날짜 -> 과거날짜, CBA, ㄷㄴㄱ)
# order by 속성명1 정렬기준, 속성명2 정렬기준 : 지정한 속성명의 정렬이 2개 이상일때 쉼표로 구분하기, 2차 정렬은 1차정렬내 동일
# mdebut 속성값을 오름차순으로 정렬하여 출력
select * from member order by mdebut asc;
# mdebut 속성값을 내림차순으로 정렬하여 출력
select * from member order by mdebut desc;
# mname 속성값을 오름차순으로 정렬하여 출력(asc는 생략가능)
select * from member order by mname;
# 먼저 maddr 속성값을 정렬 후 동일한 속성값이 존재하는 경우 동일한 속성값 끼리 mdebut 정렬한다.
select * from member order by maddr desc, mdebut asc;

# [8] 제한, 조회 결과의 레코드 수 제한
# limit 레코드수
# limit 시작레코드(0~), 개수
# 조회 결과의 레코드에서 상위 2개만 조회를 제한
select * from member limit 2;
# 조회 결과의 레코드에서 0(첫번째)레코드부터 2개만 조회를 제한
select * from member limit 0, 2;
# 조회 결과의 레코드에서 2(세번째)레코드부터 3개만 조회를 제한
select * from member limit 2, 3;
# mheight가 상위 3개만 조회를 제한
select * from member order by mheight desc limit 3;

# 실습1 : 주소가 "서울"인 레코드를 데뷔일 기준으로 내림차순으로 조회 결과에 상위 2개만 조회하시오.
select * from member where maddr = "서울" order by mdebut desc limit 0, 2;
select * from member where maddr = "서울";

# [9] 그룹
# group by 그룹속성명 having 그룹조건
# 주의할점 : 두개 이상의 속성명을 사용할 경우 그룹대상의 속성명이 동일하더라도 다른 속성명의 속성값이 다를 수 있다.
select * from buy;
# buy테이블의 bpname속성명 값을 그룹으로 묶음(중복값이 없다)
select bpname from buy group by bpname;
# 오류 발생 : bpname이 동일하더라도 bprice가 다를 수 있기 때문이다.
select bpname, bprice from buy group by bpname;

/*
	학년 	점수		1학년의 총 점수합계
     1		30
     2		20
     1		40
*/

# [10] 집계/통계 함수 + 그룹
select bamount from buy;
# bamount 속성명의 값들의 총 합계를 조회
select sum(bamount) from buy;
# bamount 속성명의 값들의 평균을 조회
select avg(bamount) from buy;
# bamount 속성명의 값들의 최소값을 조회
select min(bamount) from buy;
# bamount 속성명의 값들의 최대값을 조회
select max(bamount) from buy;
# bamount 속성명의 값들의 개수를 조회(레코드 수를 조회) ※ null 제외
select count(bamount) from buy;
# buy테이블의 속성명의 레코드(행)의 개수 ※ null 포함
select count(*) from buy;
# 1. 회원아이디별 구매수량 총합계를 조회
# mid 속성명의 값으로 그룹하고 bamount 속성명으로 집계한 레코드를 조회
select mid, sum(bamount) from buy group by mid;
# 2. 회원아이디 별 총구매금액 총합계 조회
select mid, sum(bamount * bprice) from buy group by mid;
# 3. 회원아이디 별 구매금액 평균 조회
select mid, avg(bprice) from buy group by mid;
# 4. 총 구매횟수(판매횟수) 조회
select count(*) from buy;
# 5. 회원아이디별 구매횟수 조회
select mid, count(bpname) from buy group by mid;

# [11] having 그룹후조건(별칭사용가능) vs where 그룹전조건(별칭사용불가능)
# 주의할점 : select문에서 컴퓨터가 처리하는 순서 : select [3] from [1] where [2] group by [4] having [5]
select * from buy;
# 1. 회원아이디별 구매수량(bamount)이 3초과인 레코드를 조회
select mid, bamount from buy where bamount > 3;
# 2. 회원아이디별 총 구매금액(bamount * bprice)이 1000초과인 레코드를 조회
select mid, sum(bamount * bprice) from buy group by mid having sum(bamount * bprice) > 1000;
select mid, sum(bamount * bprice) as 총구매금액 from buy group by mid having 총구매금액 > 1000;
# 오류 발생
select mid, sum(bamount * bprice) as 총구매금액 from buy where 총구매금액 > 1000;
# 오류 발생 : where는 별칭으로 조건속성명이 불가능
select mid, bprice as 구매가격 from buy where 구매가격 > 1000;
# 오류 발생 : 집계 후 조건은 where에서 불가능
select mid, sum(bamount * bprice) as 총구매금액 from buy where 총구매금액 > 1000;

# 실습2 : 구매수량(bamount)이 2개 초과인 레코드에서 회원아이디별 구매가격(bprice)평균이 50이상인 레코드 조회
#		+ 구매가격 평균으로 내림차순, 상위 2개만 조회
select * from buy where bamount > 2 group by mid having avg(bprice) > 50;
select mid, ave(bprice) from buy group by mid having avg(bprice) > 50;
-- 정답 --
# 1. buy 테이블에서 구매수량(bamount)가 2개 초과인 레코드
select * from buy where bamount > 2;
# 2. 회원아이디(mid)별 구매가격(bprice)평균 ※ ~~별 집계(합계/평균/개수)
select mid as 회원아이디, avg(bprice) as 구매가격평균 
	from buy 
	where bamount > 2 
	group by 회원아이디;
# 3. 구매가격(bprice)평균이 50이상, 구매가격평균은 집계인지 아닌지 판단. 집계이면 having 아니면 where
select mid as 회원아이디, avg(bprice) as 구매가격평균 
	from buy 
	where bamount > 2 
	group by 회원아이디
	having 구매가격평균 >= 50;
# 4. 구매가격평균 내림차순 조회
select mid as 회원아이디, avg(bprice) as 구매가격평균 
	from buy 
	where bamount > 2 
	group by 회원아이디
	having 구매가격평균 >= 50
	order by 구매가격평균 desc;
# 5. 구매가격평균 상위 2개만 / 최종
select mid as 회원아이디, avg(bprice) as 구매가격평균 
	from buy 
	where bamount > 2 
	group by 회원아이디
	having 구매가격평균 >= 50
	order by 구매가격평균 desc
    limit 0, 2;
    
    # * select 사용시 여러 절이 있을때 작성순서
    /*select 속성명 from 테이블명 
		where 조건절 
		group by 그룹속성명 having 그룹조건 
		order by 정렬속성명 정렬기준 
		limit 시작번호, 개수;
    */
    /*
		select를 컴퓨터가 처리하는 순서
        select [3] from [1] where [2] group by [4] having [5] order by [6] limit[7];
    */