package com.fabian.Fyi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fabian.Fyi.database.Impl.SQLiteDataTableImpl;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper mDBH;
    /**
     * 数据库版本号
     */
    private static final int DATABASE_VERSION = 1;
    /**
     * 数据库名称
     */
    private static final String DATABASE_NAME = "fyi.db";

    /**
     * 定义一个事件监听回调，将创建表和更新数据库表的操作让子类实现
     */
    public SQLiteDataTableImpl dataTable;

    public void setOnSQLiteDataTable(SQLiteDataTableImpl dataTable){
        this.dataTable = dataTable;
    }
    /**
     * 初始化数据库信息
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, dbObj -> {
            // TODO Auto-generated method stub
        });
        // TODO Auto-generated constructor stub
    }

    /**
     * 使用单例模式，获取数据库唯一实例
     * @param context 应用程序上下文
     * @return mDatabaseOpenHelper 该对象用于获取SQLiteDatabase实例
     */
    public synchronized static DatabaseHelper getDatabaseHelper(Context context){
        if(mDBH == null){
            mDBH = new DatabaseHelper(context);
        }
        return mDBH;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建一系列的数据库表
        dataTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dataTable.onUpgrade(db);
        onCreate(db);
    }
}
