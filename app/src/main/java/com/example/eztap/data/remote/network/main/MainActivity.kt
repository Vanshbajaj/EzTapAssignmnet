package com.example.eztap.data.remote.network.main

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.eztap.R
import com.example.eztap.databinding.ActivityMainBinding
import com.example.eztap.utils.AppDialog
import com.google.android.material.snackbar.Snackbar
import com.khiladiadda.data.remote.network.ApiService
import com.khiladiadda.data.remote.network.Resource
import com.naturefit.ui.base.Repository

class MainActivity : AppCompatActivity() {
    var mBinding: ActivityMainBinding? = null
    lateinit var viewModel: ViewModel
    private val repository: Repository = Repository()
    private val dialog: AppDialog = AppDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModel(repository)
        viewModel.getLoginOtp()
        doSendOtpObserver()


        mBinding!!.btn.setOnClickListener {
            if (mBinding!!.etName.text.isNullOrBlank()) {
                Snackbar.make(mBinding!!.logo, "Enter Name", Snackbar.LENGTH_SHORT).show()
            } else if (mBinding!!.etPhone.text.isNullOrBlank()) {
                Snackbar.make(mBinding!!.logo, "Enter Phone", Snackbar.LENGTH_SHORT).show()
            } else if (mBinding!!.etCity.text.isNullOrBlank()) {
                Snackbar.make(mBinding!!.logo, "Enter City", Snackbar.LENGTH_SHORT).show()
            } else {
                //to call the next activity
               val i=Intent(this,MainActivity2::class.java)
                i.putExtra("Name",mBinding!!.etName.text.toString())
                i.putExtra("Phone",mBinding!!.etPhone.text.toString())
                i.putExtra("City",mBinding!!.etCity.text.toString())
                startActivity(i)
            }


        }


    }

    private fun doSendOtpObserver() {
        viewModel.mLoginOtpMutableLiveData.observe(this) {
            when (it) {
                is Resource.Success -> {
                    dialog.hideLoader()
                    Glide.with(this)
                        .load(it.value.logourl).into(mBinding!!.logo);

                    mBinding!!.tvHeadingText.text = it.value.headingtext
                    mBinding!!.tvName.text = it.value.uidata.get(0).value
                    mBinding!!.etName.hint = it.value.uidata.get(1).value
                    mBinding!!.tvPhone.text = it.value.uidata.get(2).value
                    mBinding!!.etPhone.hint = it.value.uidata.get(3).value
                    mBinding!!.tvCity.text = it.value.uidata.get(4).value
                    mBinding!!.etCity.hint = it.value.uidata.get(5).value
                    mBinding!!.btn.text = it.value.uidata.get(6).value
                }
                is Resource.Loading -> {
                    dialog.showLoader(this)
                }
                is Resource.Failure -> {
                    dialog.showLoader(this)
                }

            }

        }
    }
}