package org.kmebin.androidpractices.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.user_fragment.*
import org.kmebin.androidpractices.R
import org.kmebin.androidpractices.data.api.UserApi
import org.kmebin.androidpractices.data.model.Data
import org.kmebin.androidpractices.data.repository.UserRepository

class UserFragment : Fragment(), RecyclerviewClickListener {
    
    private lateinit var factory: UserViewModelFactory
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = UserApi()
        val repository = UserRepository(api)
        factory = UserViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            rv_user.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = UserAdapter(user, this)
            }
        })
    }

    override fun onItemClick(view: View, user: Data) {
        Toast.makeText(requireContext(), "${user.id}", Toast.LENGTH_SHORT).show()
    }
}