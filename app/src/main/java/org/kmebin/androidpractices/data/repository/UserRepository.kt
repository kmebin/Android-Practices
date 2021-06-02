package org.kmebin.androidpractices.data.repository

import org.kmebin.androidpractices.data.api.UserApi

class UserRepository(
    private val api: UserApi
) : SafeApiRequest() {
    suspend fun getUser(page: Int) = apiRequest { api.getUser(page) }
}