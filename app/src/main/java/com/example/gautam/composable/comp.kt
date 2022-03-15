package com.example.gautam.composable

import android.os.Binder
import android.renderscript.ScriptGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class m():ViewModel(){
    private val _id = MutableLiveData("hi")
    val id: LiveData<String> = _id

    private val _value = MutableLiveData("bye")
    val value: LiveData<String> = _value

    val Idlist: MutableList<String> = mutableListOf()
    val Valuelist: MutableList<String> = mutableListOf()

    fun s() = viewModelScope.launch {
        change()
    }

    private  fun change(){
        Idlist.add(id.value!!)
        Valuelist.add(value.value!!)
    }


}

@Composable
fun swiftPlaces(viewModel: m = viewModel()) {
    viewModel.s()
    val id = viewModel.Idlist
    val value = viewModel.Valuelist

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn(
            modifier = Modifier
                .background(Color.Black)
                .height(300.dp)
                .width(350.dp)
                .clip(RoundedCornerShape(80.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                items = id,
                itemContent = {
                    tems(id = it, value = it)
                }
            )
            items(
                items = value ,
                itemContent = {
                    tems(id = it, value = it)
                }
            )
        }
    }
}

@Composable
fun tems(id:String,value:String) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = AnnotatedString(text = "\n$id\t\t\t\t\t\t\t\t\t\t\t\t\t\t").plus(
                    AnnotatedString(text = "$value")
                ), style = TextStyle(color = Color.White)
            )
        }
}