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
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.darleyleal.mygym.R
import com.darleyleal.mygym.databinding.ActivityWelcomeBinding
import com.darleyleal.mygym.view.dicas.AbdominalActivity
import com.darleyleal.mygym.view.dicas.AerobicoActivity
import com.darleyleal.mygym.view.dicas.AlimentacaoActivity
import com.darleyleal.mygym.view.dicas.TreinoActivity

class WelcomeActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        verificarVersaoDoSDK()
        alterarCorDoIcone(R.id.image_home)

        binding.imagePlus.setOnClickListener(this)
        binding.imageGymHalter.setOnClickListener(this)
        binding.imageHome.setOnClickListener(this)

        binding.imageBorba.setOnClickListener(this)
        binding.imageAerobico.setOnClickListener(this)
        binding.imageAlimentacao.setOnClickListener(this)
        binding.imageTreinoAnastase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id in listOf(R.id.image_gym_halter, R.id.image_plus, R.id.image_home)) {
            alterarCorDoIcone(view.id)
        }
        if (view.id == R.id.image_plus) {
            startActivity(Intent(this, NovoExercicioGymActivity::class.java))
        }
        if (view.id == R.id.image_borba) {
            startActivity(Intent(this, AbdominalActivity::class.java))
        }
        if (view.id == R.id.image_aerobico) {
            startActivity(Intent(this, AerobicoActivity::class.java))
        }
        if (view.id == R.id.image_alimentacao) {
            startActivity(Intent(this, AlimentacaoActivity::class.java))
        }
        if (view.id == R.id.image_treino_anastase) {
            startActivity(Intent(this, TreinoActivity::class.java))
        }
        if (view.id == R.id.image_gym_halter) {
            startActivity(Intent(this, TreinoMainActivity::class.java))
        }
    }

    private fun alterarCorDoIcone(id: Int) {
        /**Mantém as cores dos ícones por padrão em branco*/
        binding.imageHome.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )
        binding.imagePlus.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )
        binding.imageGymHalter.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )
        /**Quando um ícone for clicado o tom laranja será atribuído,
         *  indicando ao usuário em qual tela ele está*/
        when (id) {
            R.id.image_home -> {
                binding.imageHome.setColorFilter(
                    ContextCompat.getColor(
                        this, R.color.orange_800
                    )
                )
            }

            R.id.image_gym_halter -> {
                binding.imageGymHalter.setColorFilter(
                    ContextCompat.getColor(
                        this, R.color.orange_800
                    )
                )
            }

            R.id.image_plus -> {
                binding.imagePlus.setColorFilter(
                    ContextCompat.getColor(
                        this, R.color.orange_800
                    )
                )
            }

            else -> {
                throw IllegalArgumentException("Opção inválida!")
            }
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun verificarVersaoDoSDK() {
        if (Build.VERSION.SDK_INT >= 23) {
            val window: Window = window
            window.navigationBarColor = Color.parseColor("#4E342E")
        }
    }
}