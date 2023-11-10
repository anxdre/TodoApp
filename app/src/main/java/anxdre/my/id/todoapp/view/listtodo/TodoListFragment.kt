package anxdre.my.id.todoapp.view.listtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import anxdre.my.id.todoapp.R
import anxdre.my.id.todoapp.data.database.TodoDb
import anxdre.my.id.todoapp.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment(R.layout.fragment_todo_list) {
    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TodoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        viewModel = TodoListViewModel(
            TodoDb.getInstance(requireActivity().applicationContext)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TodoListAdapter{
            viewModel.deleteItem(it)
        }
        binding.rvMain.adapter = adapter

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.todo_to_create)
        }

        viewModel.listOfTodo.observe(viewLifecycleOwner) {
            adapter.changeDataset(it)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}