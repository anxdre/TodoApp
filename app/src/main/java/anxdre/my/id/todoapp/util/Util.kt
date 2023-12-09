package anxdre.my.id.todoapp.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import anxdre.my.id.todoapp.data.database.TodoDb

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Todo ADD COLUMN isDone INTEGER DEFAULT 0 not null"
        )
// kolom "isDone" pada model saya menggunakan tipe boolean, dimana pada saat masuk ke database
// akan berubah menjadi integer 0 = false, 1 = true. seperti pada refrensi berikut https://stackoverflow.com/questions/51130777/does-room-database-support-boolean-variables-in-entity
    }
}

fun buildDb(context: Context): TodoDb {
    return Room.databaseBuilder(
        context,
        TodoDb::class.java, "todo.db"
    ).addMigrations(MIGRATION_1_2).fallbackToDestructiveMigrationOnDowngrade().build()
}
