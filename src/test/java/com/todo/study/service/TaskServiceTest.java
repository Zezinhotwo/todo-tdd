package com.todo.study.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

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

    @Test
    void deveListarTasks() {
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        TodoService service = new TodoService(todoRepository);

        List<Todo> todos = List.of(new Todo(1L, "Title", "Desc", false));

        when(todoRepository.findAll()).thenReturn(todos);

        List<Todo> result = service.findAll();

        assertEquals(1, result.size());
    }

}
