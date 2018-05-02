package com.delaroystudios.quiz.database;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import android.support.annotation.NonNull;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QuestionsDao_Impl implements QuestionsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfQuestions;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public QuestionsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuestions = new EntityInsertionAdapter<Questions>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `questions_table`(`id`,`question`,`answer`,`optA`,`optB`,`optC`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Questions value) {
        stmt.bindLong(1, value.getId());
        if (value.getQuestion() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getQuestion());
        }
        if (value.getAnswer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAnswer());
        }
        if (value.getOptA() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOptA());
        }
        if (value.getOptB() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOptB());
        }
        if (value.getOptC() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOptC());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM questions_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(Questions questions) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfQuestions.insert(questions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Questions>> getAllQuestions() {
    final String _sql = "SELECT * from questions_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Questions>>() {
      private Observer _observer;

      @Override
      protected List<Questions> compute() {
        if (_observer == null) {
          _observer = new Observer("questions_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfQuestion = _cursor.getColumnIndexOrThrow("question");
          final int _cursorIndexOfAnswer = _cursor.getColumnIndexOrThrow("answer");
          final int _cursorIndexOfOptA = _cursor.getColumnIndexOrThrow("optA");
          final int _cursorIndexOfOptB = _cursor.getColumnIndexOrThrow("optB");
          final int _cursorIndexOfOptC = _cursor.getColumnIndexOrThrow("optC");
          final List<Questions> _result = new ArrayList<Questions>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Questions _item;
            _item = new Questions();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpQuestion;
            _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
            _item.setQuestion(_tmpQuestion);
            final String _tmpAnswer;
            _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
            _item.setAnswer(_tmpAnswer);
            final String _tmpOptA;
            _tmpOptA = _cursor.getString(_cursorIndexOfOptA);
            _item.setOptA(_tmpOptA);
            final String _tmpOptB;
            _tmpOptB = _cursor.getString(_cursorIndexOfOptB);
            _item.setOptB(_tmpOptB);
            final String _tmpOptC;
            _tmpOptC = _cursor.getString(_cursorIndexOfOptC);
            _item.setOptC(_tmpOptC);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
