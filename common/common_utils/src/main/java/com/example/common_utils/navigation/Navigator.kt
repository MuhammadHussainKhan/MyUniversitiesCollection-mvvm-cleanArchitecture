package com.example.common_utils.navigation

import android.app.Activity
import android.os.Bundle

interface Navigator {

    fun navigate(activity:Activity, bundle: Bundle = Bundle())

    interface Provider{
        fun getNavActivity(navActivity: NavActivity): Navigator
    }

}