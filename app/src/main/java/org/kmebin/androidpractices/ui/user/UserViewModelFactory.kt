package org.kmebin.androidpractices.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kmebin.androidpractices.data.repository.UserRepository

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}