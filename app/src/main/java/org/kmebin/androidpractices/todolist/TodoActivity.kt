package org.kmebin.androidpractices.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.kmebin.androidpractices.R

class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
    }
}