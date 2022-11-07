package com.example.eztap.utils

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import com.example.eztap.databinding.DialogAppProgresssBinding

object AppDialog {
    var mLoadingDialog: Dialog? = null

    fun showLoader(context: Context) {
        try {
            if (mLoadingDialog == null) {
                mLoadingDialog = Dialog(context)
                val binding: DialogAppProgresssBinding = DialogAppProgresssBinding.inflate(
                    LayoutInflater.from(context)
                )
                // Get the entire layout
                mLoadingDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
                mLoadingDialog?.setContentView(binding.root)
                mLoadingDialog?.setCancelable(false)
                mLoadingDialog?.setCanceledOnTouchOutside(false)
            }
            mLoadingDialog?.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hideLoader() {
        if (mLoadingDialog != null && mLoadingDialog!!.isShowing)
            mLoadingDialog!!.dismiss()
        mLoadingDialog = null
    }
}