package com.example.myuniversitycollection3.navigation

import com.example.common_utils.navigation.NavActivity
import com.example.common_utils.navigation.Navigator
import com.example.detail_presentation.UniversityDetailActivity
import com.example.uni_presentation.UniversitiesListActivity


class DefaultNavigator : Navigator.Provider {

    override fun getNavActivity(navActivity: NavActivity): Navigator{
        return when (navActivity) {
            NavActivity.UniversityListActivity -> {
                UniversitiesListActivity.GoToUniListActivity
            }

            NavActivity.UniversityDetailActivity -> {
                UniversityDetailActivity.GoToUniDetailActivity
            }
        }
    }
}