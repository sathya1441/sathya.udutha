package com.daily.todolist.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.todolist.Repository.ToDoListRepository;
import com.daily.todolist.entity.ToDoListEntity;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    @Autowired
    ToDoListRepository toDoListRepository;

    @Override
    public List<ToDoListEntity> getEntireList() {
        return toDoListRepository.findAll();
    }

    @Override
    public ToDoListEntity createList(ToDoListEntity todolist) {
        return toDoListRepository.save(todolist);
    }

    @Override
    public String removeListById(Long listId) {
        toDoListRepository.deleteById(listId);
        return "Deleted Successfully";
    }

    @Override
    public ToDoListEntity updateListByID(Long listId, ToDoListEntity updatedList) {
        ToDoListEntity existingList = toDoListRepository.findById(listId).get();
        if (Objects.nonNull(existingList.getTitle())&&!"".equalsIgnoreCase(existingList.getTitle())) {
            existingList.setTitle(updatedList.getTitle());
            toDoListRepository.save(existingList);
        }
        return existingList;
    }

    @Override
    public String removeEntireLists() {
        toDoListRepository.deleteAll();
        return "All Lists Deleted Successfully";
    }

    @Override
    public ToDoListEntity getSelectedListById(Long listId) {
        return toDoListRepository.findById(listId).get();
    }

}
