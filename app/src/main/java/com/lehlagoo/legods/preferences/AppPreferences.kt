package com.lehlagoo.legods.preferences

import android.content.Context
import android.preference.PreferenceManager

const val PROFILE_NAME = "profile_name"

class AppPreferences(context: Context) {
    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveProfileName(profileName: String) =
        sharedPreferences.edit().putString(PROFILE_NAME, profileName).apply()

    fun getProfileName(): String = sharedPreferences.getString(PROFILE_NAME, "") ?: ""
}