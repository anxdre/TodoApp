package anxdre.my.id.todoapp.view.createtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import anxdre.my.id.todoapp.R
import anxdre.my.id.todoapp.databinding.FragmentCreateTodoBinding

class CreateTodoFragment : Fragment(R.layout.fragment_create_todo) {
    private var _binding: FragmentCreateTodoBinding? = null
    private val binding get() = _binding!!

    //TODO::Define sharedViewModel

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

        //TODO::handle add button
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}