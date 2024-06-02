package com.example.detail_presentation

import android.R
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.common_db.model.University
import com.example.common_utils.navigation.NavActivity
import com.example.common_utils.navigation.Navigator
import com.example.detail_presentation.databinding.ActivityUniversityDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UniversityDetailActivity : AppCompatActivity() {

    private val viewModel: UniversityDetailViewModel by viewModels()
    private lateinit var binding: ActivityUniversityDetailBinding

    companion object {
        fun launchActivity(activity: Activity, bundle: Bundle = Bundle()) {
            val intent = Intent(activity, UniversityDetailActivity::class.java)
            intent.putExtras(bundle)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUniversityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val uniName = intent.getStringExtra("uniName")
        viewModel.getUniversityDetail(uniName ?: "")
        observer()

    }

    private fun observer() {

        lifecycleScope.launch {
            viewModel.universityDetail.collectLatest {
                when (it) {
                    is UniversityDetailState.Loading -> {
                        binding.progress.visibility = if (it.isLoading) View.VISIBLE else View.GONE
                    }

                    is UniversityDetailState.Success -> {
                        binding.progress.visibility = View.GONE
                        Log.d("UniversityDetail", "observer: Success: ${it.university}")
                        intView(it.university)
                    }

                    is UniversityDetailState.Error -> {
                        binding.progress.visibility = View.GONE
                        Toast.makeText(
                            this@UniversityDetailActivity, "Error..!", Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {}
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun intView(university: University) {
        binding.tvUniName.text = university.name
        binding.tvUniState.text = "State: ${university.stateProvince}"
        binding.tvUniCountry.text = "Country: ${university.country}"
        binding.tvUniCountryCode.text = "Country Code:${university.alphaTwoCode}"
        val webpageAdapter =
            ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, university.webPages)
        binding.listWebpages.adapter = webpageAdapter
        val domainAdapter =
            ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, university.domains)
        binding.listDomains.adapter = domainAdapter

    }

    object GoToUniDetailActivity : Navigator {
        override fun navigate(activity: Activity, bundle: Bundle) {
            launchActivity(activity, bundle)
        }
    }
}