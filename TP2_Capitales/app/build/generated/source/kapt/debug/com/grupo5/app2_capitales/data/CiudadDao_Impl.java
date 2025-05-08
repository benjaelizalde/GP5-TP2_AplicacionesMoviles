package com.grupo5.app2_capitales.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CiudadDao_Impl implements CiudadDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Ciudad> __insertionAdapterOfCiudad;

  private final SharedSQLiteStatement __preparedStmtOfBorrarPorNombre;

  private final SharedSQLiteStatement __preparedStmtOfBorrarPorPais;

  private final SharedSQLiteStatement __preparedStmtOfActualizarPoblacion;

  public CiudadDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCiudad = new EntityInsertionAdapter<Ciudad>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `ciudades` (`nombreCiudad`,`nombrePais`,`poblacion`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Ciudad entity) {
        if (entity.getNombreCiudad() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getNombreCiudad());
        }
        if (entity.getNombrePais() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombrePais());
        }
        statement.bindLong(3, entity.getPoblacion());
      }
    };
    this.__preparedStmtOfBorrarPorNombre = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM ciudades WHERE nombreCiudad = ?";
        return _query;
      }
    };
    this.__preparedStmtOfBorrarPorPais = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM ciudades WHERE nombrePais = ?";
        return _query;
      }
    };
    this.__preparedStmtOfActualizarPoblacion = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE ciudades SET poblacion = ? WHERE nombreCiudad = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertar(final Ciudad ciudad, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCiudad.insert(ciudad);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object borrarPorNombre(final String nombre, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfBorrarPorNombre.acquire();
        int _argIndex = 1;
        if (nombre == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, nombre);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfBorrarPorNombre.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object borrarPorPais(final String pais, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfBorrarPorPais.acquire();
        int _argIndex = 1;
        if (pais == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, pais);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfBorrarPorPais.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object actualizarPoblacion(final String nombre, final int nuevaPoblacion,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfActualizarPoblacion.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, nuevaPoblacion);
        _argIndex = 2;
        if (nombre == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, nombre);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfActualizarPoblacion.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object obtenerPorNombre(final String nombre,
      final Continuation<? super Ciudad> $completion) {
    final String _sql = "SELECT * FROM ciudades WHERE nombreCiudad = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nombre == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nombre);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Ciudad>() {
      @Override
      @Nullable
      public Ciudad call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNombreCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCiudad");
          final int _cursorIndexOfNombrePais = CursorUtil.getColumnIndexOrThrow(_cursor, "nombrePais");
          final int _cursorIndexOfPoblacion = CursorUtil.getColumnIndexOrThrow(_cursor, "poblacion");
          final Ciudad _result;
          if (_cursor.moveToFirst()) {
            final String _tmpNombreCiudad;
            if (_cursor.isNull(_cursorIndexOfNombreCiudad)) {
              _tmpNombreCiudad = null;
            } else {
              _tmpNombreCiudad = _cursor.getString(_cursorIndexOfNombreCiudad);
            }
            final String _tmpNombrePais;
            if (_cursor.isNull(_cursorIndexOfNombrePais)) {
              _tmpNombrePais = null;
            } else {
              _tmpNombrePais = _cursor.getString(_cursorIndexOfNombrePais);
            }
            final int _tmpPoblacion;
            _tmpPoblacion = _cursor.getInt(_cursorIndexOfPoblacion);
            _result = new Ciudad(_tmpNombreCiudad,_tmpNombrePais,_tmpPoblacion);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
