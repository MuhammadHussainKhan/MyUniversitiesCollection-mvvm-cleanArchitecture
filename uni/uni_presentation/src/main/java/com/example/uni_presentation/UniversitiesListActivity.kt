package com.example.uni_presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
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
import com.example.uni_presentation.databinding.ActivityUniversitiesListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class UniversitiesListActivity : AppCompatActivity() {

    companion object {
        fun launchActivity(activity: Activity, bundle: Bundle) {
            val intent = Intent(activity, UniversitiesListActivity::class.java)
            intent.putExtras(bundle)
            activity.startActivity(intent)
        }
    }

    @Inject
    lateinit var provider: Navigator.Provider

    private val viewModel: UniversitiesListViewModel by viewModels()
    private lateinit var binding: ActivityUniversitiesListBinding

    private val universityAdapter = UniversityAdapter(object : RecyclerClickListener {
        override fun onItemClickListener(position: Int, item: University) {
            val bundle = Bundle()
            bundle.putString("uniName", item.name)
            provider.getNavActivity(NavActivity.UniversityDetailActivity)
                .navigate(this@UniversitiesListActivity, bundle)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUniversitiesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.swipeRefreshLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initView()
        viewModel.getUniversities()

        observer()
    }


    fun observer() {

        lifecycleScope.launch {
            viewModel.universitiesList.collectLatest {
                when (it) {
                    is UniversityListState.Loading -> {
                        binding.progress.visibility = if (it.isLoading) View.VISIBLE else View.GONE
                    }

                    is UniversityListState.Success -> {
                        binding.progress.visibility = View.GONE
                        universityAdapter.setData(it.list ?: listOf())
                        binding.swipeRefreshLayout.isRefreshing = false
                    }

                    is UniversityListState.Error -> {
                        binding.swipeRefreshLayout.isRefreshing = false
                        binding.progress.visibility = View.GONE
                        Toast.makeText(
                            this@UniversitiesListActivity, "Error..!", Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {}
                }
            }
        }

    }

    private fun initView() {

        binding.recyclerView.adapter = universityAdapter

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getUniversities()
        }
    }

    object GoToUniListActivity : Navigator {
        override fun navigate(activity: Activity, bundle: Bundle) {
            UniversitiesListActivity.launchActivity(activity, bundle)
        }
    }


}