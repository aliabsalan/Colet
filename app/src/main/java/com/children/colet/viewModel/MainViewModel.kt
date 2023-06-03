package com.children.colet.viewModel

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.children.colet.data.Cartoon
import com.children.colet.data.CartoonData
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val TAG = "MainViewModel"

    val _cartoons  = MutableStateFlow(emptyList<Cartoon>())
    val cartoons  :StateFlow<List<Cartoon>> = _cartoons


    //events
    fun onShowCartoons(context:Context){
        try {
            val json = context.assets.open("cartoon_data.json").bufferedReader().use { it.readText() }
            _cartoons.value = Gson().fromJson(json ,CartoonData::class.java).cartoons
        }catch (e:Exception){
            e.printStackTrace()
            Log.i(TAG, "onShowCartoons: AppCrashed")
        }
    }
}