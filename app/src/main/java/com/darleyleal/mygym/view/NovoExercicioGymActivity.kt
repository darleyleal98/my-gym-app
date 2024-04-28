package com.darleyleal.mygym.view

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.darleyleal.mygym.R
import com.darleyleal.mygym.databinding.ActivityNovoExercicioGymBinding
import com.darleyleal.mygym.viewModel.NovoExercicioViewModel

class NovoExercicioGymActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityNovoExercicioGymBinding
    private lateinit var viewModel: NovoExercicioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()

        binding = ActivityNovoExercicioGymBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        verificarVersaoDoSDK()

        viewModel = ViewModelProvider(this)[NovoExercicioViewModel::class.java]

        binding.imageBack.setOnClickListener(this)
        binding.button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.image_back) {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun verificarVersaoDoSDK() {
        if (Build.VERSION.SDK_INT >= 23) {
            val window: Window = window
            window.statusBarColor = Color.parseColor("#4E342E")
        }
    }
}