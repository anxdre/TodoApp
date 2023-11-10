package anxdre.my.id.todoapp.view.listtodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import anxdre.my.id.todoapp.databinding.ItemTodoBinding
import anxdre.my.id.todoapp.model.Todo

class TodoListAdapter(private val onCheck: (Todo) -> Unit) :
    RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>() {
    private val dataset = mutableListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        return TodoListViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.createView(position)
    }

    fun changeDataset(list: List<Todo>) {
        dataset.clear()
        dataset.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataset.size

    inner class TodoListViewHolder(private val itemBinding: ItemTodoBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun createView(position: Int) {
            itemBinding.tvTitle.text = dataset[position].title
            itemBinding.tvTitle.setOnCheckedChangeListener { _, _ ->
                onCheck(dataset[position])
            }
        }
    }
}