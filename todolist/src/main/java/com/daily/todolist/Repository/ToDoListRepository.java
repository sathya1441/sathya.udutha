package com.daily.todolist.Repository;

import org.springframework.stereotype.Repository;

import com.daily.todolist.entity.ToDoListEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListEntity, Long> {
}
