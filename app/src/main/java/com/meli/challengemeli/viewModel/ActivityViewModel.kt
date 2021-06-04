package com.meli.challengemeli.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {

    private val mutableActionBarStatus = MutableLiveData<ActionBarStatus>()
    val actionBarStatus: LiveData<ActionBarStatus>
        get() = mutableActionBarStatus

    fun setActionBarStatus(actionBarData: ActionBarStatus) {
        mutableActionBarStatus.value = actionBarData
    }

}

data class ActionBarStatus(val title: String = "", val isVisible: Boolean = false)