package com.bobo.memohae

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.bobo.memohae.database.TaskDatabase
import com.bobo.memohae.database.TaskDatabaseDao
import com.bobo.memohae.domain.Task
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception


@RunWith(AndroidJUnit4::class)
class TaskDatabaseTest {

    private lateinit var taskDao: TaskDatabaseDao
    private lateinit var db: TaskDatabase

    @Before
    fun createDB() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, TaskDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        taskDao = db.taskDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDB() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetTask() {
        // given
        val task = Task(content = "메모")

        // when
        taskDao.insert(task)
        val currentTask = taskDao.getTaskWithId(1)

        // then
        assertEquals(currentTask?.content, "메모")
    }
}
