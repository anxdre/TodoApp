package anxdre.my.id.todoapp.view.createtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import anxdre.my.id.todoapp.R
import anxdre.my.id.todoapp.data.database.TodoDb
import anxdre.my.id.todoapp.data.database.model.Todo
import anxdre.my.id.todoapp.databinding.FragmentCreateTodoBinding
import anxdre.my.id.todoapp.util.buildDb

class CreateTodoFragment : Fragment(R.layout.fragment_create_todo),OnCheckedChangeListener {
    private var _binding: FragmentCreateTodoBinding? = null;
    private val binding get() = _binding!!
    private val viewModel by lazy {
        CreateTodoViewModel(
            buildDb(requireActivity().applicationContext)
        )
    }
    private var selectedPriority = "low"

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
                        this.etDesc.text.toString(),
                        priority = selectedPriority
                    )
                )
                Toast.makeText(requireContext(), "success add to list", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        selectedPriority = group?.findViewById<RadioButton>(checkedId)?.text.toString()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}