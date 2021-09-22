package com.example.profileinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.profileinfo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.save.setOnClickListener { validateInput() }
        binding.clear.setOnLongClickListener{
            clear()
            true }
    }
    fun validateInput(){
        if( binding.email.text.isEmpty()||
            binding.age.text.isEmpty()||
            binding.username.text.isEmpty()||
            binding.firstname.text.isEmpty()||
            binding.lastname.text.isEmpty()) {
            Toast.makeText(this, "fill all the fields", Toast.LENGTH_SHORT).show()
        }
        if(binding.username.text.length>10) {
            Toast.makeText(this, "username must contain less than 10 characters", Toast.LENGTH_SHORT).show()
        }
        if(binding.age.text.isEmpty()){
            Toast.makeText(this, "age must be a positive integer", Toast.LENGTH_SHORT).show()
        }
        val validEmail ="^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})".toRegex()

        if(!validEmail.matches(binding.email.text)){
            Toast.makeText(this, "enter valid email", Toast.LENGTH_SHORT).show()

        }


    }
    fun clear(){
        binding.email.text.clear()
        binding.username.text.clear()
        binding.firstname.text.clear()
        binding.lastname.text.clear()
        binding.age.text.clear()



    }


}