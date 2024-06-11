package com.courses.videocallingcomposeapp.di

import com.courses.videocallingcomposeapp.VideoCallingApplication
import com.courses.videocallingcomposeapp.viewmodel.ConnectViewModel
import com.courses.videocallingcomposeapp.viewmodel.VideoCallViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    factory {
        val app = androidContext().applicationContext as VideoCallingApplication
        app.client
    }

    viewModelOf(::ConnectViewModel)
    viewModelOf(::VideoCallViewModel)

}