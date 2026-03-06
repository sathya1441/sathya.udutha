package com.daily.todolist.service;

import java.util.List;

import com.daily.todolist.entity.ToDoListEntity;

public interface ToDoListService {

    public List<ToDoListEntity> getEntireList();

    public ToDoListEntity createList(ToDoListEntity todolist);

    public String removeListById(Long listId);

    public ToDoListEntity updateListByID(Long listId, ToDoListEntity todolist);

    public String removeEntireLists();

    public ToDoListEntity getSelectedListById(Long listId);

}
