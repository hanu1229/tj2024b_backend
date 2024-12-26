/* 여러줄 주석 */
# 한줄 주석
-- 한줄 주석
/*
	1. SQL 작성 방법
		1. SQL 문법을 작성한다.
        2. SQL 문장이 끝나면 ;을 사용한다.
    
    2. SQL 코드 실행 방법
		방법1 : 단위 실행
			1. 실행할 코드에 마우스커서를 두고 (번개I아이콘) 클릭
            2. 실행할 코드에 마우스커서를 두고 CTRL + ENTER
		방법2 : 현재 파일내 모든 코드 실행(위에서 아래로)
			1. CTRL + SHIFT + ENTER
            2. (번개아이콘) 클릭
            
	3. SQL 코드 실행 결과
		- 하단에 Result Grid 탭에서 확인이 가능합니다.
*/
# [1] DB Server내 모든 데이터베이스를 확인
show databases;

# [2] DB Server의 local path를 확인
show variables like 'datadir';
-- 'C:\ProgramData\MySQL\MySQL Server 8.0\Data\'

# [3] DB Server의 데이터베이스 생성하기
-- create(생성한다) database(데이터베이스) DB명;
create database mydb1226;

# [4] DB Server의 데이터베이스 삭제하기
-- drop(버리다) database(데이터베이스) DB명;
drop database mydb1226;

# [4-2] 만약에 데이터베이스가 존재하면 삭제하기
-- if(만약에) exists(존재하다) DB명;
drop database if exists mydb1226;

# [5] DB Server내 여러개 데이터베이스 중에 사용/활성화할 데이터베이스 선택
use mydb1226;

# 실습1 : 아래와 같이 순서대로 SQL코드를 작성하고 실행하시오.
-- 1. 'test1'이름의 데이터베이스가 존재하면 삭제하기 SQL 작성
drop database if exists test1;
-- 2. 'test1'이름의 데이터베이스 생성하기 SQL 작성
create database test1;
-- 3. 서버의 전체 데이터베이스 목록 확인 SQL 작성
show databases; 
-- 4. 로컬PC에 데이터베이스가 만들어졌는지 경로 확인 SQL 작성
show variables like 'datadir';
-- 5. 'test1'이름의 데이터베이스 사용 활성화 하기 SQL 작성
use test1;

# 참고 : 현재 작성한 코드 파일을 sql확장자 파일, ctrl+s