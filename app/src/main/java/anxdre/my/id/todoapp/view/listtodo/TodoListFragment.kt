package anxdre.my.id.todoapp.view.listtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import anxdre.my.id.todoapp.R
import anxdre.my.id.todoapp.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment(R.layout.fragment_todo_list) {
    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!

    //TODO::Define sharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO::Attach adapter
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}