package com.fabian.Fyi;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.fabian.Fyi.adapter.Message;
import com.fabian.Fyi.adapter.MsgAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Message> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDate();
        MsgAdapter msgAdapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, messages);
        ListView listview = findViewById(R.id.list);
        listview.setAdapter(msgAdapter);
    }

    public void initDate(){
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("tag", "msg" + i, "detail", "2021-12-02 15:23:47");
            messages.add(msg);
        }
    }
}