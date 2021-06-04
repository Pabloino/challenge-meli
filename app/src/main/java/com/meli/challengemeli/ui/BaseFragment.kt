package com.meli.challengemeli.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.meli.challengemeli.R
import com.meli.challengemeli.viewModel.ActionBarStatus
import com.meli.challengemeli.viewModel.ActivityViewModel

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    private val activityViewModel by activityViewModels<ActivityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityViewModel.setActionBarStatus(getActionBarStatus())
    }

    protected open fun getActionBarStatus() = ActionBarStatus(requireContext().resources.getString(R.string.app_name), true)

}