package com.example.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.core.Constants

abstract class BaseFragment : Fragment() {

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