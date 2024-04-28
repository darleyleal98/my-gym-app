package com.darleyleal.mygym.view.dicas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.darleyleal.mygym.R
import com.darleyleal.mygym.databinding.ActivityAbdominalBinding
import com.darleyleal.mygym.view.WelcomeActivity

class AbdominalActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityAbdominalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAbdominalBinding.inflate(layoutInflater)

        supportActionBar?.hide()

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.imageBack.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.image_back) {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
    }
}