package com.darleyleal.mygym.view.crud

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.Window
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.darleyleal.mygym.R
import com.darleyleal.mygym.databinding.ActivityAtualizarTreinoBinding
import com.darleyleal.mygym.view.TreinoMainActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AtualizarTreinoActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityAtualizarTreinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        supportActionBar?.hide()

        binding = ActivityAtualizarTreinoBinding.inflate(layoutInflater)

        setContentView(binding.root)
        verificarVersaoDoSDK()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener(this)
        binding.imageBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.image_back) {
            startActivity(Intent(this, TreinoMainActivity::class.java ))
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