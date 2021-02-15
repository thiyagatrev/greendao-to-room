package com.example.greendaotoroom.roomdatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Message::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao

    init {


    }

    companion object {

        /**
         * This is just for singleton pattern
         */
        @JvmStatic
        var INSTANCE: AppDatabase? = null

        fun initDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Get PhraseRoomDatabase database instance
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "greedao-to-room")
                            .allowMainThreadQueries()
                            .addMigrations(MIGRATION_2_3)
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }

        fun getInstance(): AppDatabase {
            return INSTANCE!!
        }

        val MIGRATION_2_3: Migration = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Rename indices because of switch from Greendao to Android Room

                val SQLITE_DATABASE_ITEM_TABLE =
                    ("CREATE TABLE " + "MESSAGE_temp"+ "( "
                            + "_id" + " INTEGER PRIMARY KEY, "
                            + "MID" + " TEXT, "
                            + "MSG_TIME" + " TEXT,"
                            + "MSG_TYPE"+ " TEXT" + "); ")
                database.execSQL(SQLITE_DATABASE_ITEM_TABLE)
                val cursor = database.query("SELECT * FROM MESSAGE")
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        val values = ContentValues()
                        values.put("_id", Message().id)
                        values.put("MID", Message().mid)
                        values.put("MSG_TIME", Message().msgTime)
                        values.put("MSG_TYPE", Message().msgType)
                        // Inserting Row
                        // Inserting Row
                        database.insert("MESSAGE_temp", SQLiteDatabase.CONFLICT_REPLACE, values)
                    }
                    cursor.close()
                }

                database.execSQL("DROP TABLE MESSAGE")
                val SQLITE_DATABASE_ITEM_TABLE1 =
                    ("CREATE TABLE " + "MESSAGE_temp1"+ "( "
                            + "_id" + " INTEGER PRIMARY KEY, "
                            + "MID" + " TEXT, "
                            + "MSG_TIME" + " TEXT,"
                            + "MSG_TYPE"+ " TEXT" + "); ")
                database.execSQL(SQLITE_DATABASE_ITEM_TABLE1)
                database.execSQL("INSERT INTO MESSAGE_temp1 SELECT * FROM MESSAGE_temp;")
                database.execSQL("ALTER TABLE MESSAGE_temp RENAME TO MESSAGE")


            }
        }
    }
}
