package com.akash.kooapp.view.activity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akash.kooapp.R
import com.akash.kooapp.databinding.ActivityHomeBinding
import com.akash.kooapp.model.home.HomeDataModel
import com.akash.kooapp.model.home.HomeResponseModel
import com.akash.kooapp.utils.Helper
import com.akash.kooapp.view.adapter.HomeAdapter
import java.util.*

class HomeActivity : AppCompatActivity() {

    lateinit var activityHomeBinding: ActivityHomeBinding

    lateinit var adapter: HomeAdapter
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.categoryResponse.observe(this, androidx.lifecycle.Observer {
            activityHomeBinding.progressBar.visibility = View.GONE
            activityHomeBinding.recyclerView.visibility = View.VISIBLE
            val layoutManager = LinearLayoutManager(applicationContext)
            activityHomeBinding.recyclerView.layoutManager = layoutManager

            var dataList = homeViewModel.categoryResponse.value!!.data
            adapter = HomeAdapter(applicationContext,
                    dataList as ArrayList<HomeDataModel>)
            activityHomeBinding.recyclerView.adapter = adapter
        })

        if(Helper.isOnline(applicationContext)) {
            try { apiPostList() } catch (e: Exception) { e.printStackTrace() }
        }else{
            Helper.toastMsg(applicationContext, getString(R.string.no_internet))
        }
    }


    fun apiPostList(){
        activityHomeBinding.progressBar.visibility = View.VISIBLE
        observeResponse()
    }

    fun observeResponse(){
        homeViewModel.getPostList(applicationContext)
    }
}