package com.example.prod;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface TaskDao {
    //вставка
    @Insert
    Completable addTask(Task task);

    //вывод задачи по имени
    @Query("SELECT * FROM task_table WHERE name = :name")
    Observable<Task> getTaskById (String name);

    // Метод чтения всех задач из таблицы
    @Query("SELECT * FROM task_table")
    Observable<List<Task>> getAllTasks();

    // Метод изменения значения isCompleted (статус выполнения текущей задачи) в имеющейся записи по id
    @Query("UPDATE task_table SET isDone = :isDone WHERE name = :name")
    Completable setIsDone(boolean isDone, String name);
}
