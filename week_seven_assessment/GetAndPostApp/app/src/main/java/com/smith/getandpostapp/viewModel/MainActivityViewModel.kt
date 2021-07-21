package com.smith.getandpostapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smith.getandpostapp.RetrofitProvider
import com.smith.getandpostapp.dataClass.ItemsItem
import com.smith.getandpostapp.dataClass.StudentsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    val items: MutableLiveData<List<ItemsItem>> = MutableLiveData()
    var status = MutableLiveData<Boolean>()

    fun getAllItemItems() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val itemsItem: List<ItemsItem> = RetrofitProvider.services.getAllItems()
                items.postValue(itemsItem)
            }
        } catch (e: Exception) {
            Log.e("ViewModel", e.message.toString())
        }
    }

    fun postStudent(classs: String, name: String, seat: Int) {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                var studentPOST = StudentsItem(classs, name, seat)
                var call = RetrofitProvider.services.postStudent(studentPOST)

                call.enqueue(object : Callback<StudentsItem> {

                    override fun onResponse(
                        call: Call<StudentsItem>,
                        response: Response<StudentsItem>
                    ) {
                        //the server bring an a null body on response when posted
                        // which aslo prompt the on failure method to run
                        status.value = true
                    }

                    override fun onFailure(call: Call<StudentsItem>, t: Throwable) {
                        //the server brings a null body else the post has been posted
                        status.value = true
                    }
                }
                )
            }
        } catch (e: Exception) {
            Log.e("ViewModel", e.message.toString())
        }
    }
}