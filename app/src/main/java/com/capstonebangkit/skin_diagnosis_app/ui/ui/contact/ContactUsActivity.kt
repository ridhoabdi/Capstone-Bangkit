package com.capstonebangkit.skin_diagnosis_app.ui.ui.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.KeyChain.EXTRA_NAME
import android.view.View
import androidx.cardview.widget.CardView
import com.capstonebangkit.skin_diagnosis_app.R
import com.capstonebangkit.skin_diagnosis_app.databinding.ActivityContactUsBinding
import java.lang.reflect.Array.getInt

class ContactUsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityContactUsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(getString(R.string.contact_us))

        val memberSatu : CardView = findViewById(R.id.member1)
        val memberDua : CardView = findViewById(R.id.member2)
        val memberTiga : CardView = findViewById(R.id.member3)
        val memberEmpat : CardView = findViewById(R.id.member4)
        val memberLima : CardView = findViewById(R.id.member5)
        val memberEnam : CardView = findViewById(R.id.member6)

        memberSatu.setOnClickListener(this)
        memberDua.setOnClickListener(this)
        memberTiga.setOnClickListener(this)
        memberEmpat.setOnClickListener(this)
        memberLima.setOnClickListener(this)
        memberEnam.setOnClickListener(this)
    }
    override fun onClick(v: View){
        when (v.id){
            R.id.member1->{
                val moveWithDataIntent = Intent(this, DetailMemberActivity::class.java)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NAME, getString(R.string.member_1))
                moveWithDataIntent.putExtra("image", R.drawable.member1)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_EMAIL, getString(R.string.email_1))
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NOHP, getString(R.string.phone_1))
                startActivity(moveWithDataIntent)
            }

            R.id.member2->{
                val moveWithDataIntent = Intent(this, DetailMemberActivity::class.java)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NAME, getString(R.string.member_2))
                moveWithDataIntent.putExtra("image", R.drawable.member2)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_EMAIL, getString(R.string.email_2))
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NOHP, getString(R.string.phone_2))
                startActivity(moveWithDataIntent)
            }

            R.id.member3->{
                val moveWithDataIntent = Intent(this, DetailMemberActivity::class.java)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NAME, getString(R.string.member_3))
                moveWithDataIntent.putExtra("image", R.drawable.member3)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_EMAIL, getString(R.string.email_3))
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NOHP, getString(R.string.phone_3))
                startActivity(moveWithDataIntent)
            }

            R.id.member4->{
                val moveWithDataIntent = Intent(this, DetailMemberActivity::class.java)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NAME, getString(R.string.member_4))
                moveWithDataIntent.putExtra("image", R.drawable.member4)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_EMAIL, getString(R.string.email_4))
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NOHP, getString(R.string.phone_4))
                startActivity(moveWithDataIntent)
            }

            R.id.member5->{
                val moveWithDataIntent = Intent(this, DetailMemberActivity::class.java)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NAME, getString(R.string.member_5))
                moveWithDataIntent.putExtra("image", R.drawable.member5)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_EMAIL, getString(R.string.email_5))
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NOHP, getString(R.string.phone_5))
                startActivity(moveWithDataIntent)
            }

            R.id.member6->{
                val moveWithDataIntent = Intent(this, DetailMemberActivity::class.java)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NAME, getString(R.string.member_6))
                moveWithDataIntent.putExtra("image", R.drawable.member6)
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_EMAIL, getString(R.string.email_6))
                moveWithDataIntent.putExtra(DetailMemberActivity.EXTRA_NOHP, getString(R.string.phone_6))
                startActivity(moveWithDataIntent)
            }
        }
    }
}