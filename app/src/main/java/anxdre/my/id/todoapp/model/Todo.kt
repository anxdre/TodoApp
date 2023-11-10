package anxdre.my.id.todoapp.model

data class Todo(
    val id: Int = 0,
    val title: String?,
    val desc: String?,
    val isDone: Boolean? = false
)