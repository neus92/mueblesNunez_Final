package com.example.mueblesnunez.dataBase;
// biblioteca trae metodos para hacer delete, insert, etc
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
// permite crear contructor para definir la BD
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQliteOpenHelper extends SQLiteOpenHelper{
    //COntrucor para instanciar mi database...
    public AdminSQliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Permite definir mi modelo (crear tablas y campos)
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE agenda(codigo int primary key, nombre text, fecha text, direccion text)");
    }
    // permite realizar cambios esquematicos en mi database...
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
