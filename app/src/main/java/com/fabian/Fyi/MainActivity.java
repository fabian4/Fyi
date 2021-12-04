package com.fabian.Fyi;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.fabian.Fyi.database.dao.MessageDao;
import com.fabian.Fyi.database.domain.Message;
import com.fabian.Fyi.adapter.MsgAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MessageDao messageDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataBase();

        MsgAdapter msgAdapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, messageDao.queryAll());
        ListView listview = findViewById(R.id.list);
        listview.setAdapter(msgAdapter);
    }

    public void initDataBase(){
        messageDao = new MessageDao(this);
        for (int i = 0; i < 10; i++) {
            messageDao.delete(i);
        }
    }

    public List<Message> initDate(){
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message(i, "tag", "msg" + i, "detail", "2021-12-02 15:23:47");
            messages.add(msg);
        }
        return messages;
    }
}