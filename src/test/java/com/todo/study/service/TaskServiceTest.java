package com.todo.study.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.todo.study.entity.Target;
import com.todo.study.repository.TodoRepository;

public class TaskServiceTest {

    LocalDateTime now = LocalDateTime.now();

    @Test
    void deveCriarTask() {
        TodoRepository taskRepository = Mockito.mock(TodoRepository.class);
        TodoService service = new TodoService(taskRepository);

        Target task = new Target(null, "Title", "Description test", 1, false, now, now.plusDays(1));

        when(taskRepository.save(task)).thenReturn(task);

        Target result = service.save(task);

        assertEquals(task.getId(), result.getId());
    }

    @Test
    void deveListarTasks() {
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        TodoService service = new TodoService(todoRepository);

        List<Target> todos = List.of(new Target(null, "Title", "Description test", 1, false, now, now.plusDays(1)));

        when(todoRepository.findAll()).thenReturn(todos);

        List<Target> result = service.findAll();

        assertEquals(1, result.size());
    }

    @Test
    void deveBuscarUmaPorIdTask() {

        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        TodoService service = new TodoService(todoRepository);

        Target todo = new Target(null, "Title", "Description test", 1, false, now, now.plusDays(1));
        Optional<Target> optionalTodo = Optional.of(todo);

        when(todoRepository.findById(todo.getId())).thenReturn(optionalTodo);

        Optional<Target> result = service.findById(todo.getId());

        assertEquals(optionalTodo, result);
    }

    @Test
    void deveAtualizarTask() {
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        TodoService service = new TodoService(todoRepository);

        Target todoExistente = new Target(null, "Title", "Description test", 1, false, now, now.plusDays(1));
        Target todoAtualizado = new Target(null, "New Title", "Description test knew", 1, true, now, now.plusDays(1));

        when(todoRepository.findById(1L))
                .thenReturn(Optional.of(todoExistente));

        when(todoRepository.save(any(Target.class)))
                .thenReturn(todoAtualizado);

        Target result = service.update(1L, todoAtualizado);

        assertEquals("New Title", result.getTitle());
        assertEquals("Description test knew", result.getDescription());
        assertTrue(result.isCompleted());

        verify(todoRepository).findById(1L);
        verify(todoRepository).save(any(Target.class));
    }

    @Test
    void deveDeletarPorId() {
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        TodoService todoService = new TodoService(todoRepository);

        Target todo = new Target(null, "Title", "Old Desc", 1, false, now, now.plusDays(1));

        doNothing().when(todoRepository).deleteById(todo.getId());

        todoService.deleteById(todo.getId());

        verify(todoRepository).deleteById(todo.getId());
    }
}
