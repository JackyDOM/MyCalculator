package com.example.mycalculator

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class menuActivity: AppCompatActivity() {

    private lateinit var bottom: BottomNavigationView
    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //call their ID
        bottom = findViewById(R.id.bottom)
        frameLayout = findViewById(R.id.FrameLayout)

        // set the bottom action
        bottom.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navHome -> loadFragment(HomeFragment(), false)
                R.id.navSearch -> loadFragment(SearchFragment(), false)
                else -> loadFragment(SettingFragment(), false)
            }
            true
        }

        loadFragment(HomeFragment(), true)

    }

    private fun loadFragment(fragment: Fragment, isAppInitialized: Boolean) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        //checking
        if(isAppInitialized)
            fragmentTransaction.add(R.id.FrameLayout, fragment)
        else
            fragmentTransaction.replace(R.id.FrameLayout, fragment)
        fragmentTransaction.commitAllowingStateLoss()
    }
}