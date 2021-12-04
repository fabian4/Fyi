package com.fabian.Fyi.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fabian.Fyi.database.DataBaseManager;
import com.fabian.Fyi.database.domain.Message;

import java.util.ArrayList;

public class MessageDao extends DataBaseManager<Message> {

    //表的名称
    private static final String MESSAGE_TABLE_NAME = "message";
    private static final String MESSAGE_FIELD_ID = "id";
    private static final String MESSAGE_FIELD_TAG = "tag";
    private static final String MESSAGE_FIELD_MSG = "msg";
    private static final String MESSAGE_FIELD_DETAIL = "detail";
    private static final String MESSAGE_FIELD_DATETIME = "dateTime";
    //定义主键是否为空
    private static final int PRIMARY_KEY_IS_NULL = -1;

    public MessageDao(Context context) {
        super(context);
    }

    public void insert(Message message) {
        insert(createParams(message));
    }

    public ArrayList<Message> queryAll() {
        String sql = "select * from " + MESSAGE_TABLE_NAME;
        return query(sql);
    }


    /**
     * 创建参数集合
     * @param message
     * @return mValues
     */
    public ContentValues createParams(Message message) {
        ContentValues values = new ContentValues();
        if (message.getId() != PRIMARY_KEY_IS_NULL) {
            values.put(MESSAGE_FIELD_ID, message.getId());
        }
        values.put(MESSAGE_FIELD_TAG, message.getTag());
        values.put(MESSAGE_FIELD_MSG, message.getMsg());
        values.put(MESSAGE_FIELD_DETAIL, message.getDetail());
        values.put(MESSAGE_FIELD_DATETIME, message.getDateTime());
        return values;
    }

    /**
     * 实现回调方法，这里实现创建表的操作
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建表的SQL语句
        String DATABASE_CREATE_PERSON_TABLE = "CREATE TABLE "
                + MESSAGE_TABLE_NAME + " (" + "" + MESSAGE_FIELD_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + ""
                + MESSAGE_FIELD_TAG + " VARCHAR(20) NOT NULL," + ""
                + MESSAGE_FIELD_MSG + " VARCHAR(20) NOT NULL," + ""
                + MESSAGE_FIELD_DETAIL + " VARCHAR(20) NOT NULL," + ""
                + MESSAGE_FIELD_DATETIME + " VARCHAR(20) NOT NULL" + ")";
        // 执行创建表的操作
        db.execSQL(DATABASE_CREATE_PERSON_TABLE);
    }

    /**
     * 实现回调方法，这里执行删除表的操作
     */
    @Override
    public void onUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + MESSAGE_TABLE_NAME);
    }

    @Override
    public String getTableName() {
        return MESSAGE_TABLE_NAME;
    }

    @Override
    public String getPrimaryKeyID() {
        return MESSAGE_FIELD_ID;
    }

    @Override
    public Message getResultFromCursor(Cursor cursor) {
        return new Message(
                cursor.getInt(cursor.getColumnIndexOrThrow(MESSAGE_FIELD_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(MESSAGE_FIELD_TAG)),
                cursor.getString(cursor.getColumnIndexOrThrow(MESSAGE_FIELD_MSG)),
                cursor.getString(cursor.getColumnIndexOrThrow(MESSAGE_FIELD_DETAIL)),
                cursor.getString(cursor.getColumnIndexOrThrow(MESSAGE_FIELD_DATETIME))
        );
    }
}
