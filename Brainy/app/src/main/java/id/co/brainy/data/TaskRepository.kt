package id.co.brainy.data

import id.co.brainy.model.MyTask
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TaskRepository {

    private val tasks = mutableListOf<MyTask>()

    fun getAllTasks(): Flow<List<MyTask>>{
        return flowOf(tasks)
    }



}