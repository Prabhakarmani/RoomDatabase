package prabhakar.manish.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import androidx.room.TypeConverters
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import prabhakar.manish.roomdatabase.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var database: StudentDatabase
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = StudentDatabase.getDatabase(this)
        GlobalScope.launch {
            database.studentDao().insertStudent(Student(0,42,"manish","12", Date()))
        }
        binding.button.setOnClickListener {
            database.studentDao().getGradeForSerialNumber(1).observe(this,{
                binding.textView.text = it.toString()

            })
        }
    }
}