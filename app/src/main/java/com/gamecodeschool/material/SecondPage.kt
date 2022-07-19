package com.gamecodeschool.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.gamecodeschool.material.databinding.ActivitySecondPageBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

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

        val showDialog = binding.showDialog
        showDialog.setOnClickListener {
            //MaterialAlertDialogBuilder(this)
            MaterialAlertDialogBuilder(this,
                R.style.ThemeOverlay_MaterialComponents)
                //R.style.ThemeOverlay_MaterialComponents_Dialog_Alert)
                .setTitle("Perhatian")
                .setMessage("Anda akan delete data item dari database")
                .setNeutralButton("Jangan dong"){dialog,which ->
                    Toast.makeText(this,"ini tombol neutral",Toast.LENGTH_SHORT).show()
                    showSnackbar("ini tombol neutral")
                }
                .setNegativeButton("Cancel"){dialog,which ->
                    Toast.makeText(this,"ini tombol Negative",Toast.LENGTH_SHORT).show()
                    showSnackbar("ini tombol Negative")
                }
                .setPositiveButton("delete"){dialog,which ->
                    Toast.makeText(this,"ini tombol Positive",Toast.LENGTH_SHORT).show()
                    showSnackbar("ini tombol Positive")
                }
                .show()
        }

    }
    private fun showSnackbar(msg:String){
        val rootSecondPage = binding.secondpageRoot
        Snackbar.make(rootSecondPage,msg,Snackbar.LENGTH_SHORT).show()
    }
}