package com.gamecodeschool.material

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.gamecodeschool.material.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.textInputLayout3.setEndIconOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.textInputEditText4.doOnTextChanged { text, start, before, count ->
            if (text!!.length>10){
                binding.textInputLayout4.error = "no More!"
            }else if (text.length<10){
                binding.textInputLayout4.error = null
            }
            }

        binding.secondBtn.setOnClickListener{
            val intent = Intent(this,SecondPage::class.java)
            startActivity(intent)
        }

//        val iconclick = findViewById<TextInputLayout>(R.id.textInputEditText3)
//        iconclick.setEndIconOnClickListener{
//            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
//        }
    }

}