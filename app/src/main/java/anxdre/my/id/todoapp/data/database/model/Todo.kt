package anxdre.my.id.todoapp.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String?,
    val desc: String?,
    val priority: String = "low",
    var isDone: Boolean? = false
)