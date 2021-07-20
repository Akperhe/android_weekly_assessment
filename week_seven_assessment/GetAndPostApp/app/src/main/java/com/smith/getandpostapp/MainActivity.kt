package com.smith.getandpostapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.smith.getandpostapp.adapter.ItemsItemAdapter
import com.smith.getandpostapp.databinding.ActivityMainBinding
import com.smith.getandpostapp.viewModel.MainActivityViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemsItemAdapter: ItemsItemAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemsItemAdapter = ItemsItemAdapter(listOf())
        binding.recycler.adapter = itemsItemAdapter
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.apply {

            getAllItemItems()
            items.observe(this@MainActivity) { itemsItem ->
                itemsItemAdapter.list = itemsItem
                itemsItemAdapter.notifyDataSetChanged()
                binding.prog.isVisible = false
            }

            binding.postBtn.setOnClickListener {
                try {
                    var classs: String = binding.classs.text.toString()
                    var name: String = binding.name.text.toString()
                    var seat: String = binding.seat.text.toString()

                    postStudent(classs, name, seat.toInt())

                    status.observe(this@MainActivity) { status ->
                        if (status) {
                            Toast.makeText(
                                this@MainActivity,
                                "Successfully Posted",
                                Toast.LENGTH_LONG
                            ).show()

                            binding.classs.setText("")
                            binding.name.setText("")
                            binding.seat.setText("")

                        } else {
                            Toast.makeText(
                                this@MainActivity,
                                "Error in posting: Server Error",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    }
                } catch (e: Exception) {
                    Toast.makeText(
                        this@MainActivity,
                        "Please enter the value all fields",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}