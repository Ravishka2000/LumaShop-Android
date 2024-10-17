package com.android.lumashop.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private var prefs: SharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_EMAIL = "user_email"
        const val USER_ID = "user_id"
    }

    // Save user token and email
    fun saveAuthToken(token: String, email: String, userId: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.putString(USER_EMAIL, email)
        editor.putString(USER_ID, userId)
        editor.apply()
    }

    // Fetch the saved user token
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    // Fetch user email
    fun fetchUserEmail(): String? {
        return prefs.getString(USER_EMAIL, null)
    }

    // Fetch user ID
    fun fetchUserId(): String? {
        return prefs.getString(USER_ID, null)
    }

    // Clear the session
    fun clearSession() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}
