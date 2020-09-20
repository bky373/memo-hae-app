package com.bobo.memohae.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bobo.memohae.fragments.BinFragment
import com.bobo.memohae.fragments.CalendarFragment
import com.bobo.memohae.fragments.FolderFragment
import com.bobo.memohae.fragments.TaskFragment

const val TASK_PAGE_INDEX = 0
const val FOLDER_PAGE_INDEX = 1
const val CALENDAR_PAGE_INDEX = 2
const val BIN_PAGE_INDEX = 3

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        TASK_PAGE_INDEX to { TaskFragment() },
        CALENDAR_PAGE_INDEX to { CalendarFragment() },
        FOLDER_PAGE_INDEX to { FolderFragment() },
        BIN_PAGE_INDEX to { BinFragment() }
    )

    override fun getItemCount(): Int = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}