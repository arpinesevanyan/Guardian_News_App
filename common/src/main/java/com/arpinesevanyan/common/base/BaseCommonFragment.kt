package com.arpinesevanyan.common.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

abstract class BaseCommonFragment : Fragment() {
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    protected fun navigateFragment(navDirections: NavDirections) {
        navController.navigate(navDirections)
    }
}