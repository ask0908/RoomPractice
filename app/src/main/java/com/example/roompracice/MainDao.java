package com.example.roompracice;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao
{
    // INSERT문
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    // DELETE문
    @Delete
    void delete(MainData mainData);

    // 전체 삭제하는 DELETE문
    @Delete
    void reset(List<MainData> mainData);

    // UPDATE문
    @Query("UPDATE table_name SET text = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    // 모든 데이터 불러오는 SELECT문
    @Query("SELECT * FROM table_name")
    List<MainData> getAll();
}
