package org.kmebin.androidpractices

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _user = MutableLiveData<List<Data>>()
    val user: LiveData<List<Data>>
        get() = _user

    fun getUser() {
        job = Coroutines.ioThenMain(
            { repository.getUser(2).data }, // work
            { _user.value = it } // callback
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}