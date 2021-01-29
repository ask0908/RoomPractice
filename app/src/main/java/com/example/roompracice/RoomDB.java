package com.example.roompracice;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// Add database entities
@Database(entities = {MainData.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase   // 이 클래스는 추상 클래스로 만들어져야 함
{
    // 데이터베이스 객체 생성
    private static RoomDB database;

    // DB 이름 정의
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context)
    {
        // 상태 체크
        if (database == null)
        {
            // database가 null이면 database를 초기화한다
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        // return database
        return database;
    }

    // DAO 생성
    // 추상클래스 안에 있기 때문에 내부 메서드도 추상 메서드로 만들어야 함
    public abstract MainDao mainDao();

}
