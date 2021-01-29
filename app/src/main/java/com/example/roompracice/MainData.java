package com.example.roompracice;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

// Define table name
@Entity(tableName = "table_name")
public class MainData implements Serializable
{
    // id 컬럼 생성
    @PrimaryKey(autoGenerate = true)
    private int id;

    // text 컬럼 생성
    @ColumnInfo(name = "text")
    private String text;

    // 게터세터 생성

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
