package com.meli.challengemeli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.meli.challengemeli.viewModel.ActivityViewModel

class MainActivity : AppCompatActivity() {

    private val activityViewModel by viewModels<ActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpActionBar()
    }

    private fun setUpActionBar() {
        activityViewModel.actionBarStatus.observe(this) { actionBarStatus ->
            supportActionBar?.let { actionBar ->
                actionBar.title = actionBarStatus.title
                if (actionBarStatus.isVisible) actionBar.show() else actionBar.hide()
            }
        }
    }
}