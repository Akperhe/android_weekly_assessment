package com.smith.profiles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smith.profiles.data_class.CustomNames
import com.smith.profiles.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myProfileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageSource: Array<Int> = arrayOf(
            R.drawable.ic_1,
            R.drawable.ic_2,
            R.drawable.ic_3,
            R.drawable.ic_4,
            R.drawable.ic_5,
            R.drawable.ic_6,
            R.drawable.ic_7,
            R.drawable.ic_8,
            R.drawable.ic_9,
            R.drawable.ic_10,
            R.drawable.ic_11,
            R.drawable.ic_12,
            R.drawable.ic_13,
            R.drawable.ic_14,
            R.drawable.ic_15,
            R.drawable.ic_16,
            R.drawable.ic_17,
            R.drawable.ic_18,
            R.drawable.ic_19,
            R.drawable.ic_20
        )

        val firstName: Array<String> = arrayOf(
            "Paul",
            "Abel",
            "Moses",
            "Smith",
            "Oscar",
            "Merit",
            "Victor",
            "John",
            "Alex",
            "Collins",
            "Joshua",
            "Andre",
            "Wisdom",
            "Mavellous",
            "Kelvin",
            "Amos",
            "Isaac",
            "Joseph",
            "Abraham",
            "Dickson"
        )
        val lastName: Array<String> = arrayOf(
            "Nelson",
            "Blessing",
            "Mable",
            "Hannah",
            "Vivian",
            "Coggio",
            "Emmanuella",
            "Armour",
            "Rema",
            "Juliet",
            "Destiny",
            "Emmanuel",
            "Favour",
            "Josiah",
            "Desire",
            "Andy",
            "John",
            "Grant",
            "Dominion",
            "Gilato"
        )

        val names: List<CustomNames> = listOf(
            CustomNames(
                firstName[0], lastName[0], imageSource[0]
            ),
            CustomNames(
                firstName[1], lastName[1], imageSource[1]
            ),
            CustomNames(
                firstName[2], lastName[2], imageSource[2]
            ),
            CustomNames(
                firstName[3], lastName[3], imageSource[3]
            ),
            CustomNames(
                firstName[4], lastName[4], imageSource[4]
            ),
            CustomNames(
                firstName[5], lastName[5], imageSource[5]
            ),
            CustomNames(
                firstName[6], lastName[6], imageSource[6]
            ),
            CustomNames(
                firstName[7], lastName[7], imageSource[7]
            ),
            CustomNames(
                firstName[8], lastName[8], imageSource[8]
            ),
            CustomNames(
                firstName[9], lastName[9], imageSource[9]
            ),
            CustomNames(
                firstName[10], lastName[10], imageSource[10]
            ),
            CustomNames(
                firstName[11], lastName[11], imageSource[11]
            ),
            CustomNames(
                firstName[12], lastName[12], imageSource[12]
            ),
            CustomNames(
                firstName[13], lastName[13], imageSource[13]
            ),
            CustomNames(
                firstName[14], lastName[14], imageSource[14]
            ),
            CustomNames(
                firstName[15], lastName[15], imageSource[15]
            ),
            CustomNames(
                firstName[16], lastName[16], imageSource[16]
            ),
            CustomNames(
                firstName[17], lastName[17], imageSource[17]
            ),
            CustomNames(
                firstName[18], lastName[18], imageSource[18]
            ),
            CustomNames(
                firstName[19], lastName[19], imageSource[19]
            )
        )
        myProfileAdapter = ProfileAdapter(names)
        binding.recyclerView.adapter = myProfileAdapter

    }
}