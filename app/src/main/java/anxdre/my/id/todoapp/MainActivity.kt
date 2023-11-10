package anxdre.my.id.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import anxdre.my.id.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO::Register navigation config

    }

    //TODO::Handle back button
}