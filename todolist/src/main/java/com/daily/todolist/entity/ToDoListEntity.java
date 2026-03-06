package com.daily.todolist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long listId;
    @Column(nullable = false)
    private String title;
    
    public Long getListId() {
        return listId;
    }
    public void setListId(Long listId) {
        this.listId = listId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public ToDoListEntity() {
    }

    public ToDoListEntity(Long listId, String title) {
        this.listId = listId;
        this.title = title;
    }
    @Override
    public String toString() {
        return "ToDoListEntity [List_id=" + listId + ", Title=" + title + "]";
    }
    
}