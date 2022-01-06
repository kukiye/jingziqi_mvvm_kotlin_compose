package com.xiangxue.mvx.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import com.xiangxue.mvx.R
import com.xiangxue.mvx.viewmodel.JingziqiViewModelV2

class JingziqiActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JingziqiMainView()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_jingziqi, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reset -> {
                val viewModel: JingziqiViewModelV2? by viewModels()
                viewModel!!.onResetSelected()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}