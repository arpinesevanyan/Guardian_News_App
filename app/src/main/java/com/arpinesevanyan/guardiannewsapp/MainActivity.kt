package com.arpinesevanyan.guardiannewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.arpinesevanyan.guardiannewsapp.databinding.ActivityMainBinding
import com.arpinesevanyan.guardiannewsapp.ui.activity.NewsActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        GuardianNewsEnum.values().forEach {
            val button = AppCompatButton(this)
            button.text = it.name.replace("_", " ")
            button.tag = it
            binding.linearLayout.addView(button)
            button.setOnClickListener(this)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.tag as GuardianNewsEnum) {
            GuardianNewsEnum.GUARDIAN -> startActivity(
                Intent(this, NewsActivity::class.java)
            )
        }
    }
}

enum class GuardianNewsEnum {
    GUARDIAN
}