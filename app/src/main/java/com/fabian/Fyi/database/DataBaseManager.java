package com.fabian.Fyi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.fabian.Fyi.database.Impl.DatabaseManagerImpl;
import com.fabian.Fyi.database.Impl.SQLiteDataTableImpl;

import java.util.ArrayList;

public abstract class DataBaseManager<T> implements SQLiteDataTableImpl, DatabaseManagerImpl {

    private static final String TAG = "sqlite_log";
    private final SQLiteDatabase db;

    public DataBaseManager(Context context) {
        DatabaseHelper dbh = DatabaseHelper.getDatabaseHelper(context);
        //设置事件监听
        dbh.setOnSQLiteDataTable(this);
        //获取SQLiteDatabase对象，创建或打开数据库
        db = dbh.getWritableDatabase();
    }

    /**
     * 插入数据操作
     *
     * @param contentValues 插入的数据集合
     * @return boolean 布尔值，true为插入成功，false插入失败
     */
    @Override
    public boolean insert(ContentValues contentValues) {
        db.beginTransaction();
        try {
            long rowId = db.insertOrThrow(getTableName(), null, contentValues);
            db.setTransactionSuccessful();
            return rowId != -1;
        } catch (Exception e) {
            Log.e(TAG, "The insert operation failed");
        } finally {
            db.endTransaction();
        }
        return false;
    }

    /**
     * 更新数据操作
     *
     * @param contentValues 需要更新的数据集合
     * @return boolean 布尔值，true为更新成功，false更新失败
     */
    @Override
    public boolean update(ContentValues contentValues) {
        db.beginTransaction();
        try {
            int rows = db.update(getTableName(), contentValues, getPrimaryKeyID() + "= ?",
                    new String[]{String.valueOf(contentValues.get(getPrimaryKeyID()))});
            db.setTransactionSuccessful();
            return rows > 0;
        } catch (Exception e) {
            Log.e(TAG, "The update operation failed");
        } finally {
            db.endTransaction();
        }
        return false;
    }

    /**
     * 删除数据操作
     *
     * @param id 需要更删除的数据选项ID
     * @return boolean 布尔值，true为删除成功，false删除失败
     */
    @Override
    public boolean delete(int id) {
        db.beginTransaction();
        try {
            int rows = db.delete(getTableName(), getPrimaryKeyID() + "= ?", new String[]{String.valueOf(id)});
            db.setTransactionSuccessful();
            return rows > 0;
        } catch (Exception e) {
            Log.e(TAG, "The delete operation failed");
        } finally {
            db.endTransaction();
        }
        return false;
    }

    /**
     * 使用标准SQL语句查询数据列表
     *
     * @param sql 标准SQL语句
     * @return mList 查询后的数据列表
     */
    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<T> query(String sql) {

        ArrayList<T> list = new ArrayList<T>();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            T obj = getResultFromCursor(cursor);
            list.add(obj);
        }
        return list;
    }

    /**
     * 根据ID查询数据
     *
     * @param id 需要查询的数据ID
     * @return T 查询后获取到的对象
     */
    @Override
    public T query(int id) {
        Cursor cursor = db.query(getTableName(), null, getPrimaryKeyID() + "=?", new String[]{String.valueOf(id)}, null, null, null);
        return getResultFromCursor(cursor);
    }

    /**
     * 执行一些较为复杂的CRUD操作
     */
    @Override
    public void execSQL(String sql) {
    }

    /**
     * 执行对数据库中数据的操作后关闭数据库
     */
    @Override
    public void closeDB() {
        db.close();
    }

    /**
     * 从子类获取表名
     *
     * @return String 表的名称
     */
    public abstract String getTableName();

    /**
     * 获取表的主键名称
     *
     * @return String 主键名
     */
    public abstract String getPrimaryKeyID();

    /**
     * 使用Cursor转换对象
     *
     * @param cursor 需要转换的Cursor对象
     * @return T 创建的对象
     */
    public abstract T getResultFromCursor(Cursor cursor);
}
