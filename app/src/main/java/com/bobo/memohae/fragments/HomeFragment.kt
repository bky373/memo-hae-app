package com.bobo.memohae.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bobo.memohae.R
import com.bobo.memohae.adapters.*
import com.bobo.memohae.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = PagerAdapter(this)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
        }.attach()

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            TASK_PAGE_INDEX -> R.drawable.selector_tab_task
            FOLDER_PAGE_INDEX -> R.drawable.selector_tab_folder
            CALENDAR_PAGE_INDEX -> R.drawable.selector_tab_calendar
            BIN_PAGE_INDEX -> R.drawable.selector_tab_bin
            else -> throw IndexOutOfBoundsException()
        }
    }
}
