package com.delaroystudios.quiz.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class QuestionsRoomDatabase_Impl extends QuestionsRoomDatabase {
  private volatile QuestionsDao _questionsDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `questions_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `question` TEXT NOT NULL, `answer` TEXT, `optA` TEXT, `optB` TEXT, `optC` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"3563dc0cd941299f21e0139ba2ff1c2f\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `questions_table`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsQuestionsTable = new HashMap<String, TableInfo.Column>(6);
        _columnsQuestionsTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsQuestionsTable.put("question", new TableInfo.Column("question", "TEXT", true, 0));
        _columnsQuestionsTable.put("answer", new TableInfo.Column("answer", "TEXT", false, 0));
        _columnsQuestionsTable.put("optA", new TableInfo.Column("optA", "TEXT", false, 0));
        _columnsQuestionsTable.put("optB", new TableInfo.Column("optB", "TEXT", false, 0));
        _columnsQuestionsTable.put("optC", new TableInfo.Column("optC", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuestionsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuestionsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuestionsTable = new TableInfo("questions_table", _columnsQuestionsTable, _foreignKeysQuestionsTable, _indicesQuestionsTable);
        final TableInfo _existingQuestionsTable = TableInfo.read(_db, "questions_table");
        if (! _infoQuestionsTable.equals(_existingQuestionsTable)) {
          throw new IllegalStateException("Migration didn't properly handle questions_table(com.delaroystudios.quiz.database.Questions).\n"
                  + " Expected:\n" + _infoQuestionsTable + "\n"
                  + " Found:\n" + _existingQuestionsTable);
        }
      }
    }, "3563dc0cd941299f21e0139ba2ff1c2f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "questions_table");
  }

  @Override
  public QuestionsDao wordDao() {
    if (_questionsDao != null) {
      return _questionsDao;
    } else {
      synchronized(this) {
        if(_questionsDao == null) {
          _questionsDao = new QuestionsDao_Impl(this);
        }
        return _questionsDao;
      }
    }
  }
}
