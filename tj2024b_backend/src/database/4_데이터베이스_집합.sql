# 1. 데이터베이스 준비
drop database if exists example6_집합;
create database example6_집합;
use example6_집합;

# 2. 테이블
create table table1 (
	num_pk int,
	constraint primary key(num_pk)
);

create table table2 (
	no_pk int,
    num_pk int,
    constraint primary key(no_pk),
    constraint foreign key(num_pk) references table1(num_pk)
);

# 3. 레코드 삽입
-- 하나의 insert에 5개의 레코드를 삽입
insert into table1 values (1), (2), (3), (4), (5);
insert into table2 values (1,1), (2,2), (3,1), (4,1), (5,2);

# 4. 레코드 조회
select * from table1;
select * from table2;

# PK(기본키/식별키) 필드/속성 : 고유한 값들을 가진 필드			, not null  unique 제한조건을 가짐
# Ex) 주민등록번호, 사번, 학번, 제품번호, 주문번호
# FL(외래키/참조키) 필드/속성 : 다른 테이블의 속성값을 참조하는 필드	, 중복, null 허용
# Ex) PK속성값을 참조하는 속성값

# 5. 집합
select * from table1; -- 5개의 레코드 조회
# 2개 이상의 테이블 조회 : select * from 테이블명A, 테이블명B;
# 행 * 행으로 결과값 출력
select * from table1, table2; -- 25개의 레코드 조회

# 교집합 : 두 테이블간의 공통으로 포함하는 속성값으로 이루어진 테이블 조회
# [1] where을 이용한 교집합 표현하기, 두 테이블의 공통 속성값 num_pk와 num_fk, 주로 pk속성 - fk속성으로 이어진다.
# where을 사용한 집한은 일반 조건과 겹치므로 구분이 어렵다.
select * from table1, table2 where table1.num_pk = table2.num_pk;
# where 일반조건, on 집합조건, having 그룹조건
# [2] inner join ~ on절을 이용하여 교집합을 표현하기, 가독성을 위해 where 대신 사용
# select * from 테이블명A inner join 테이블명B on 집합조건(주로 pk속성명 = fk속성명);
select * from table1 inner join table2 on table1.num_pk = table2.num_pk;
# [3] inner는 기본값이기 때문에 생략가능 그러나 가독성을 위해 inner 작성
select * from table1 join table2 on table1.num_pk = table2.num_pk;
# [4] using 키워드 : 전제조건은 pk속성명과 fk속성명이 같아야한다.
select * from table1 join table2 using(num_pk);
# [5] natural join 키워드 : 두 테이블간의 동일한 속성명 기준으로 자동으로 조인한다.
select * from table1 natural join table2;

# outer join
# select * from 테이블명A left outer join 테이블명B on 테이블명A.num_pk = 테이블명B.num_pk;
# [6] 왼쪽테이블(테이블명A)에 있는 모든 레코드를 포함하고 오른쪽테이블(테이블명B)에 교집합되는 레코드를 조회, 없으면 null
select * from table1 left outer join table2 on table1.num_pk = table2.num_pk;
# [7] 오른쪽테이블(테이블명B)에 있는 모든 레코드를 포함하고 왼쪽테이블(테이블명A)에 교집합되는 레코드를 조회, 없으면 null
select * from table1 right outer join table2 on table1.num_pk = table2.num_pk;
# [8] outer 키워드 생략 가능
select * from table1 left join table2 on table1.num_pk = table2.num_pk;

# 합집합 : 두 테이블간의 모든 레코드를 조회, 두 집합의 모든 요소를 갖는 집합
# union 키워드 : 2개 이상의 select를 하나로 합치는 키워드
select * from table1 left join table2 on table1.num_pk = table2.num_pk union
select * from table1 right join table2 on table1.num_pk = table2.num_pk;
# 오라클DB : FULL OUTER JOIN 키워드를 이용한 집합, MYSQL : UNION 키워드를 이용한 합집합

# 차집합 : 두 집합에서 A에는 속하지만 B에는 속하지 않는 원소집합, 두 테이블에서 특정테이블 속하지만 다른 테이블에 속하지 않는 레코드 조회
select * from table1 left outer join table2 on table1.num_pk = table2.num_pk where table2.num_pk is null;
# * 대신 table1.*을 하면 table1의 레코드값만 가져온다.
# *속성명 is null : 속성값이 null인지 비교연산, 속성명 is not null : 속성값이 null이 아닌지 비교연산
