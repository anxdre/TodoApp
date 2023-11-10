package anxdre.my.id.todoapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import anxdre.my.id.todoapp.data.database.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(todo: Todo)

    @Query("SELECT * FROM Todo")
    fun getAll(): Flow<List<Todo>>

    @Query("SELECT * FROM Todo WHERE id = :taskId")
    fun getById(taskId: Int) : Todo

    @Delete
    fun delete(todo: Todo)
}