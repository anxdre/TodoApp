package anxdre.my.id.todoapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import anxdre.my.id.todoapp.data.database.dao.TodoDao
import anxdre.my.id.todoapp.data.database.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDb : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        private const val Database_NAME = "todo.db"

        /**
         * As we need only one instance of db in our app will use to store
         * This is to avoid memory leaks in android when there exist multiple instances of db
         */
        @Volatile
        private var INSTANCE: TodoDb? = null

        fun getInstance(context: Context): TodoDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoDb::class.java,
                        Database_NAME
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}