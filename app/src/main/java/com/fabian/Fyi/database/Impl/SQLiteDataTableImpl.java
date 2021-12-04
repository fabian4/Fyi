package com.fabian.Fyi.database.Impl;

import android.database.sqlite.SQLiteDatabase;

public interface SQLiteDataTableImpl {

    void onCreate(SQLiteDatabase db);

    void onUpgrade(SQLiteDatabase db);
}
