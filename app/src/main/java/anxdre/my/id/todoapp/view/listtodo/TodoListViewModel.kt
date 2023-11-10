package anxdre.my.id.todoapp.view.listtodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import anxdre.my.id.todoapp.data.database.TodoDb
import anxdre.my.id.todoapp.data.database.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoListViewModel(private val roomDb: TodoDb) : ViewModel() {
    val _listOfTodo = MutableLiveData<List<Todo>>()
    val listOfTodo:LiveData<List<Todo>> get() = _listOfTodo

    init {
        viewModelScope.launch { getListFromPipe() }
    }

    private suspend fun getListFromPipe() {
        roomDb.todoDao().getAll().collect {
            _listOfTodo.postValue(it)
        }
    }

    fun deleteItem(data:Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            roomDb.todoDao().delete(data)
        }
    }
}