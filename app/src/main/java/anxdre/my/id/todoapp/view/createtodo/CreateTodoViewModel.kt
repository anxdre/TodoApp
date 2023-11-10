package anxdre.my.id.todoapp.view.createtodo

import androidx.lifecycle.ViewModel
import anxdre.my.id.todoapp.data.database.TodoDb
import anxdre.my.id.todoapp.data.database.model.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateTodoViewModel(private val roomDb: TodoDb) : ViewModel() {

    fun saveTodo(data: Todo) {
        CoroutineScope(Dispatchers.IO).launch {
            roomDb.todoDao().insertAll(data)
        }
    }
}