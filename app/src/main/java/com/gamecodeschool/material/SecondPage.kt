package com.gamecodeschool.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
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
            val items = listOf("Material", "Design", "Components", "Android")
            val adapter = ArrayAdapter(this, R.layout.list_item, items)
            binding.textField.setAdapter(adapter)

            var selectedValue = adapter.getItem(position)
            val idSelect = adapter.getItemId(position)
            println(selectedValue)
            println(idSelect)
            //adapter.getPosition()
        }
        val material = binding.materialTV
        material.setOnClickListener{
            dropdownmenu.setText(items[0])
            val items = listOf("Material", "Design", "Components", "Android")
            val adapter = ArrayAdapter(this, R.layout.list_item, items)
            binding.textField.setAdapter(adapter)
            items[0]

        }
        val android = binding.androTV
        android.setOnClickListener {
            val similar = "Android"
            var found = false
            var pointer = 0
            for(search in items.indices){
                if(similar == items[pointer]){
                    found= true
                    Toast.makeText(this, "founded", Toast.LENGTH_SHORT)
                        .show()
                    dropdownmenu.setText(items[pointer])
                    val items = listOf("Material", "Design", "Components", "Android")
                    val adapter = ArrayAdapter(this, R.layout.list_item, items)
                    binding.textField.setAdapter(adapter)
                    break
                }else found = false
                pointer+=1
            }
            if(found == false){
                Toast.makeText(this, "Data value invalid", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}