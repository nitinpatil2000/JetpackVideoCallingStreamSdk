package com.courses.videocallingcomposeapp.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.courses.videocallingcomposeapp.VideoCallingApplication
import com.courses.videocallingcomposeapp.connect.ConnectAction
import com.courses.videocallingcomposeapp.connect.ConnectState

class ConnectViewModel(
    private val app: Application
) : AndroidViewModel(app) {

    var state by mutableStateOf(ConnectState())
        private set

    fun onAction(action: ConnectAction) {
        when (action) {
            ConnectAction.OnConnectClick -> {
                connectRoom()
            }

            is ConnectAction.OnNameChange -> {
                state = state.copy(name = action.name)
            }
        }
    }

    private fun connectRoom() {
        state = state.copy(errorMessage = null)
        if (state.name.isBlank()) {
           state =  state.copy(errorMessage = "Username can't be blank.")
            return
        }

        (app as VideoCallingApplication).initVideoClient(state.name)

        //todo when it is true then go to the next screen
        state = state.copy(isConnected = true)

    }
}