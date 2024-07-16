package com.pi.androidbasics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CategoriesAcivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories_acivity)
    }
}