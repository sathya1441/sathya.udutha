package com.daily.todolist.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daily.todolist.entity.ToDoListEntity;
import com.daily.todolist.service.ToDoListService;

@RestController
public class ListController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("/list")
    public List<ToDoListEntity> getList() {
        return toDoListService.getEntireList();
    }

    @GetMapping("/list/{id}")
    public ToDoListEntity getListById(@PathVariable("id") Long listId) {
        return toDoListService.getSelectedListById(listId);
    }

    @PostMapping("/list")
    public ToDoListEntity createList(@RequestBody ToDoListEntity todolist) {
        return toDoListService.createList(todolist);
    }

    @PutMapping("/list/{id}")
    public ToDoListEntity updateListById(@PathVariable("id") Long listId, @RequestBody ToDoListEntity todolist) {
        return toDoListService.updateListByID(listId, todolist);
    }

    @DeleteMapping("/list")
    public String removeAllLists() {
        return toDoListService.removeEntireLists();
    }

    @DeleteMapping("/list/{id}")
    public String removeListById(@PathVariable("id") Long listId) {
        return toDoListService.removeListById(listId);
    }

}
