package org.kmebin.androidpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = UserRepository(UserApi())
        GlobalScope.launch(Dispatchers.Main) {
            val user = repository.getUser(2)
            Toast.makeText(this@MainActivity, user.toString(), Toast.LENGTH_LONG).show()
        }
    }
}