package br.com.hacksmiles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Form1ViewState {
    val title: LiveData<String> = MutableLiveData()
}