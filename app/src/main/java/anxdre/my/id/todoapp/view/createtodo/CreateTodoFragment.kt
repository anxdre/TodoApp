package anxdre.my.id.todoapp.view.createtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import anxdre.my.id.todoapp.R
import anxdre.my.id.todoapp.data.database.TodoDb
import anxdre.my.id.todoapp.data.database.model.Todo
import anxdre.my.id.todoapp.databinding.FragmentCreateTodoBinding

class CreateTodoFragment : Fragment(R.layout.fragment_create_todo) {
    private var _binding: FragmentCreateTodoBinding? = null;
    private val binding get() = _binding!!
    private val viewModel by lazy {
        CreateTodoViewModel(
            TodoDb.getInstance(requireActivity().applicationContext)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnAdd.setOnClickListener {
                viewModel.saveTodo(
                    Todo(
                        0,
                        this.etTitle.text.toString(),
                        this.etDesc.text.toString()
                    )
                )
                Toast.makeText(requireContext(), "success add to list", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}