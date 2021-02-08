package com.example.roompracice;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

/* Room에선 직접 쿼리로 접근하는 대신 DAO(Data Access Object)를 써서 DB에 접근해야 한다
* DAO는 인터페이스 or 추상클래스로 구현돼야 한다. 기존 쿼리의 큰 문제는 컴파일 시 쿼리상의 오류를 발견하지 못하는 것이었는데
* Room DAO에선 작성된 쿼리의 오류를 컴파일 시에 발견해 미리 오류를 수정할 수 있다. 또한 Entity 자동완성을 지원해서 쿼리 작성 시 오탈자가 날 확률도 줄였다 */
@Dao
public interface MainDao
{
    // INSERT문
    // @Insert : 데이터를 입력할 때 사용, 단일 객체부터 배열 형태 데이터까지 입력 가능, 입력 시 옵션을 지정해 충돌나면 어떻게 대처할지도 설정 가능
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    // DELETE문
    // @Delete : 전달받은 인자의 PK값에 매칭되는 entity를 찾아 삭제한다
    @Delete
    void delete(MainData mainData);

    // 전체 삭제하는 DELETE문
    @Delete
    void reset(List<MainData> mainData);

    // UPDATE문
    // @Query : 주로 데이터 선택 시 사용, DAO 클래스에서 가장 핵심적인 부분, 데이터를 읽고 쓸 수 있게 한다
    // 컴파일 시 쿼리검사가 이뤄지기 때문에 런타임 오류를 최소화할 수 있다
    @Query("UPDATE table_name SET text = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    // 모든 데이터 불러오는 SELECT문
    @Query("SELECT * FROM table_name")
    List<MainData> getAll();
}
