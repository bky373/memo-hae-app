package com.bobo.memohae.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.bobo.memohae.database.TaskDatabase
import com.bobo.memohae.domain.Task
import java.lang.IllegalArgumentException

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val dataSource = TaskDatabase.getDatabase(application).taskDatabaseDao

    val tasks: LiveData<List<Task>> = dataSource.getAllTasks()

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TaskViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewModel")
        }
    }
}