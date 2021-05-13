package org.kmebin.androidpractices.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.kmebin.androidpractices.databinding.ActivityTodoBinding
import org.kmebin.androidpractices.databinding.ItemTodoBinding

class TodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoBinding
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter = TodoAdapter()
        binding.todoList.adapter = todoAdapter
    }
}

data class TodoData(val text: String, var isDone: Boolean)

class TodoAdapter() : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    val todoList = mutableListOf<TodoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.onBind(todoList[position])
    }

    class TodoViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(todoData: TodoData) {
            binding.todoText.text = todoData.text
        }
    }
}