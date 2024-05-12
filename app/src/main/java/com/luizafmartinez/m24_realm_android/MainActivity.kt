package com.luizafmartinez.m24_realm_android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luizafmartinez.m24_realm_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)


        binding.btnSalvar.setOnClickListener {

            val nome = binding.editNome.text.toString()

        }


        binding.btnAtualizar.setOnClickListener {

            val nome = binding.editNome.text.toString()

        }

        binding.btnRemover.setOnClickListener {

            val nome = binding.editNome.text.toString()


        }


    }
}