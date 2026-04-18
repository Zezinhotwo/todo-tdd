package com.todo.study.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    private String description;
    private Integer prioridade;
    private Boolean completed;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime start;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime end;

    public Todo() {
    }

    public Todo(Long id, @NotBlank String title, String description, Integer prioridade, Boolean completed, LocalDateTime start,
            LocalDateTime end) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prioridade = prioridade;
        this.completed = completed;
        this.start = start;
        this.end = end;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Boolean isCompleted() {
        return this.completed;
    }
}
