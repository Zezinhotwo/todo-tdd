package com.todo.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.study.entity.Todo;
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

}
