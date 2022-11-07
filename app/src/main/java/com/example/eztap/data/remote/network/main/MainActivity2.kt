package com.example.eztap.data.remote.network.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.eztap.R
import com.example.eztap.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    var mBinding: ActivityMain2Binding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        //getting back the data from activity
        mBinding!!.tvName.text = intent.extras!!.getString("Name")
        mBinding!!.tvPhone.text = intent.extras!!.getString("Phone")
        mBinding!!.tvCity.text=intent.extras!!.getString("City")


    }
}