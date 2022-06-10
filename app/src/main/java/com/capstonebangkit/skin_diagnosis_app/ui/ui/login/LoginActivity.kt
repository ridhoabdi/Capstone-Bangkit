package com.capstonebangkit.skin_diagnosis_app.ui.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityLoginBinding
import com.capstonebangkit.skin_diagnosis_app.ui.MainActivity
import com.capstonebangkit.skin_diagnosis_app.ui.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()
        playAnimation()

        auth = FirebaseAuth.getInstance()

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener{
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isEmpty()) {
                binding.emailEditText.error = "Email Harus diisi"
                binding.emailEditText.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.emailEditText.error = "Email tidak Valid"
                binding.emailEditText.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                binding.passwordEditText.error = "Password Harus diisi"
                binding.passwordEditText.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6){
                binding.passwordEditText.error = "Password Minimal 6 Karakter"
                binding.passwordEditText.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email,password)
        }

    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun playAnimation() {
        val loginText1 = ObjectAnimator.ofFloat(binding.loginText1, View.ALPHA, 1f).setDuration(500)
        val imgLogin = ObjectAnimator.ofFloat(binding.image2, View.ALPHA, 1f).setDuration(500)
        val emailEdt = ObjectAnimator.ofFloat(binding.emailEditText, View.ALPHA, 1f).setDuration(500)
        val passEdt = ObjectAnimator.ofFloat(binding.passwordEditText, View.ALPHA, 1f).setDuration(500)
        val btnLogin = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(500)
        val tvHaventAccount = ObjectAnimator.ofFloat(binding.tvHaventAccount, View.ALPHA, 1f).setDuration(500)
        val tvRegis = ObjectAnimator.ofFloat(binding.tvRegister, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(loginText1, imgLogin, emailEdt, passEdt, btnLogin, tvHaventAccount, tvRegis)
            start()
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        showLoading(true)
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat Datang $email",  Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }


    private fun showLoading(isLoading: Boolean){
        binding.progressBarLogin.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}