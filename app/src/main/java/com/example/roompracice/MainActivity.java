package com.example.roompracice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    EditText editText;
    Button btAdd, btReset;
    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();
    RoomDB database;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        btAdd = findViewById(R.id.bt_add);
        btReset = findViewById(R.id.bt_reset);
        recyclerView = findViewById(R.id.recycler_view);

        // database 초기화
        database = RoomDB.getInstance(this);

        // DB에 dataList의 값 저장
        dataList = database.mainDao().getAll();

        // 리사이클러뷰에 레이아웃 붙이기
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 어댑터 초기화
        adapter = new MainAdapter(MainActivity.this, dataList);

        // 어댑터 set
        recyclerView.setAdapter(adapter);

        btAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // EditText에 입력된 내용을 가져온다
                String sText = editText.getText().toString().trim();
                // 상태 체크
                if (!sText.equals(""))
                {
                    // text가 비어있지 않으면 maindata를 초기화한다
                    MainData data = new MainData();
                    // maindata에 text를 set한다
                    data.setText(sText);
                    // DB에 text 저장
                    database.mainDao().insert(data);

                    // EditText 지우기
                    editText.setText("");

                    // 데이터가 삽입되면 알린다
                    dataList.clear();
                    dataList.addAll(database.mainDao().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btReset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // DB의 모든 데이터 삭제
                database.mainDao().reset(dataList);

                // 모든 데이터가 삭제되면 알린다
                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });
    }
}