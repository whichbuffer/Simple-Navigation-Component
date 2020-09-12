package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.FavFragment
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val HomeFragment = HomeFragment()
        val SettingsFragment = SettingsFragment()
        val FavFragment = FavFragment()

        makeCurrentFragment(HomeFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home ->makeCurrentFragment(HomeFragment)
                R.id.ic_favorite ->makeCurrentFragment(FavFragment)
                R.id.ic_setting ->makeCurrentFragment(SettingsFragment)
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
}