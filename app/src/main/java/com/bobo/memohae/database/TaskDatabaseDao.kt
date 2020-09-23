package com.bobo.memohae.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bobo.memohae.domain.Task

@Dao
interface TaskDatabaseDao {

    @Insert
    fun insert(task: Task)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM task_table WHERE taskId = :key")
    fun getTaskWithId(key: Long): Task?

    @Query("SELECT * FROM task_table ORDER BY taskId DESC LIMIT 1")
    fun getLastTask(): Task?

    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("DELETE FROM task_table")
    fun clearAll()
}