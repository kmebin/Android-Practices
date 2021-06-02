package org.kmebin.androidpractices.todolist

import android.graphics.Paint
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

        todoAdapter =
            TodoAdapter(onClickDeleteImage = { deleteTodo(it) }, onClickItem = { toggleTodo(it) })
        binding.todoList.adapter = todoAdapter

        binding.addButton.setOnClickListener {
            addTodo()
        }
    }

    private fun addTodo() {
        val todo = binding.todoEditText.text.toString()
        todoAdapter.todoList.add(TodoData(todo))
        todoAdapter.notifyDataSetChanged()
    }

    private fun deleteTodo(todo: TodoData) {
        todoAdapter.todoList.remove(todo)
        todoAdapter.notifyDataSetChanged()
    }

    private fun toggleTodo(todo: TodoData) {
        todo.isDone = !todo.isDone
        todoAdapter.notifyDataSetChanged()
    }
}

data class TodoData(val text: String, var isDone: Boolean = false)

class TodoAdapter(
    private val onClickDeleteImage: (TodoData) -> Unit,
    private val onClickItem: (TodoData) -> Unit
) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    val todoList = mutableListOf<TodoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.onBind(todo)

        holder.binding.todoText.apply {
            paintFlags = if (todo.isDone) paintFlags or Paint.STRIKE_THRU_TEXT_FLAG else 0
        }
        holder.binding.deleteImage.setOnClickListener {
            onClickDeleteImage(todo)
        }
        holder.binding.root.setOnClickListener {
            onClickItem(todo)
        }
    }

    class TodoViewHolder(val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(todoData: TodoData) {
            binding.todoText.text = todoData.text
        }
    }
}