package com.darleyleal.mygym.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.darleyleal.mygym.R
import com.darleyleal.mygym.databinding.ActivityTreinoMainBinding
import com.darleyleal.mygym.view.crud.AtualizarTreinoActivity
import com.darleyleal.mygym.view.crud.DeletarActivity

class TreinoMainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityTreinoMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityTreinoMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.imageBack.setOnClickListener(this)
        binding.deleteTask1.setOnClickListener(this)
        binding.editTask1.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.image_back) {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
        if (view.id == R.id.delete_Task_1) {
            startActivity(Intent(this, DeletarActivity::class.java))
        }
        if (view.id == R.id.edit_Task_1) {
            startActivity(Intent(this, AtualizarTreinoActivity::class.java))
        }
    }
}