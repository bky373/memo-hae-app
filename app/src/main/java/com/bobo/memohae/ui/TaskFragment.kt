package com.bobo.memohae.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.bobo.memohae.R
import com.bobo.memohae.adapters.TaskAdapter
import com.bobo.memohae.databinding.FragmentTaskBinding
import com.bobo.memohae.viewmodels.TaskViewModel

class TaskFragment : Fragment() {

    private val viewModel: TaskViewModel by lazy {
        val activity = requireNotNull(this.activity)

        ViewModelProvider(
            this,
            TaskViewModel.Factory(activity.application)
        ).get(TaskViewModel::class.java)
    }

    private var viewModelAdapter: TaskAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.tasks.observe(viewLifecycleOwner, Observer { tasks ->
            tasks?.apply {
                viewModelAdapter?.submitList(tasks)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentTaskBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_task, container, false)

        binding.lifecycleOwner = this

        viewModelAdapter = TaskAdapter()

        binding.tasksRv.apply {
            adapter = viewModelAdapter
            addItemDecoration(getItemDivider())
        }

        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getItemDivider(): DividerItemDecoration {
        val itemDivider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        context?.getDrawable(R.drawable.rv_divider)?.let { itemDivider.setDrawable(it) }
        return itemDivider
    }
}
