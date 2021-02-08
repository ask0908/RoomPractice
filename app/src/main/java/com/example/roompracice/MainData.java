package com.example.roompracice;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

// Define table name
/* @Entity는 DB의 테이블 역할을 한다. 아래처럼 테이블명을 사용자가 정할 수 있다. 테이블명의 초기값은 클래스명이며 이 때 대소문자는 구별되지 않는다
* @PrimaryKey로 PK값을 지정할 수 있고 중복 시 오류가 발생한다. autoGenerate=true로 자동으로 Key 값을 생성할 수 있다
* @ColumnInfo로 컬럼명을 지정한다 */
@Entity(tableName = "table_name")
public class MainData implements Serializable
{
    // id 컬럼 생성
    // Room Entity는 반드시 1개 이상의 PK를 갖고 있어야 한다. 이 때 PK값은 별개의 필드값으로 만들고 autoGenerate=true로 설정하는 게 바람직하다
    // autoGenerate=true : 유니크한 id값을 자동으로 생성한다
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
