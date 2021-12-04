package com.fabian.Fyi.database.Impl;

import android.content.ContentValues;

import java.util.ArrayList;

public interface DatabaseManagerImpl {

    public boolean insert(ContentValues contentValues);

    public <T> ArrayList<T> query(String sql);

    public Object query(int id);

    public boolean update(ContentValues contentValues);

    public boolean delete(int id);

    public void execSQL(String sql);

    public void closeDB();
}
