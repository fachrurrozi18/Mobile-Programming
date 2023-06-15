package com.example.usernavigations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2      : ViewPager2
    private lateinit var tabLayout       : TabLayout
    private lateinit var toolbar         : androidx.appcompat.widget.Toolbar
    private lateinit var appPagerAdapter : AppPagerAdapter

    private val titles = arrayListOf("Amerika", "Indonesia", "Japan")

    class AppPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when(position)
            {
                0->Opsi1()
                2->Opsi2()
                3->Opsi3()
                else->Opsi1()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbarMain)
        tabLayout = findViewById(R.id.tabLayoutMain)
        viewPager2 = findViewById(R.id.viewPager2Main)
        toolbar.title = "Read Article"
        setSupportActionBar(toolbar)
        viewPager2.adapter = AppPagerAdapter(this)
        appPagerAdapter = AppPagerAdapter(this)
        TabLayoutMediator(tabLayout,viewPager2){
            tab,position -> tab.text = titles[position]
        }.attach()
    }

}