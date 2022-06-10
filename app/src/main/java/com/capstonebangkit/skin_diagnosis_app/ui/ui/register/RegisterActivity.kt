package com.capstonebangkit.skin_diagnosis_app.ui.ui.register

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
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityRegisterBinding
import com.capstonebangkit.skin_diagnosis_app.ui.MainActivity
import com.capstonebangkit.skin_diagnosis_app.ui.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
class RegisterActivity : AppCompatActivity() {

    //deskripsi
    lateinit var binding: ActivityRegisterBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()
        playAnimation()

        auth = FirebaseAuth.getInstance()

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        binding.btnRegister.setOnClickListener{
            val nama = binding.nameEditText.text.toString()
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
            RegisterFirebase(nama,email,password)
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
        val regisText1 = ObjectAnimator.ofFloat(binding.registerText1, View.ALPHA, 1f).setDuration(500)
        val regisText2 = ObjectAnimator.ofFloat(binding.registerText2, View.ALPHA, 1f).setDuration(500)
        val nameEdt = ObjectAnimator.ofFloat(binding.nameEditText, View.ALPHA, 1f).setDuration(500)
        val emailEdt = ObjectAnimator.ofFloat(binding.emailEditText, View.ALPHA, 1f).setDuration(500)
        val passEdt = ObjectAnimator.ofFloat(binding.passwordEditText, View.ALPHA, 1f).setDuration(500)
        val btnRegis = ObjectAnimator.ofFloat(binding.btnRegister, View.ALPHA, 1f).setDuration(500)
        val tvHaveAccount = ObjectAnimator.ofFloat(binding.tvHaveAccount, View.ALPHA, 1f).setDuration(500)
        val tvLoginAccount = ObjectAnimator.ofFloat(binding.tvLogin, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(regisText1, regisText2, nameEdt, emailEdt, passEdt, btnRegis, tvHaveAccount, tvLoginAccount)
            start()
        }
    }

    private fun RegisterFirebase(nama: String, email: String, password: String) {
        showLoading(true)
        auth.createUserWithEmailAndPassword( email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Register Berhasil",  Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun showLoading(isLoading: Boolean){
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}