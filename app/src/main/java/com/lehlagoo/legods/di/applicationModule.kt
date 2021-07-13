package com.lehlagoo.legods.di

import com.lehlagoo.legods.preferences.AppPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module {
    single { AppPreferences(androidContext()) }
}