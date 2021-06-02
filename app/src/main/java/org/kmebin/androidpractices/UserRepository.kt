package org.kmebin.androidpractices

class UserRepository(
    private val api: UserApi
) : SafeApiRequest() {
    suspend fun getUser(page: Int) = apiRequest { api.getUser(page) }
}