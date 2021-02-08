# RoomPractice
 공부용 룸 DB 예제

**@Entity
---
@Entity는 DB의 테이블 역할을 한다. 아래처럼 테이블명을 사용자가 정할 수 있다. 테이블명의 초기값은 클래스명이며 이 때 대소문자는 구별되지 않는다

**@PrimaryKey
---
@PrimaryKey로 PK값을 지정할 수 있고 중복 시 오류가 발생한다. autoGenerate=true로 자동으로 Key 값을 생성할 수 있다

**@ColumnInfo
---
@ColumnInfo로 컬럼명을 지정한다
