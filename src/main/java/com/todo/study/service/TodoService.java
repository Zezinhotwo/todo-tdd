package com.todo.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todo.study.entity.Todo;
import com.todo.study.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo save(Todo obj) {
        return todoRepository.save(obj);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo update(Long id, Todo newObj) {
        Todo oldTodo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR: Object Not Found"));

        oldTodo.setTitle(newObj.getTitle());
        oldTodo.setDescription(newObj.getDescription());
        oldTodo.setPrioridade(newObj.getPrioridade());
        oldTodo.setCompleted(newObj.isCompleted());
        oldTodo.setStart(newObj.getStart());
        oldTodo.setEnd(newObj.getEnd());

        return todoRepository.save(oldTodo);
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
