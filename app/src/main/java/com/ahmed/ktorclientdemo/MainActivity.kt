package com.ahmed.ktorclientdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressView = findViewById<ProgressBar>(R.id.progress)

        findViewById<Button>(R.id.btn_getdata).setOnClickListener {
            viewModel.fetchResult()
        }

        viewModel.loading.observe(this){
            if(it){
                progressView.visibility = View.VISIBLE
            } else {
                progressView.visibility = View.GONE
            }
        }

        viewModel.response.observe(this) {
            it?.let {
                for (i in 0 until it.size) {
                    Toast.makeText(this@MainActivity,""+it.get(i).firstname,Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}