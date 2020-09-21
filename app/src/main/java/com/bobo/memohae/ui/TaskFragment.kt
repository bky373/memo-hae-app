package com.bobo.memohae.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bobo.memohae.R
import com.bobo.memohae.adapters.TaskAdapter
import com.bobo.memohae.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentTaskBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_task, container, false)

        val adapter = TaskAdapter()
        binding.tasksRv.adapter = adapter

        return binding.root
    }
}
