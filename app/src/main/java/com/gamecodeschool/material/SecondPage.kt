package com.gamecodeschool.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.gamecodeschool.material.databinding.ActivitySecondPageBinding

class SecondPage : AppCompatActivity() {
    private lateinit var binding: ActivitySecondPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondPageBinding.inflate(layoutInflater)
        setContentView(binding.root)//setContentView(R.layout.activity_second_page)

        val items = listOf("Material", "Design", "Components", "Android")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)

        binding.textField.setAdapter(adapter)
        val dropdownmenu = binding.textField
       // (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        //(textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        dropdownmenu.setOnItemClickListener { adapterView, view, position, id ->
            // val selectedValue = arrayAdapter.getItem(position)
            var selectedValue = adapter.getItem(position)
            val idSelect = adapter.getItemId(position)
            println(selectedValue)
            println(idSelect)
            //adapter.getPosition()
        }
        val material = binding.materialTV
        material.setOnClickListener{
            //adapter.getPosition("Material")
            //dropdownmenu.listSelection(items[0])
            //dropdownmenu.setSelection(1)
            binding.textField.setSelection(1)
        }

    }
}