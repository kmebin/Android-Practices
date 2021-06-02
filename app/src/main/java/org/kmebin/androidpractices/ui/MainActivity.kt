package org.kmebin.androidpractices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.kmebin.androidpractices.R
import org.kmebin.androidpractices.databinding.ActivityMainBinding
import org.kmebin.androidpractices.ui.user.UserFragment

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