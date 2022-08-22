package com.example.harbourspace.unsplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.harbourspace.R

class MainActivity : AppCompatActivity() {

    private val unsplashViewModel : UnsplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        findViewById<RecyclerView>(R.id.rv_container).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = MainAdapter(emptyList()) {
                Toast.makeText(context, getString(R.string.main_item_clicked, it), Toast.LENGTH_SHORT).show()
                openDetailsActivity()
            }
        }

        unsplashViewModel.unsplashItems.observe(this) {
            val adapter = findViewById<RecyclerView>(R.id.rv_container).adapter as MainAdapter
            adapter.submitList(it)
        }

        unsplashViewModel.error.observe(this) {
            Toast.makeText(baseContext, R.string.main_unable_to_fetch_images, Toast.LENGTH_SHORT).show()
        }
    }

    private fun openDetailsActivity() {
        startActivity(Intent(this, DetailsActivity::class.java))
    }
}