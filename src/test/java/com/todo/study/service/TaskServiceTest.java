package com.todo.study.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.todo.study.entity.Todo;
import com.todo.study.repository.TodoRepository;

public class TaskServiceTest {

    @Test
    void deveCriarTask() {

        TodoRepository taskRepository = Mockito.mock(TodoRepository.class);
        TodoService service = new TodoService(taskRepository);

        Todo task = new Todo(null, "Title", "Description test", false);

        when(taskRepository.save(task)).thenReturn(task);

        Todo result = service.save(task);

        assertEquals(task.getId(), result.getId());

    }

}
