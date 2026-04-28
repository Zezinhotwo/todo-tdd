package com.todo.study.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pomodoro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    private String description;
    @NotNull
    private Integer prioridade;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalDateTime pomodoro;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate start;

    public Pomodoro() {
    }

    public Pomodoro(Long id, @NotBlank String title, String description, Integer prioridade, LocalDateTime pomodoro,
            LocalDate start) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prioridade = prioridade;
        this.pomodoro = pomodoro;
        this.start = start;
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

    public LocalDateTime getPomodoro() {
        return pomodoro;
    }

    public void setPomodoro(LocalDateTime pomodoro) {
        this.pomodoro = pomodoro;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pomodoro other = (Pomodoro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
