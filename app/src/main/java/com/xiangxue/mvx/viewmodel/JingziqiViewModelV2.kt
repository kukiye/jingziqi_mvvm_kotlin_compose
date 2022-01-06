package com.xiangxue.mvx.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.xiangxue.mvx.model.Board
import java.util.ArrayList

class JingziqiViewModelV2 : ViewModel() {
    private val model: Board = Board()
    val winner = mutableStateOf("")
    val cellList: MutableList<MutableState<String?>> = ArrayList()
    fun onResetSelected() {
        model.restart()
        for (i in 0..8) {
            cellList[i].value = ""
        }
        winner.value = ""
    }

    fun onClickedCellAt(row: Int, col: Int) {
        val playerThatMoved = model.mark(row, col)
        if (playerThatMoved != null) {
            winner.value = (if (model.winner == null) "" else model.winner.toString())
            cellList[row * 3 + col].value =
                if (playerThatMoved == null) null else playerThatMoved.toString()
        }
    }

    init {
        for (i in 0..8) {
            cellList.add(mutableStateOf(""))
        }
    }
}