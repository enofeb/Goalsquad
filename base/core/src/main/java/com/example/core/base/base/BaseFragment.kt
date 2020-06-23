package com.example.core.com.example.core.base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.core.base.Constants

abstract class BaseFragment : Fragment() {

    @StringRes
    open val titleRes = Constants.NO_RES

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (getLayoutRes() != Constants.NO_RES) {
            return inflater.inflate(getLayoutRes(), null, false)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}