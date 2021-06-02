package org.kmebin.androidpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.kmebin.androidpractices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userFragment = UserFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, userFragment)
        transaction.commit()
    }
}